# DumpCompare

This makes a comparison of someone else's Alfresco JMX dump and another one. I've provided a directory called 'dumps' that have a few of my own vanilla, ootb Alfresco installs. I've provided those for your convenience but know that they will reflect my environment (usernames, passwords, paths, etc.).

From the command line you can do:

```
# java -jar dumpcompare.jar
```

This will render a list of options and version of DumpCompare.

How to use:

```
# java -jar dumpcompare.jar YourJmxDump.txt dumps/MyJmxDump.txt
```

This should work with most any recent version of Java. 

