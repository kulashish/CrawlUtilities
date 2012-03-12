#!/bin/bash
SEGDIR=$1
OUTDIR=$2
NUTCHPATH=/home/ashish/apache-nutch-1.4-bin/runtime/local
SEGDIRFILES=$SEGDIR/*
COUNT=1
for f in $SEGDIRFILES
do
	echo "Processing $f..."
	$NUTCHPATH/bin/nutch readseg -dump $f $OUTDIR/$COUNT -nofetch -nogenerate -noparse -noparsedata -noparsetext
	let COUNT=$COUNT+1
done
