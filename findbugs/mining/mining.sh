for f in darwinsys*.jar
do 
	findbugs -textui \
	-onlyAnalyze com.darwinsys.- \
	-auxclasspath "$HOME/lib/mail.jar:$HOME/lib/servlet-api.jar:$HOME/lib/jsp-api.jar:$HOME/lib/junit.jar" \
	-medium -xml -outputFile $f.xml $f
done

computeBugHistory -output fbmining.xml darwinsys-*.xml

mineBugHistory -formatDates fbmining.xml | tr '\t' '|'


