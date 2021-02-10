echo "WebDriver Grid Hub on 4444"
echo ""

echo "*********************************************"
echo "*"
echo "* WebDriver grid Hub instance."
echo "*"
echo "*  http://localhost:4444/grid/console"
echo "*"
echo "*********************************************"
echo ""

jarfile=selenium-server-standalone-3.141.59.jar

#export run_directory=./Test-Automation-Framework
cd ./src/main/resources

#nohup

java -jar $jarfile -role hub

echo 'Done'
