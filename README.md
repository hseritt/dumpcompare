# DumpCompare

This makes a comparison of two different Alfresco JMX dump files. I've provided a directory called 'dumps' that have a few of my own vanilla, ootb Alfresco installs. I've provided those for your convenience but know that they will reflect my environment (usernames, passwords, paths, etc.).

From the command line you can do:

```
# java -jar dumpcompare.jar
```

This will render a list of options and version of DumpCompare:

```
$ ./dumpcompare.sh 
dumcompare.jar : Shows a difference in properties between two jmxdump files.
  Version: 0.0.1
  Output values will be separated by a ':'
Usage: 
  java -jar dumpcompare.jar [target file] [source file]
```

Example Usage:

```
# java -jar dumpcompare.jar YourJmxDump.txt dumps/MyJmxDump.txt
```

This should work with most any recent version of Java. 

