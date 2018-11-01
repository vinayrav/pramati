# 1.What is groupid and artifactid?
groupId:
A unique base name of the company or group that created the project 
It will identify the project uniquely across all projects,
artifactId:
A unique name of the project
It is the name of the jar without version.

# 2.Why Archetype Artifactid?
Archetype is a Maven project templating toolkit. 
An archetype is defined as an original pattern or model from which all other things of the same kind are made. 
The name fits as we are trying to provide a system that provides a consistent means of generating Maven projects
Maven tries to avoid as much configuration as possible, by supplying project templates named archetypes.

Archetypes are packaged up in a JAR and they consist of the archetype metadata which describes the contents of archetype, and a set of Velocity templates which make up the prototype project.
ref:https://maven.apache.org/guides/introduction/introduction-to-archetypes.html

# 3.Why do we use interactive mode?
   If you don’t know which parameters to provide, you can always specify interactiveMode=true, so that Maven asks for all the required parameters.
# 4.Any other parameters in maven other than package?

# 5.What is a goal in maven?
Goals are executed in phases which help determine the order goals get executed in.
The compile phase goals will always be executed before the test phase goals which will always be executed before the package phase goals and so on.
Part of the confusion is eliminated by the fact that when you execute maven you can specify a goal or a phase. If you specify a phase then maven will run all phases up to the phase you specified in order (e.g. if you specify package it will first run through the compile phase and then the test phase and finally the package phase) and for each phase it will run all goals attached to that phase.

**validate**
Validates that the project is correct and all necessary information is available. This also makes sure the dependencies are downloaded.
**compile**
Compiles the source code of the project.
**test**
Runs the tests against the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
**package**
Packs the compiled code in its distributable format, such as a JAR.
**install**
Install the package into the local repository, for use as a dependency in other projects locally.
**deploy**
Copies the final package to the remote repository for sharing with other developers and projects.

# 6.How to use remote repository in maven?
Apart from central repository, you may have needed artifacts deployed on other remote locations.
For example, in your corporate office there may be projects or modules specific to organization only.
In this cases, organization can create remote repository and deploy these private artifacts. 
This remote repository will be accessible only inside organization.

These maven remote repository work exactly same way as maven’s central repository. Whenever an artifact is needed from these repositories, it is first downloaded to developer’s local repository and then it is used.

You can configure a remote repository in the POM file or super POM file in remote repository itself.
<repositories>
   <repository>
       <id>org.source.repo</id>
       <url>*link*</url>
   </repository>
</repositories>

# 7.Maven vs Ant vs Gradle
**Maven**
    Dependencies management does not handle conflicts well between different versions of the same library.
    Customization of targets (goals) is hard
**Gradle**
    Gradle does not use XML. Instead, it had its own DSL based on Groovy (one of JVM languages). 
    As a result, Gradle build scripts tend to be much shorter and clearer than those written for Ant or Maven.
**Ant**
    XML being hierarchical in nature, is not a good fit for procedural programming approach.
    XML tends to become unmanageably big when used with big projects.



