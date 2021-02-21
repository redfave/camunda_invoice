$Uri = "http://localhost:8080/engine-rest/history/process-instance/"
$HistoricProcessInstances = Invoke-WebRequest -Uri $Uri | select -ExpandProperty content | ConvertFrom-Json

foreach ($HistoricProcessInstance in $HistoricProcessInstances) {
    Invoke-WebRequest -Method Delete -Uri $($Uri + $HistoricProcessInstance.Id)
}