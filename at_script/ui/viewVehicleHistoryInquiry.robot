***Setting***
Library    SeleniumLibrary

***Test Case***
View Vehicle History Inquiry
    search Tracking Point


***Keyword***
search Tracking Point 
    Open Browser    http://localhost:5000/pihd/viewVehicleHistory
    /Vehicle_History_Inquiry    chrome
    Input Text    searchPlanLineOffFrom    01/05/2020
    Input Text    searchPlanLineOffTo    01/05/2020
    Click Element    id=searchButton
    Wait Until Element Is Visible    id=searchResultSection
    Page Should Contain Element   xpath://*[@id="dataResult"]/tbody/tr    limit=1
    Table Cell Should Contain    xpath://*[@id="dataResult"]/tbody/tr   1    1    HP000001-01