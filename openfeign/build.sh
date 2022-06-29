#!/bin/sh
## 打包环境java_home 是1.7 的需要改成1.8
result=$(echo $JAVA_HOME | grep "jdk1.7")
if [[ "$result" != "" ]]
then
    export JAVA_HOME=/usr/java/jdk1.8.0_331-amd64
else
    echo "has exist jdk8"
fi

set -e
set -x
mvn clean package -e -U -Dmaven.test.skip=true --file pom.xml
rm -f output/openfeign.jar
mkdir -p output
mkdir -p output/var
cp openfeign/target/openfeign.jar output/
cp control.sh output/



