# CREATING JAR FILE IN MAVEN 
In this step, you start Eclipse and create a Maven project. You will add the necessary dependencies, and build the project. The build will produce a .jar, which is your deployment package.

# 1.Create a new Maven project in Eclipse.
```
 From the File menu, choose New, and then choose Project.
 In the New Project window, choose Maven Project.
 In the New Maven Project window, choose Create a simple project, and leave other default selections.
 In the New Maven Project, Configure project windows, type the following
**Artifact information:**
- Group Id: doc-examples
- Artifact Id: lambda-java-example
- Version: 0.0.1-SNAPSHOT
- Packaging: jar
- Name: lambda-java-example
```
 # 2.  Add the aws-lambda-java-core dependency to the pom.xml file.
```
  It provides definitions of the RequestHandler, RequestStreamHandler, and Context interfaces. This allows you to compile code that you can use with AWS Lambda.
        Open the context (right-click) menu for the pom.xml file, choose Maven, and then choose Add Dependency.
        In the Add Dependency windows, type the following values:
        Group Id: com.amazonaws
        Artifact Id: aws-lambda-java-core
        Version: 1.1.0
```
# 3.Add Java class to the project.
```
 Open the context (right-click) menu for the src/main/java subdirectory in the project, choose New, and then choose Class.
        In the New Java Class window, type the following values:
            Package: example
            Name: Hello
```
# 4.Build the project.
```
  Open the context (right-click) menu for the project in Package Explorer, choose Run As, and then choose Maven Build .... In the Edit Configuration window, type package in the Goals box.
```
   
