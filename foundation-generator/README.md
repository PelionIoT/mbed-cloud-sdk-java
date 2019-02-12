# Foundation Generator
The generator is responsible for creating much of the SDK code for Java. It takes input from specification files contained within the config directory. Note that the specifications are constantly changing both in content and in structure as the SDK generation process evolves. Therefore you should make no lasting assumptions about their content or structure.

## Running the generator
The generator is a project in Java and uses gradle to orchestrate builds and running. To ensure the correct versions of gradle and other tools are in place, a wrapper script ``./gradlew`` is provided.

To run the generator, use ``./gradlew run``

When the generator has run, you will probably want to run ``./gradlew spotlessApply`` to apply the standard code formatting to the generated files. This ensures that the outputs can be sensibly diff'ed against previous versions.

## What is generated
The generator generates java files into the following projects:
* foundation-models
* backends
* sdk/src

