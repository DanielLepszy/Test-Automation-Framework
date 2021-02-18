Write-Host 'Tear down Grid Hub and Grid Node'
Write-Host ""
Write-Host "*********************************************"

Invoke-WebRequest 'http://localhost:5555/selenium-server/driver/?cmd=shutDownSeleniumServer'
Invoke-WebRequest 'http://localhost:5556/selenium-server/driver/?cmd=shutDownSeleniumServer'
Invoke-WebRequest 'http://localhost:4444/lifecycle-manager?action=shutdown'
