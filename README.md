# RobotLogger <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a>
A Java implementation of a light-weight logging system for FRC Robots. C++ Library coming soon^TM. Copyright (C) Brennan Macaig under the CC-BY-SA license.

*This is a dev branch. Please keep reading for what that means*

RobotLogger was created because my team needed error logging for our code. Implementing an enterprise solution like `log4j` was just impractical at the level of "I just need this to work" that our team required. Meet RobotLogger, my (maybe-not-so)elegant solution to a simple problem.

## This is a development branch
This branch is where I'm working on features for the next big release. That means this code is NOT stable, and should NOT be used in any code base. Please, don't use this.

Please see the to-do list for a list of meaningful contribution that you can make, and also a list of things I am working on.

## TO-DO List

* ~~Add USB-mode, with safe-USB attachments~~ DONE! Completed by Brennan Macaig, 1/2/16
* ~~remove commandHandler, and update that system to be more efficient.~~ DONE! Completed by Brennan Macaig, 1/2/16
* Ping-phone feature (probably not going to happen this season though).

### Things that have changed

Logging system is different now. Just call `RobotLogger.log(String message, String level);` rather than worrying about the janky commandHandler system.

## Contributing
Feel free to contribute! Pull request like normal. If you added something from my to-do list then feel free to crosss it off here.
