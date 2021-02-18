Write-Host 'WebDriver Grid Hub on 4444'
Write-Host ""
Write-Host "*********************************************"
Write-Host "*"
Write-Host "* WebDriver grid Hub instance."
Write-Host "*"
Write-Host "*  http://localhost:4444/grid/console"
Write-Host "*"
Write-Host "*********************************************"
Write-Host ""

$jarfile='griDConfigFiles/selenium-server-standalone-3.141.59.jar'
java -jar $jarfile -role hub -hubConfig griDConfigFiles/hubConfig.json -debug

