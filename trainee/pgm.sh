#!/bin/sh

cou=$(cat res.txt hello.txt)
ew=0
ow=0
for i in $cou
do
len=${#i}
if [ `expr $len % 2` -eq 0 ]
then
ew=`expr $ew + 1`
else
ow=`expr $ow + 1`
fi
echo "$i"
done
echo "$ew"
echo "$ow"

