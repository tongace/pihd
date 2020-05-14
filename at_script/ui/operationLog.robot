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
    #Open Browser    http://localhost:5000/pages/operationLog/operationLog    chrome
    Open Browser    http://localhost:5000/pages/vehicleHistoryInquiry/vehicleHistoryInquiry    chrome
    Maximize Browser Window
    Sleep    1
    Click Element    id:menucaller
    Sleep    1
    Wait Until Element Is Visible    id:LG01    
    Click Element    id:LG01

Input Search DateTime From
    Click Element    id:searchDateTimeFrom
    Input Text    id:inputDateTimeFrom    13/05/2020 00:00
    Press Keys    id:inputDateTimeFrom    ENTER


Select Combobox Screen
    Select From List By Value    name=searchScreenInputSection    value=PI03

Click Search
    Click Element    id:searchButton
    Wait Until Element Is Visible    id:searchResultSection

View Search Result Data Not Found
    View DataTable Data Not Found    name=dataResult    text=No data available in table

#Add to Common
Select From List By Value
    [Arguments]    ${name}    ${value}
    Click Element    xpath://*[@id="${name}"]/div/input
    Wait Until Element Is Visible    xpath://*[@id="${name}"]/div/div[2]/div[@data-value="${value}"]
    Click Element    xpath://*[@id="${name}"]/div/div[2]/div[@data-value="${value}"]

View DataTable Data Not Found
    [Arguments]    ${name}    ${text}
    Wait Until Element Is Visible    id:${name}
    Table Should Contain    id:${name}    ${text}

