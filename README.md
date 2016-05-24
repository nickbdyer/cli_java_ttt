#TicTacToe in Java

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/07dfccca9d3e4a1bb18cf9a77093187d)](https://www.codacy.com/app/nbdyer/cli_java_ttt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=nickbdyer/cli_java_ttt&amp;utm_campaign=Badge_Grade) [![Coverage Status](https://coveralls.io/repos/github/nickbdyer/cli_java_ttt/badge.svg?branch=master)](https://coveralls.io/github/nickbdyer/cli_java_ttt?branch=master) [![Build Status](https://travis-ci.org/nickbdyer/cli_java_ttt.svg?branch=master)](https://travis-ci.org/nickbdyer/cli_java_ttt)

###Clone

```shell
$ cd <folder where you want to store the project>

$ git clone https://github.com/nickbdyer/java_ttt.git

$ cd java_ttt/
```

This project has a Gradle Wrapper embedded, so you can run the project and tests without having Gradle on your path.

###Compile
```shell
$ ./gradlew build
```

###Run Program
```shell
$ java -jar build/libs/java_ttt.jar
```
Or
```shell
$ ./gradlew --console plain run
```

###Test Program
To see the results in the command line:
```shell
$ ./gradlew cleanTest test
```
Or in your browser:
```shell
$ open reports/tests/index.html
```



