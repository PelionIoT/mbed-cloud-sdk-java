# Foundation Generator
The foundation generator is responsible for creating much of the SDK code for Java. It takes input from specification files contained within the config directory. Note that the specifications are constantly changing both in content and in structure as the SDK generation process evolves. Therefore you should make no lasting assumptions about their content or structure.

## Advantages
The foundation interface offers several advantages to cloud application developers:

* A more consistent interface to common operations, with consistent naming and access semantics
* A more stable interface that significantly reduces application maintenance effort while allowing change to the underlying REST API.
* A more logical grouping of operations which is not dictated by the underlying service organisation.

## Foundation generator configuration
The configuration information is taken from the cloud API repo under sdk/foundation_configs. Each configuration file describes a list of foundation entities (eg account, user). For each entity there is a list of the operations that the entity offers, and a mapping to the underlying API call that provides this functionality. There is also a method of renaming API fields to give a more consistent user experience.

## Running the generator
The generator is a project in Java and uses gradle to orchestrate builds and running. To ensure the correct versions of gradle and other tools are in place, a wrapper script ``./gradlew`` is provided.

To run the generator, use ``./gradlew run``

When the generator has run, you will probably want to run ``./gradlew spotlessApply`` to apply the standard code formatting to the generated files. This ensures that the outputs can be sensibly diff'ed against previous versions.

## What is generated
The generator generates java files into the following projects:

* foundation-models: the higher-level foundation layer object
* backends: the low-level interfaces generated directly from Swagger descriptions
* sdk/src: user-facing interface to the foundation API.

These should then be compiled in the usual way to create the SDK that is supplied to the end-user.

## Generator internals - how it works - Java
See [here](docs/java\ foundation\ code\ generation.png) for a diagram.

Although the foundation layer is generated in each of the SDK languages, this description applies only to the Java SDK.

Swagger files are produced for the REST API from which a thin layer of interface code is generated. This code is in Java, but is structurally the same as the underlying REST API. The Java foundation generator builds on the output from the swagger code generator and uses further configuration information to gather together operations that can cross multiple endpoints. 
