# What is "AKKA Pi on Gradle"?

A sample AKKA project based on AKKA docs that calculates Pi using actors and is built as a multi project Gradle beast

## Why would I do such a thing?

+ To demostrate the ultimate power of Gradle in Scala world
+ As well as to throw AKKA in a mix to get a full "scratch" / "start up" kit

## Can I see some action?

```
$ git clone git@github.com:anatoly-polinsky/akka-pi-on-gradle.git
```

```
$ gradle run

  Pi approximation: 	3.1415926435897883
	Calculation time: 	596 milliseconds
```

If you don't have Gradle installed, you can simply do:

```
$ ./gradlew run
```

