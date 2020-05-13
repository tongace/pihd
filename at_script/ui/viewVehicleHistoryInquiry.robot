***Setting***
Library    SeleniumLibrary

***Test Case***
View Vehicle History Inquiry
    search Tracking Point


***Keyword***
search Tracking Point 
    Open Browser    http://localhost:5000/pages/vehicleHistoryInquiry/vehicleHistoryInquiry   chrome
    Input Text    searchPlanLineOffFrom    01/05/2020
    Input Text    searchPlanLineOffTo    01/05/2020
    Click Element    id=searchButton
    Wait Until Element Is Visible    id=searchResultSection
    Page Should Contain Element   xpath://*[@id="dataResult"]/tbody/tr    limit=1
    Wait Until Element Is Visible    xpath://*[@id="dataResult"]
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    1    HP000001-01
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    25    990310111
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    26    1GD0796212
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    27    10A510020ANT05112
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    28    T240514200459112
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    29    MROKU3CDXK0005045
    Table Cell Should Contain    xpath://*[@id="dataResult"]    2    30    11/03/2020 S1 13:54
    Element Should Contain    xpath://*[@id="dataResult_info"]    Showing 1 to 1 of 1 entries
    


