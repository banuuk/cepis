#!/bin/sh

javac -cp .. *.java
java -cp .. com.mytutorial.test.TestCase
rm -f *.class
