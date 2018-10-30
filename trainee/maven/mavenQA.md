# 1.Where is the jar hosted in Maven?
**Spring**
http://central.maven.org/maven2/org/springframework/spring-webmvc/5.1.1.RELEASE/
**Hibernate**
http://central.maven.org/maven2/org/hibernate/hibernate-core/5.3.7.Final/

# 2.In local repository where will the jar stored?

/home/vinayr/.m2/repository

# 3.How you build the project?(command use)
## Creating a Project
 **You will need somewhere for your project to reside, create a directory somewhere and start a shell in that directory. On your command line, execute the following Maven goal:**

  *mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false*

**If you have just installed Maven, it may take a while on the first run. This is because Maven is downloading the most recent artifacts (plugin jars and other files) into your local repository. You may also need to execute the command a couple of times before it succeeds. This is because the remote server may time out before your downloads are complete. Don't worry, there are ways to fix that.
You will notice that the generate goal created a directory with the same name given as the artifactId. Change into that directory.**

  *cd my-app*

**Build the Project**
  *mvn package*
**You may test the newly compiled and packaged JAR with the following command:**
  *java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App*

*ref:*https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

# 4.How you will verify the jar?

5.use the jar built in other project?

6.build in one macihne use it in another machine?

(old)

7.other build tools(like maven)
Gradle
intelliJ idea

