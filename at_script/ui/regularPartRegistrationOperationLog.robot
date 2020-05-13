***Settings***
Library    SeleniumLibrary

***Test Cases***
Regular Part ID Registration - View Operation Logs
    Select Menu Operation Log
    Input Search DateTime From
    Select Combobox Screen
    Click Search
    View Search Result Data Not Found    

***Keywords***
Select Menu Operation Log
    Open Browser    http://localhost:5000/pages/operationLog/operationLogSc48    chrome
    Click Element    id:menucaller
    Wait Until Element Is Visible    id:WBX01211
    #Sleep    3
    Click Element    id:WBX01211

Input Search DateTime From
    Input Text    searchDateTimeFrom    13/05/2020 00:00

Select Combobox Screen
    Select From List By Value    id:searchScreen    PI03

Click Search
    Click Element    id:search
    Wait Until Element Is Visible    id=searchResultSection

View Search Result Data Not Found
    Table Cell Should Contain    class:dataTables_empty    MCOM0000001ERR : Data not found
    
