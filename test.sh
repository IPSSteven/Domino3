export NOTES_JAR=$Notes_ExecDirectory/jvm/lib/ext/Notes.jar
export CLASSPATH=$CLASSPATH:$NOTES_JAR
cd `dirname $0`
for file in lib/*.jar
do
        export CLASSPATH=$CLASSPATH:$file
done
JAVA=$Notes_ExecDirectory/jvm/bin/java
$JAVA com.ibm.ncouar.server.sync.TestConnectDominoDB
