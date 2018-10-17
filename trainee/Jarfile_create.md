**creating a jar file in eclipse**
```
1. Create new project with a package name
2. Right click on package and add new class file
3. Create one or more class files with all the functions in each file
4. Then right click on the project and export it as jar file and choose the location
   -Expand the Java node and select JAR file. Click Next
   -In the JAR File Specification page, select the resources that you want to export in the Select the resources to export field.
   -In the Select the export destination field, either type or click Browse to select a location for the JAR file. 
    *project->export->java->JAR file->choose destination*
```
**using jar file in another application or project**
```
1. Create a new project
2. Right click and go to properties-->java bulid path-->libraries and add External Jarfile
3. Then in the project import the jar file classes with the package name(s) specified in jar file 
```
**creating Jarfile in CMD**
```
The basic format of the command for creating a JAR file is:

*jar cf jar-file input-file(s)*

The options and arguments used in this command are:
1. The c option indicates that you want to create a JAR file.
2. The f option indicates that you want the output to go to a file rather than to stdout.
3. jar-file is the name that you want the resulting JAR file to have. You can use any filename for a JAR file. By convention, JAR filenames are given a .jar extension, though this is not required.
4. The input-file(s) argument is a space-separated list of one or more files that you want to include in your JAR file. The input-file(s) argument can contain the wildcard * symbol. If any of the "input-files" are directories, the contents of those directories are added to the JAR archive recursively.
```
# Creating runnable Jar file:
**creating runnable jar file and running it**
```
1. create new project with a package name
2. right click on package and add new class file
3. create one or more class files with all the functions in each file
4. Then right click on the project and export it as Runnable Jarfile and choose the manifest attribute from which application or project or java file the jarfile should run and create it
```
# Runnable jar with cmd
**reference link**
```
*https://docs.oracle.com/javase/tutorial/deployment/jar/build.html*
```

**To create runnable jar with cmd with resourecs**
```
> note:
1. put all the .class files of main and manifest with 'main-class:xxxxx' included and required packages with the class files in one directory and run then from that directory
2. If main file is inside package or directory,specify in manifest file 'main-class:' as [eg:if main class (test.class) is in sample     folder,     then include 'main-class: sample.test']'main-class: sample.test'
> cvfm uses:
1. The 'c' option indicates that you want to create a JAR file.
2. The 'f' option indicates that you want the output to go to a file rather than to stdout.
3. The 'v' Produces verbose output on stdout while the JAR file is being built. The verbose output tells you the name of each file as it's added to the JAR file.
4. The 'm' Used to include manifest information from an existing manifest file. The format for using this option is:
*jar cmf jar-file existing-manifest input-file(s)*
5. In Manifest file include 'main-class: class-name'
```

