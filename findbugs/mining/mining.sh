for f in /tmp/darwin*.jar
do 
	findbugs -textui -onlyAnalyze com.darwinsys.- -medium -xml -outputFile $f.xml $f
done

computeBugHistory -output fbmining.xml darwinsys-api-1.0.*.xml

mineBugHistory -formatDates fbmining.xml | tr '\t' '|'
