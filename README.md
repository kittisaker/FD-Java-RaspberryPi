# FD-Java-RaspberryPi : Chapter 7 : About JavaFX

## Minimal JavaFX 11 sample application
GluonHQ has been working on a system to quickly get started with an “empty” JavaFX application with some plugins, in a few easy steps.

### Add new archetypes to Maven

First, we need to add some archetypes to our Maven. Open your terminal or cmd box and perform these commands:

```shell
$ git clone https://github.com/openjfx/javafx-maven-archetypes.git
$ cd javafx-maven-archetypes
$  mvn clean install
```

### Creating an empty application

In the terminal or cmd box you can now create a basic JavaFX project with the following command:

```shell
$  mvn archetype:generate -DarchetypeGroupId=org.openjfx -DarchetypeArtifactId=javafx-archetype-simple -DarchetypeVersion=0.0.1 -DgroupId=be.webtechie -DartifactId=javafx-minimal -Dversion=0.0.1
```

You can define the values for groupId, artifactId and version yourself, the given values above are just examples.

After running the above script a new Java Maven project is created for you with a pom-file and the first Java source files.

### Running the empty application from Visual Studio Code
Make sure you are working with Java 11 JDK (or higher) on your development machine

```shell
$ java -versioin
```

You can start the application with the “Run|Debug” popup from within Visual Studio Code.
Or you can do the same with the Maven command “mvn javafx:run”:

```
...javafx-minimal $ mvn javafx:run
```

And the running application will appear on your screen.

In the application, the version of your installed Java JDK and JavaFX are displayed.

### Example 1: TilesFX dashboard

Let’s start with a first Java + JavaFX + GPIO example!

This is the application we are going to build: a dashboard with tiles (from TilesFX), an input from a push button and an output with an LED.

Wiring and testing in terminal

Let’s add some hardware to use some of the full power of the Pi. With some basic components we
add an LED and a push-button, connected like this:
 * <b>GPIO22 (WiringPi n° 3)</b> > resistor > LED > ground
 * 3.3V > push button > <b>GPIO24 (WiringPi n° 5)</b>

To test if we connected the LED in the correct direction, we can plug in a cable between a 3.3V pin
and GPIO22. If the LED doesn’t turn on, we need to swap it.

Turn LED on GPIO22 on (1) and off (0):

```shell
$ gpio mode 3 out
$ gpio write 3 1
$ gpio write 3 0
```

Read the button state (1 = pressed, 0 = not pressed):

```shell
$ gpio mode 5 in
$ gpio read 5
1
```

## Blink an LED with Java

<details>
<summary>HelloWorld.java</summary>

```java
import java.io.IOException;

public class HelloGpio {
    public static void main (String[] args) {
        System.out.println("Hello Gpio");

        try {
            Runtime.getRuntime().exec("gpio mode 3 out");

            var on = true;

            for (var loopCounter = 0; loopCounter < 5; loopCounter++) {
                System.out.println("Changing LED to " + (on ? "on" : "off"));
                Runtime.getRuntime().exec("gpio write 3 " + (on ? "1" : "0"));

                on = !on;

                Thread.sleep(1000);
            }
        } catch (IOException ex) {
            System.err.println("IOException from Runtim: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.err.println("InterruptedException from Thread: " + ex.getMessage());
        }
    }
}
```

</details>

```shell
$ java HelloGpio.java
```

### Building our first JavaFX application

Let’s start by making a copy of the “javafx-minimal” application we created with the GluonHQ-tool.

added to the pom.xml file, where the javafx-controls dependency is already included. We also need to add the javafx-web dependency as this is used by TilesFX.

While we are working in the pom.xml file, we also change the artifactId as we copied this project from the javafx-minimal application and we add the build-plugins.

<details>
<summary>pom.xml</summary>

```xml
...
<artifactId>javafx-dashboard</artifactId>
...
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>11.0.2</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-web</artifactId>
        <version>11.0.2</version>
    </dependency>
    <dependency>
        <groupId>eu.hansolo</groupId>
        <artifactId>tilesfx</artifactId>
        <version>11.13</version>
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

        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>2.2.1</version>
            ...
        </plugin>
    </plugins>
</build>
```

</details>

#### Add a GPIO helper class
In HelloGpio.java we were able to turn an LED on and off with a small piece of code. But to be able to handle exceptions and read the state of a GPIO, we need some more code. We create a new class “Gpio.java”. This will use the “gpio” commands we used before in the terminal, but controlled with Java. This is just a first “quick-win”.

We start with the package name and the imports we need. Within the class we will add the methods we need.

```java
package be.webtechie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
* Change a pin state using WiringPi and command line calls
* http://wiringpi.com/the-gpio-utility/
*/
public class Gpio {
    
}
```

We need one big method to run the gpio commands and handle the result. E.g. if we run “gpio read 5” we want to know if “1” or “0” is returned by gpio. We call this the “execute” method. It is a private static method because it will only be used by other static methods inside Gpio.java. The return of this method is a String, so we can handle the value depending on the type of result we are expecting.

To avoid memory leaks where Java blocks memory which is no longer needed, the closing of the stream and reader is done in the finally block which gets called even if an error occurs.
