#!/bin/sh
ps -ef|grep openfeign|grep -v grep | awk '{print $2}' |xargs -r kill -9

exec java -Xms512m -Xmx512m -jar -Dspring.profiles.active=dev output/openfeign.jar > /dev/null 2>&1 &
echo "arwen-service-server start success"