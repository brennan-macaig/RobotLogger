# RobotLogger <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a>
A Java implementation of a light-weight logging system for FRC Robots. C++ Library coming soon^TM. Copyright (C) Brennan Macaig under the CC-BY-SA license.

RobotLogger was created because my team needed error logging for our code. Implementing an enterprise solution like `log4j` was just impractical at the level of "I just need this to work" that our team required. Meet RobotLogger, my (maybe-not-so)elegant solution to a simple problem.

For our development branch (that may be unstable) please see the [dev1.0 branch](https://github.com/brennan-macaig/RobotLogger/tree/dev1.0). Lots of things are bound to change between this (currently ALPHA) release and the final 1.0 release.

## Features
RobotLogger has a few things by default that make it better than other solutions, such as...

* Expandable - modify it to your needs, add more levels, add another command, or just leave it like it is!
* Configuration file - it actually includes a config file so that you don't have to go digging through code to change something on the fly!
* Safe-exit - If the program recieves an exit notice (like a incorrectly written filepath) it just shuts down, no harm done. No errors in code are generated, text is just simply not logged.

And I've got some more stuff coming, including

* USB-Safety Mode - attempt to find a USB once, and if none is found either exit or log to a local path.
* Ping-phone - Try to alert your phone or Driver Station when the logger could not be initialized, with error reporting.

## Installation & Usage
**Installation Method 1: Pre-built**

If you're happy how RobotLogger comes out-of-the-box, you can download one of our releases (it should be noted that this code works on Windows, MacOSX, Linux (tested on Debian and Arch) as well as the RoboRIO) in JAR format. In your IDE include this JAR in your build path. For eclipse (my IDE of choice), right click your project > Configure Build Path... > Add External Jar > and select your JAR file. Then hit "OK".

**Installation Method 2: From Source**
So you want to change something to fit your needs without decompiling. I get it.

Firstly, if you think something needs to be added / changed PLEASE add it as a pull request. I'm always interested to see new ideas!

Secondly, installing from source couldn't be easier. Simply download the ZIP or Tarball of the sourcecode, and then add it to your code base like any file you've written and are importing. Change what you want, and then use the logger as-normal (adding whatever code you need for your custom implementations to work).

**Basic Usage**

Using the logger is fairly straightforward. There are three basic steps to the logging software:

1. Initialize
2. Send commands
3. Execute commands

Only two of these steps are required of you, #1&#2. Here's an example of how these steps are execuited

```java
public static RobotLogger log;
public static someMethod() { // This is probably your main method
  log.init(); // Init the logger
  log.commandHandle("log", "Boy howdy! You're logging a message to a file!", "INFO"); // Log a message
  // Optionally, you can log.exitClean("low", "Give a reason for stopping all further logging");, however this will stop any future logging.
}
```

Let's go through the above example.

Firstly, you have to initialize the logger with `init()`. Next, you have to use `commandHandle()` to send a command to the logger.

I went with a command based system for a few reasons.

1. It allows for future expansion and easy code-addition/customization
2. It looks pretty cool

## Contributing

Feel free to contribute! Pull request like normal.
