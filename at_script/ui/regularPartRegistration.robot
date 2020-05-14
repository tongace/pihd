*** Settings ***
Library    SeleniumLibrary

*** Test Cases ***
Regular Part ID Registration
    Select Tracking Point
    Scan Production No.
    Register Part
    View Vehicle History Inquiry

*** Variable ***

*** Keywords ***
Select Tracking Point
    Open Browser    http://localhost:5000/pages/partIdRegistration/partIdRegistration    chrome
    #Select Shop = A
    Select From List By Value    name=searchShopInputSection    value=A
    #Select Tracking Point = 1M0
    Select From List By Value    name=searchTrackingPointInputSection    value=1M0

    Click Element    id=buttonSearch
    Wait Until Element Is Visible    id=partRegistrationSection
    #Compare Shop Lable
    ${labelShopValue}=    Get Value    id=labelShop
    Should be equal    ${labelShopValue}   A
    #Compare Tracking Point Lable
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
    Scan Part    position=1    value=9903101111
    Scan Part    position=2    value=1GD0796211
    Scan Part    position=3    value=10A510020ANT051R
    Scan Part    position=4    value=T240514200459112
    Scan Part    position=5    value=MR0KU3CDXK0005045
    Click Element    id=buttonComplete
    Alert Should Be Present    MPI03000001CFM: Are you sure to complete install part process of this vehicle in this tracking point?
    Alert Should Be Present    MPI03000001INF: Part installation is complete.
    Wait Until Element Is Visible    id=previousTrackingSection
    Table Row Should Contain    id=tablePreviousTracking    1    H30001-01

Scan Part
    [Arguments]    ${position}    ${value}
    Set Focus To Element    xpath=//table[@id='tablePartList']/thead[2]/tr[${position}]/td[3]/div/input
    Input text    xpath=//table[@id='tablePartList']/thead[2]/tr[${position}]/td[3]/div/input    ${value}
    Press Keys    xpath=//table[@id='tablePartList']/thead[2]/tr[${position}]/td[3]/div/input    ENTER

View Vehicle History Inquiry
    Click Element    id:menucaller
    Wait Until Element Is Visible    id:VH01
    Sleep    2
    Click Element    id:VH01

Select From List By Value
    [Arguments]    ${name}    ${value}
    Click Element    xpath://*[@id="${name}"]/div/input
    Wait Until Element Is Visible    xpath://*[@id="${name}"]/div/div[2]/div[@data-value="${value}"]
    Click Element     xpath://*[@id="${name}"]/div/div[2]/div[@data-value="${value}"]