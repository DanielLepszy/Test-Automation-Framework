Write-Host "*********************************************"
Write-Host "*"
Write-Host "*" "WebDriver Grid Hub on 4444"
Write-Host "*" "WebDriver Grid Node on 5555"
Write-Host "*" "WebDriver Grid Node on 5556"
Write-Host ""

Write-Host "*********************************************"
Write-Host "*"
Write-Host "* WebDriver grid Hub instance."
Write-Host "*"
Write-Host "*  http://localhost:4444/grid/console"
Write-Host "*"
Write-Host "*********************************************"
Write-Host ""

Write-Host "*********************************************"
Write-Host "* Numbers of Nodes : 2 "
Write-Host "* WebDriver Grid Node"
Write-Host "* It requires that a WebDriver JSON Hub is already running, usually on port 5555."
Write-Host "* You can run more than one of these if each has its own JSON config file."
Write-Host "*"
Write-Host "*********************************************"
Write-Host ""

Write-Host "*********************************************"
Write-Host "* Trigger Grid Hub and Nodes "
Write-Host "*********************************************"
Write-Host ""

$Url='http://localhost:4444/'

start powershell  "./startHub.ps1"

Foreach ($i in 1, 2, 3, 4)
{
    $response = Invoke-WebRequest -Uri $Url

    # if requestStatus != 200 then wait until hub will create
    if($response.statusCode -eq 200)
    {
        start powershell ./startNode1.ps1
        start powershell ./startNode2.ps1
        break
    }
    else {
        Write-Host "*********************************************"
        Write-Host "* Grid Hub has not yet prepared "
        Write-Host "* Wait for Grid Hub "
        Write-Host "*********************************************"
        Start-sleep 4
        if($i -eq 4){ Write-Host " ***** Error according to trigger Grid Hub"}

    }
}



