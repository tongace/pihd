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
    Sleep    1
    Click Element    id:LG01

Input Search DateTime From
    Click Element    id:searchDateTimeFrom
    Input Text    id:inputDateTimeFrom    13/05/2020 00:00
    Press Keys    id:inputDateTimeFrom    ENTER

Select Combobox Screen
    Click Element    xpath://*[@id="inputSearchScreen"]/div/input
    Wait Until Element Is Visible    xpath://*[@id="inputSearchScreen"]/div/div[2]
    #Select From List By Value    id:searchScreen    PI03
    Click Element    xpath://*[@id="inputSearchScreen"]/div/div[2]/div[5]

Click Search
    Click Element    id:searchButton
    Wait Until Element Is Visible    id:searchResultSection

View Search Result Data Not Found
    Wait Until Element Is Visible    id:dataResult
    Table Should Contain    id:dataResult    No data available in table
    