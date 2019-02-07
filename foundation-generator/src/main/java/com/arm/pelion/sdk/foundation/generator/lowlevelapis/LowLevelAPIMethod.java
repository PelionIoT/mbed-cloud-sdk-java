package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.util.Logger;

import retrofit2.Call;

public class LowLevelAPIMethod {
    private String name;
    private LowLevelAPIMethodArgument returnArgument;
    private List<LowLevelAPIMethodArgument> arguments;
    private String moduleClassName;

    public LowLevelAPIMethod(String name, LowLevelAPIMethodArgument returnArgument,
                             List<LowLevelAPIMethodArgument> arguments, String moduleClassName) {
        super();
        setName(name);
        setReturnArgument(returnArgument);
        setArguments(arguments);
        setModuleClass(moduleClassName);
    }

    public LowLevelAPIMethod() {
        this(null, null, null, null);
    }

    public LowLevelAPIMethod(Method m) throws UnknownAPIException {
        this(determineName(m), determineReturnType(m), determineMethodArguments(m), determineModule(m));
    }

    protected static String determineModule(Method m) {
        return m == null ? null : m.getDeclaringClass().getName();
    }

    protected static String determineName(Method m) {
        return m == null ? null : m.getName().trim();
    }

    protected static LowLevelAPIMethodArgument determineReturnType(Method m) throws UnknownAPIException {

        final Class<?> returnTypeClass = (m == null) ? null : m.getReturnType();
        if (m != null && !Call.class.isAssignableFrom(returnTypeClass)) {
            throw new UnknownAPIException("The return type of the low level API is not " + Call.class.getName());
        }
        final ParameterizedType returnType = m == null ? null : (ParameterizedType) m.getGenericReturnType();
        try {
            return m == null ? null
                             : new LowLevelAPIMethodArgument(null,
                                                             Class.forName(returnType.getActualTypeArguments()[0].getTypeName()),
                                                             null);
        } catch (Exception exception) {
            throw new UnknownAPIException("Could not determine the actual return type of the low level API "
                                          + returnType + "; caused by " + exception.toString());
        }
    }

    private static List<LowLevelAPIMethodArgument> determineMethodArguments(Method m) {
        if (m == null || m.getParameterCount() == 0) {
            return null;
        }
        return Arrays.asList(m.getParameters()).stream()
                     .map(p -> new LowLevelAPIMethodArgument(determineParameterName(p), p.getType(),
                                                             getParameterizedParameter(p)))
                     .collect(Collectors.toList());
    }

    protected static String determineParameterName(Parameter p) {
        if (!p.isNamePresent()) {
            Logger.getLogger()
                  .logError("Missing name for " + p + ". Ensure the project is compiled with the -parameter option.");
        }
        return p.getName();
    }

    protected static ParameterizedType getParameterizedParameter(Parameter p) {
        return p.getParameterizedType() instanceof ParameterizedType ? (ParameterizedType) p.getParameterizedType()
                                                                     : null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean isGetter() {
        return name == null ? false : name.toLowerCase(Locale.UK).startsWith("get");
    }

    public boolean isSetter() {
        return name == null ? false : name.toLowerCase(Locale.UK).startsWith("set");
    }

    /**
     * @return the moduleClass
     */
    public String getModuleClass() {
        return moduleClassName;
    }

    public Class<?> getModuleClazz() {
        try {
            return moduleClassName == null ? null : Class.forName(moduleClassName);
        } catch (ClassNotFoundException exception) {
            return null;
        }
    }

    /**
     * @param moduleClass
     *            the moduleClass to set
     */
    public void setModuleClass(String moduleClassName) {
        this.moduleClassName = moduleClassName;
    }

    /**
     * @return the returnArgument
     */
    public LowLevelAPIMethodArgument getReturnArgument() {
        return returnArgument;
    }

    /**
     * @param returnArgument
     *            the returnArgument to set
     */
    public void setReturnArgument(LowLevelAPIMethodArgument returnArgument) {
        this.returnArgument = returnArgument;
    }

    /**
     * @return the arguments
     */
    public List<LowLevelAPIMethodArgument> getArguments() {
        return arguments;
    }

    /**
     * @param arguments
     *            the arguments to set
     */
    public void setArguments(List<LowLevelAPIMethodArgument> arguments) {
        this.arguments = arguments;
    }

    public void addArgument(LowLevelAPIMethodArgument argument) {
        if (argument == null) {
            return;
        }
        if (arguments == null) {
            arguments = new LinkedList<>();
        }
        arguments.add(argument);
    }

    public boolean hasArguments() {
        return arguments != null && !arguments.isEmpty();
    }

    public int determineNumberOfArguments() {
        return (arguments == null) ? 0 : arguments.size();
    }

    public Method fetchMethod() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        if (moduleClassName == null || name == null || name.isEmpty()) {
            return null;
        }
        Class<?>[] argTypes = fetchArgsType();
        final Class<?> moduleClass = Class.forName(moduleClassName);
        return (argTypes == null) ? moduleClass.getMethod(name) : moduleClass.getMethod(name, argTypes);

    }

    private Class<?>[] fetchArgsType() throws ClassNotFoundException {
        int argsNumber = determineNumberOfArguments();
        if (argsNumber == 0) {
            return null;
        }
        List<Class<?>> argsTypeArray = new ArrayList<>(argsNumber);
        for (LowLevelAPIMethodArgument arg : arguments) {
            argsTypeArray.add(arg.determineClass());
        }
        return argsTypeArray.toArray(new Class[] {});
    }

    public boolean hasFromModels() {
        final List<LowLevelAPIMethodArgument> list = getFromModels();
        return list != null && !list.isEmpty();
    }

    public List<LowLevelAPIMethodArgument> getFromModels() {
        if (arguments == null) {
            return null;
        }
        return arguments.stream().filter(a -> a.isOpenApiModel()).collect(Collectors.toList());
    }

    public boolean hasToModel() {
        return getToModel() != null;
    }

    public LowLevelAPIMethodArgument getToModel() {
        return returnArgument == null || !returnArgument.isOpenApiModel() ? null : returnArgument;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LowLevelAPIMethod [name=" + name + ", returnArgument=" + returnArgument + ", arguments=" + arguments
               + ", moduleClassName=" + moduleClassName + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((arguments == null) ? 0 : arguments.hashCode());
        result = prime * result + ((moduleClassName == null) ? 0 : moduleClassName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((returnArgument == null) ? 0 : returnArgument.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LowLevelAPIMethod)) {
            return false;
        }
        LowLevelAPIMethod other = (LowLevelAPIMethod) obj;
        if (arguments == null) {
            if (other.arguments != null) {
                return false;
            }
        } else if (!arguments.equals(other.arguments)) {
            return false;
        }
        if (moduleClassName == null) {
            if (other.moduleClassName != null) {
                return false;
            }
        } else if (!moduleClassName.equals(other.moduleClassName)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (returnArgument == null) {
            if (other.returnArgument != null) {
                return false;
            }
        } else if (!returnArgument.equals(other.returnArgument)) {
            return false;
        }
        return true;
    }

}
