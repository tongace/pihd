*** Settings ***
Library    SeleniumLibrary

***Test Cases***
Regular Part ID Registration
    Select Tracking Point
    Scan Production No.
    Register Part
    View Vehicle History Inquiry
    View Operation Logs

***Keywords***
Select Tracking Point
    Open Browser    http://localhost:5000/pages/partIdRegistration/partIdRegistration    chrome
    #Select From List By Value    id=searchShop    A
    Click Element    xpath://*[@id="critriaForm"]/div/div[1]/div[1]/div/input
    Wait Until Element Is Visible    xpath://*[@id="critriaForm"]/div/div[1]/div[1]/div/div[2]
    Click Element    xpath://*[@id="critriaForm"]/div/div[1]/div[1]/div/div[2]/div[2]
    #Select From List By Value    id=searchTrackingPoint    1M0
    Click Element    xpath://*[@id="critriaForm"]/div/div[1]/div[2]/div/i
    Wait Until Element Is Visible    xpath://*[@id="critriaForm"]/div/div[1]/div[2]/div/div[2]
    Click Element    xpath://*[@id="critriaForm"]/div/div[1]/div[2]/div/div[2]/div[2]

    Click Element    id=buttonSearch
    Wait Until Element Is Visible    id=partRegistrationSection
    
    ${labelShopValue}=    Get Value    id=labelShop
    Should be equal    ${labelShopValue}   A

    ${labelTrackingPointValue}=    Get Value    id=labelTrackingPoint
    Should be equal    ${labelTrackingPointValue}   1M0 : Frame-2

Scan Production No.
    Wait Until Element Is Visible    id=previousTrackingSection
    Table Row Should Contain    id=tablePreviousTracking    1    None
    Wait Until Element Is Visible    id=inputProductionNo
    Input text    id=inputProductionNo    H30001-01
    Press Keys    id=inputProductionNo    ENTER
Register Part
    Wait Until Element Is Visible    id=partListSection
    Table Row Should Contain    id=tablePartList    1    Frame ID No.
    Table Row Should Contain    id=tablePartList    2    ENGINE
    Table Row Should Contain    id=tablePartList    3    TRANSMISSION ASSY
    Table Row Should Contain    id=tablePartList    4    FUEL TANK FILLER
    Table Row Should Contain    id=tablePartList    5    Vin No.
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr/td[3]/div/input    9903101111
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr/td[3]/div/input    ENTER
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr[2]/td[3]/div/input    1GD0796211
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr[2]/td[3]/div/input    ENTER
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr[3]/td[3]/div/input    10A510020ANT051R
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr[3]/td[3]/div/input    ENTER
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr[4]/td[3]/div/input    T240514200459112
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr[4]/td[3]/div/input    ENTER
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr[5]/td[3]/div/input    MR0KU3CDXK0005045
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr[5]/td[3]/div/input    ENTER
    Click Element    id=buttonComplete
    Alert Should Be Present    MPI03000001CFM: Are you sure to complete install part process of this vehicle in this tracking point?
    Alert Should Be Present    MPI03000001INF: Part installation is complete.
View Vehicle History Inquiry
    Click Element    id:menucaller
    Wait Until Element Is Visible    id:VH01
    Sleep    2
    Click Element    id:VH01