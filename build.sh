#!/usr/bin/env bash

ant 
cp dist/dumpcompare.jar .
cp -rf dumps dist/.
cd dist
tar cvzf dumpcompare.tgz *
rm -rf dumpcompare.jar
rm -rf dumps
