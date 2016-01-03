# RobotLogger <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a>
A Java implementation of a light-weight logging system for FRC Robots. C++ Library coming soon^TM. Copyright (C) Brennan Macaig under the CC-BY-SA license.

=======
RobotLogger was created because my team needed error logging for our code. Implementing an enterprise solution like `log4j` was just impractical at the level of "I just need this to work" that our team required. Meet RobotLogger, my (maybe-not-so)elegant solution to a simple problem.

For our development branch (that may be unstable) please see the [dev1.0 branch](https://github.com/brennan-macaig/RobotLogger/tree/dev1.0). Lots of things are bound to change between this (currently ALPHA) release and the final 1.0 release.

## Features
RobotLogger has a few things by default that make it better than other solutions, such as...

* Expandable - modify it to your needs, add more levels, add another command, or just leave it like it is!
* Configuration file - it actually includes a config file so that you don't have to go digging through code to change something on the fly!
* Safe-exit - If the program gets an exit notice (like a incorrectly written filepath) it just shuts down, no harm done. No errors in code are generated, text is just simply not logged.
* USB-Logging and USB-Safety Mode - Log safely to USBs, and if no USB drives are found don't cause code to crash!


## Installation & Usage
**Installation Method 1: Pre-built**

If you're happy how RobotLogger comes out-of-the-box, you can download one of our releases (it should be noted that this code works on Windows, MacOSX, Linux (tested on Debian and Arch) as well as the RoboRIO) in JAR format. In your IDE include this JAR in your build path. For eclipse (my IDE of choice), right click your project > Configure Build Path... > Add External Jar > and select your JAR file. Then hit "OK".

**Installation Method 2: From Source**

If you want to change or add something, then install the code from source. Download an archive (zip or tarball) and unpack it into your working directory. From there, simply use it as if it were code you wrote.

**Usage**

Use is pretty straightforward. Initialize, then log. Here's an example

```java
public static void myMethod() {
  RobotLogger.init(); // Initialize the code
  RobotLogger.log("This is a message with a low priority!", "LOW");
}
```

## Contribution

Contributing is pretty easy. Just pull request and add your changes. I'll get around to merging it at some point. Please just read over some of the code and format it with a similar style. Please.
