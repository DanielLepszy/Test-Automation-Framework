Write-Host 'Tear down Grid Hub and Grid Node'
Write-Host ""
Write-Host "*********************************************"

Invoke-WebRequest 'http://localhost:4444/lifecycle-manager?action=shutdown