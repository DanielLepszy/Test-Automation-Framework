echo 'WebDriver Grid Hub on 4444'
echo ""
echo "*********************************************"
echo "*"
echo "* WebDriver grid Hub instance."
echo "*"
echo "*  http://localhost:4444/grid/console"
echo "*"
echo "*********************************************"
echo ""

jarfile='selenium-server-standalone-3.141.59.jar'
cd ./griDConfigFiles

java -jar $jarfile -role hub -hubConfig hubConfig.json -debug

