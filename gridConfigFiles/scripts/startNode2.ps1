Write-Host "WebDriver Grid Node on 4444"
Write-Host ""

Write-Host "*********************************************"
Write-Host "*"
Write-Host "* WebDriver Grid Node"
Write-Host "* It requires that a WebDriver JSON Hub is already running, usually on port 5556."
Write-Host "* You can run more than one of these if each has its own JSON config file."
Write-Host "*"
Write-Host "*********************************************"
Write-Host ""


$jarfile='gridConfigFiles/selenium-server-standalone-3.141.59.jar'
java -jar $jarfile -role node -nodeConfig gridConfigFiles/nodeConfig2.json -debug

