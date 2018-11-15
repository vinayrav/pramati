
# Install OpenJDK 8, the latest and recommended version #

**1.First, update the package index.**
sudo apt-get update
**2.Next, install Java. Specifically, this command will install the Java Runtime Environment (JRE).**
  sudo apt-get install default-jre
 
**3.There is another default Java installation called the JDK (Java Development Kit). The JDK is usually only needed if you are going to compile Java programs or if the software that will use Java specifically requires it.The JDK does contain the JRE, so there are no disadvantages if you install the JDK instead of the JRE, except for the larger file size.**
*You can install the JDK with the following command:*
  sudo apt-get install default-jdk


			# Installing the Oracle #
If you want to install the Oracle JDK, which is the official version distributed by Oracle, you will need to follow a few more steps.

**1.First, add Oracle's PPA, then update your package repository.**

    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update

**2.Then, depending on the version you want to install, execute one of the following commands:**
                                 Oracle JDK 8
This is the latest stable version of Java at time of writing, and the recommended version to install. You can do so using the following command:

    sudo apt-get install oracle-java8-installer
*ref:https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04*

# Install OpenJDK 8, the latest and recommended version #

**1.First, update the package index.**
  sudo apt-get update
  

**2.Next, install Java. Specifically, this command will install the Java Runtime Environment (JRE).**
  sudo apt-get install default-jre
 
**3.There is another default Java installation called the JDK (Java Development Kit). The JDK is usually only needed if you are going to compile Java programs or if the software that will use Java specifically requires it.The JDK does contain the JRE, so there are no disadvantages if you install the JDK instead of the JRE, except for the larger file size.**
*You can install the JDK with the following command:*
  sudo apt-get install default-jdk



                         
			# Installing the Oracle #
If you want to install the Oracle JDK, which is the official version distributed by Oracle, you will need to follow a few more steps.

**1.First, add Oracle's PPA, then update your package repository.**

    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update

**2.Then, depending on the version you want to install, execute one of the following commands:**
                                 Oracle JDK 8
This is the latest stable version of Java at time of writing, and the recommended version to install. You can do so using the following command:

    sudo apt-get install oracle-java8-installer




*ref:https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04*

