echo "WebDriver Grid Hub on 4444"
echo ""

echo "*********************************************"
echo "*"
echo "* WebDriver Grid Node"
echo "* It requires that a WebDriver JSON Hub is already running, usually on port 5555."
echo "* You can run more than one of these if each has its own JSON config file."
echo "*"
echo "*********************************************"
echo ""

jarfile='selenium-server-standalone-3.141.59.jar'
cd ./griDConfigFiles

java -jar $jarfile -role node -nodeConfig nodeConfig.json -debug

