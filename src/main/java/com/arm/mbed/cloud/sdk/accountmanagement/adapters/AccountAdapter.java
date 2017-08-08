package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import com.arm.mbed.cloud.sdk.accountmanagement.model.Account;
import com.arm.mbed.cloud.sdk.accountmanagement.model.AccountStatus;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.internal.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.model.AccountInfo.StatusEnum;
import com.arm.mbed.cloud.sdk.internal.model.AccountUpdateReq;

@Preamble(description = "Adapter for account model")
public class AccountAdapter {

    public static Account map(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return null;
        }
        Account account = new Account();
        account.setId(accountInfo.getId());
        account.setStatus(toStatus(accountInfo.getStatus()));
        account.setDisplayName(accountInfo.getDisplayName());
        account.setContact(accountInfo.getContact());
        account.setCompany(accountInfo.getCompany());
        account.setPhoneNumber(accountInfo.getPhoneNumber());
        account.setPostCode(accountInfo.getPostalCode());
        account.setAddressLine1(accountInfo.getAddressLine1());
        account.setAddressLine2(accountInfo.getAddressLine2());
        account.setCity(accountInfo.getCity());
        account.setState(accountInfo.getState());
        account.setCountry(accountInfo.getCountry());
        account.setEmail(accountInfo.getEmail());
        account.setProvisioningAllowed(TranslationUtils.toBool(accountInfo.getIsProvisioningAllowed(), true));
        account.setAliases(accountInfo.getAliases());
        account.setTierLevel(accountInfo.getTier());
        account.setCreatedAt(TranslationUtils.toDate(accountInfo.getCreatedAt()));
        account.setUpgradedAt(TranslationUtils.toDate(accountInfo.getUpgradedAt()));
        account.setLimits(accountInfo.getLimits());
        account.setTemplateId(accountInfo.getTemplateId());
        return account;
    }

    private static AccountStatus toStatus(StatusEnum status) {
        AccountStatus correspondingStatus = null;
        switch (status) {
            case ACTIVE:
                correspondingStatus = AccountStatus.ACTIVE;
                break;
            case ENROLLING:
                correspondingStatus = AccountStatus.ENROLLING;
                break;
            case RESTRICTED:
                correspondingStatus = AccountStatus.RESTRICTED;
                break;
            case SUSPENDED:
                correspondingStatus = AccountStatus.SUSPENDED;
                break;
            default:
                correspondingStatus = AccountStatus.SUSPENDED;
                break;
        }
        return correspondingStatus;
    }

    public static AccountUpdateReq reverseMap(Account updateAccount) {
        if (updateAccount == null) {
            return null;
        }
        AccountUpdateReq accountUpdateReq = new AccountUpdateReq();
        accountUpdateReq.setDisplayName(updateAccount.getDisplayName());
        accountUpdateReq.setAliases(updateAccount.getAliases());
        accountUpdateReq.setCompany(updateAccount.getCompany());
        accountUpdateReq.setContact(updateAccount.getContact());
        accountUpdateReq.setEmail(updateAccount.getEmail());
        accountUpdateReq.setPhoneNumber(updateAccount.getPhoneNumber());
        accountUpdateReq.setAddressLine1(updateAccount.getAddressLine1());
        accountUpdateReq.setAddressLine2(updateAccount.getAddressLine2());
        accountUpdateReq.setCity(accountUpdateReq.getCity());
        accountUpdateReq.setState(accountUpdateReq.getState());
        accountUpdateReq.setPostalCode(updateAccount.getPostCode());
        accountUpdateReq.setCountry(updateAccount.getCountry());
        return accountUpdateReq;
    }
}
