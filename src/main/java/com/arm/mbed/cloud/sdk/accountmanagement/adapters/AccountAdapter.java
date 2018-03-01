package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import com.arm.mbed.cloud.sdk.accountmanagement.model.Account;
import com.arm.mbed.cloud.sdk.accountmanagement.model.AccountStatus;
import com.arm.mbed.cloud.sdk.accountmanagement.model.MultifactorAuthenticationStatus;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo.MfaStatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq;

@Preamble(description = "Adapter for account model")
@Internal
public final class AccountAdapter {

    private AccountAdapter() {
        super();
    }

    /**
     * Maps account objects.
     * 
     * @param accountInfo
     *            accountInfo.
     * @return an account.
     */
    public static Account map(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return null;
        }
        final Account account = new Account(accountInfo.getId(), toStatus(accountInfo.getStatus()),
                accountInfo.getCustomerNumber(), accountInfo.getSalesContact(), accountInfo.getContractNumber(),
                accountInfo.getReferenceNote(), accountInfo.getTier(),
                TranslationUtils.toDate(accountInfo.getCreatedAt()),
                TranslationUtils.toDate(accountInfo.getUpgradedAt()),
                TranslationUtils.toDate(accountInfo.getUpdatedAt()), accountInfo.getLimits(),
                PolicyAdapter.mapList(accountInfo.getPolicies()), accountInfo.getTemplateId(), accountInfo.getReason());
        account.setDisplayName(accountInfo.getDisplayName());
        account.setContact(accountInfo.getContact());
        account.setCompany(accountInfo.getCompany());
        account.setPhoneNumber(accountInfo.getPhoneNumber());
        account.setPostcode(accountInfo.getPostalCode());
        account.setAddressLine1(accountInfo.getAddressLine1());
        account.setAddressLine2(accountInfo.getAddressLine2());
        account.setCity(accountInfo.getCity());
        account.setState(accountInfo.getState());
        account.setCountry(accountInfo.getCountry());
        account.setEmail(accountInfo.getEmail());
        account.setAliases(accountInfo.getAliases());
        account.setCustomProperties(accountInfo.getAccountProperties());
        account.setExpiryWarning(
                TranslationUtils.toLong(accountInfo.getExpirationWarningThreshold(), Account.DEFAULT_EXPIRY_WARNING));
        account.setMultifactorAuthenticationStatus(toMultifactorAuthenticationStatus(accountInfo.getMfaStatus()));
        account.setNotificationEmails(accountInfo.getNotificationEmails());
        return account;
    }

    /**
     * Gets mapper.
     * 
     * @return a mapper.
     */
    public static Mapper<AccountInfo, Account> getMapper() {
        return new Mapper<AccountInfo, Account>() {

            @Override
            public Account map(AccountInfo toBeMapped) {
                return AccountAdapter.map(toBeMapped);
            }

        };
    }

    private static AccountStatus toStatus(StatusEnum status) {
        if (status == null) {
            return AccountStatus.getUnknownEnum();
        }
        switch (status) {
            case ACTIVE:
                return AccountStatus.ACTIVE;
            case ENROLLING:
                return AccountStatus.ENROLLING;
            case RESTRICTED:
                return AccountStatus.RESTRICTED;
            case SUSPENDED:
                return AccountStatus.SUSPENDED;
            default:
                return AccountStatus.getUnknownEnum();
        }

    }

    private static MultifactorAuthenticationStatus toMultifactorAuthenticationStatus(MfaStatusEnum mfaStatus) {
        if (mfaStatus == null) {
            return MultifactorAuthenticationStatus.getUnknownEnum();
        }
        switch (mfaStatus) {
            case ENFORCED:
                return MultifactorAuthenticationStatus.ENFORCED;
            case OPTIONAL:
                return MultifactorAuthenticationStatus.OPTIONAL;
            default:
                break;

        }
        return MultifactorAuthenticationStatus.getUnknownEnum();
    }

    private static AccountUpdateReq.MfaStatusEnum toMfaStatus(
            MultifactorAuthenticationStatus multifactorAuthenticationStatus) {
        if (multifactorAuthenticationStatus == null) {
            return null;
        }
        switch (multifactorAuthenticationStatus) {
            case ENFORCED:
                return com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq.MfaStatusEnum.ENFORCED;
            case OPTIONAL:
                return com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq.MfaStatusEnum.OPTIONAL;
            case UNKNOWN_ENUM:
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * Reverses mapping.
     * 
     * @param updateAccount
     *            an updated account.
     * @return an account update request.
     */
    public static AccountUpdateReq reverseMap(Account updateAccount) {
        if (updateAccount == null) {
            return null;
        }
        final AccountUpdateReq accountUpdateReq = new AccountUpdateReq();
        accountUpdateReq.setDisplayName(updateAccount.getDisplayName());
        accountUpdateReq.setAliases(updateAccount.getAliases());
        accountUpdateReq.setCompany(updateAccount.getCompany());
        accountUpdateReq.setContact(updateAccount.getContact());
        accountUpdateReq.setEmail(updateAccount.getEmail());
        accountUpdateReq.setPhoneNumber(updateAccount.getPhoneNumber());
        accountUpdateReq.setAddressLine1(updateAccount.getAddressLine1());
        accountUpdateReq.setAddressLine2(updateAccount.getAddressLine2());
        accountUpdateReq.setCity(updateAccount.getCity());
        accountUpdateReq.setState(updateAccount.getState());
        accountUpdateReq.setPostalCode(updateAccount.getPostcode());
        accountUpdateReq.setCountry(updateAccount.getCountry());
        accountUpdateReq.setAccountProperties(updateAccount.getCustomProperties());
        accountUpdateReq.setExpirationWarningThreshold(toWarningExpiry(updateAccount));
        accountUpdateReq.setMfaStatus(toMfaStatus(updateAccount.getMultifactorAuthenticationStatus()));
        accountUpdateReq.setNotificationEmails(updateAccount.getNotificationEmails());

        return accountUpdateReq;
    }

    private static String toWarningExpiry(Account updateAccount) {
        return (updateAccount.getExpiryWarning() == 0) ? null : String.valueOf(updateAccount.getExpiryWarning());
    }

}
