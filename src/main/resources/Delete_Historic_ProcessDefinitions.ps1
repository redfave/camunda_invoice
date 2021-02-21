$Uri = "http://localhost:8080/engine-rest/history/process-definition/cleanable-process-instance-report/"
$HistoricProcessDefinitions = Invoke-WebRequest -Uri $Uri | select -ExpandProperty content | ConvertFrom-Json

foreach ($HistoricProcessDefinition in $HistoricProcessDefinitions) {
    Invoke-WebRequest -Method Delete -Uri $($Uri + $HistoricProcessDefinition.processDefinitionId)
}