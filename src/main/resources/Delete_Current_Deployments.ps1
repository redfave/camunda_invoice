$Uri = "http://localhost:8080/engine-rest/deployment/"
$ProcessInstances = Invoke-WebRequest -Uri $Uri | select -ExpandProperty content | ConvertFrom-Json

foreach ($ProcessInstance in $ProcessInstances) {
    Invoke-WebRequest -Method Delete -Uri $($Uri + $ProcessInstance.id)
}