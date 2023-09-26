# FD-Java-RaspberryPi : Chapter 6 Maven

## Install Maven On Raspberry Pi

```shell
$ sudo apt install maven
```

* if Error --> Try

```
https://maven.apache.org/download.cgi
```

```shell
$ wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz

$ pwd
/home/solokope
$ cd /opt
$ sudo tar -xzvf /home/solokope/apache-maven-3.9.4-bin.tar.gz

sudo etc/profile.d/nano maven.sh
```

then add 

```
M2_HOME=/opt/apache-maven-3.9.4
PATH=$PATH:$M2_HOME/bin
```

Sava, after that : sudo reboot

```shell
$ mvn -v
Apache Maven 3.9.4 (dfbb324ad4a7c8fb0bf182e6d91b0ae20e3d2dd9)
Maven home: /opt/apache-maven-3.9.4
Java version: 13-BellSoft, vendor: BellSoft, runtime: /usr/lib/jvm/bellsoft-java13-arm32-vfp-hflt
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.1.21-v8+", arch: "arm", family: "unix"
```

## Generate a new Maven project

```shell
$ mvn archetype:generate -DgroupId=be.webtechie -DartifactId=java-maven-minimal -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

$ cd java-maven-minimal/
$ code .
```

## Add application logging with Maven and log4j

```shell
$ mvn archetype:generate -DgroupId=be.webtechie -DartifactId=java-maven-logging -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

The pom-file needs to be extended with this Maven dependency:

```
<dependencies>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.17.1</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <release>11</release>
            </configuration>
        </plugin>
    </plugins>
</build>
```

```shell
$ mvn clean package
```