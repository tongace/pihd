***Settings***
Library    SeleniumLibrary

***Test Cases***
Regular Part ID Registration - View Operation Logs
    Select Menu Operation Log
    Select Combobox Screen
    Select Combobox Status
    Click Search
    View Search Result Data Not Found    

***Keywords***
Select Menu Operation Log
    Open Browser    http://localhost:5000/html/Operation_Log_SC48    chrome
    Click Element    id:menucaller
    Wait Until Element Is Visible    id:WBX01211
    Sleep    3
    Click Element    id:menucaller

Select Combobox Screen
    Select From List By Value    id:searchScreen    PI03 : Part ID Registration
Select Combobox Status

Click Search

View Search Result Data Not Found 

