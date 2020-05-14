***Setting***
Library    SeleniumLibrary

***Test Cases***
view Vehicle History Inquiry
    Open Vehicle History Inquiry screen
    Input search criteria
    Check Vehicle History Inquiry Result
    Close screen

***Keyword***
Open Vehicle History Inquiry screen
    Open Browser    http://localhost:5000/pages/vehicleHistoryInquiry/vehicleHistoryInquiry   chrome

Input search criteria    
    Input Text    searchPlanLineOffFrom    01/05/2020
    Input Text    searchPlanLineOffTo    01/05/2020
    Click Element    id=searchButton

Check value in Vehicle History table
    [Arguments]    ${row}    ${column}    ${value} 
     Table Cell Should Contain    xpath://*[@id="dataResult"]    ${row}    ${column}    ${value}

Check Vehicle History Inquiry Result
    Wait Until Element Is Visible    id=searchResultSection
    Page Should Contain Element   xpath://*[@id="dataResult"]/tbody/tr    limit=1
    Wait Until Element Is Visible    xpath://*[@id="dataResult"]
    Check value in Vehicle History table    row=2    column=1    value=H30001-01
    Check value in Vehicle History table    row=2    column=25   value=990310111
    Check value in Vehicle History table    row=2    column=26   value=1GD0796212
    Check value in Vehicle History table    row=2    column=27   value=10A510020ANT05112
    Check value in Vehicle History table    row=2    column=28   value=T240514200459112
    Check value in Vehicle History table    row=2    column=29   value=MROKU3CDXK0005045
    Check value in Vehicle History table    row=2    column=30   value=11/03/2020 S1 13:54
    Wait Until Element Is Visible    xpath://*[@id="dataResult_info"]
    Element Should Contain    xpath://*[@id="dataResult_info"]    Showing 1 to 1 of 1 entries

Close screen
    Close Browser
