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
    Sleep    2
    Click Element    id:menucaller
    Sleep    2
    Wait Until Element Is Visible    id:LG01
    Sleep    2
    Click Element    id:LG01

Input Search DateTime From
    Input Text    id:searchDateTimeFrom    13/05/2020 00:00
    Press Keys    id:searchDateTimeFrom    ENTER
Select Combobox Screen
    Click Element    xpath://*[@id="input_s"]/div/div[2]/div
    Wait Until Element Is Visible    xpath://*[@id="input_s"]/div/div[2]/div/div[2]
    Click Element    xpath://*[@id="input_s"]/div/div[2]/div/div[2]/div[5] 
    #Select From List By Value    id:searchScreen    PI03

Click Search
    Click Element    id:searchButton
    Wait Until Element Is Visible    id:searchResultSection

View Search Result Data Not Found
    Table Cell Should Contain    class:dataTables_empty    MCOM0000001ERR : Data not found
    
