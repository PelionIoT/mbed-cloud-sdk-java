package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public LowLevelAPIMethod(Method m) {
        this(determineName(m), determineReturnType(m), determineMethodArguments(m), determineModule(m));
    }

    protected static String determineModule(Method m) {
        return m == null ? null : m.getDeclaringClass().getName();
    }

    protected static String determineName(Method m) {
        return m == null ? null : m.getName();
    }

    protected static LowLevelAPIMethodArgument determineReturnType(Method m) {
        return m == null ? null : new LowLevelAPIMethodArgument(null, m.getReturnType(),
                                                                (ParameterizedType) m.getGenericReturnType());
    }

    private static List<LowLevelAPIMethodArgument> determineMethodArguments(Method m) {
        if (m == null || m.getParameterCount() == 0) {
            return null;
        }
        return Arrays.asList(m.getParameters()).stream()
                     .map(p -> new LowLevelAPIMethodArgument(p.getName(), p.getType(), getParameterizedParameter(p)))
                     .collect(Collectors.toList());
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

    /**
     * @return the moduleClass
     */
    public String getModuleClass() {
        return moduleClassName;
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
