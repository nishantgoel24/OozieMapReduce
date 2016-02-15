#!/bin/bash

export HADOOP_HOME=/opt/mapr/hadoop/hadoop-0.20.2
export LD_LIBRARY_PATH=$HADOOP_HOME/lib/native/Linux-amd64-64
export CLASSPATH=$HADOOP_HOME/*:$HADOOP_HOME/lib/* 
export HADOOP_CLASSPATH=$CLASSPATH

javac -d classes IrisMapperMean.java
javac -d classes IrisReducerMean.java
javac -d classes IrisMapperStd.java
javac -d classes IrisReducerStd.java

jar -cvf lib/Iris.jar -C classes/ .
