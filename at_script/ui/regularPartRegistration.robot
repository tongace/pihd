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
    Select From List By Value    id=searchShop    A
    Wait Until Element Contains   id=searchTrackingPoint   1M0
    Select From List By Value    id=searchTrackingPoint    1M0
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
    Input text    name=inputPartValue[0]    9903101111
    Input text    name=inputPartValue[1]    1GD0796211
    Input text    name=inputPartValue[2]    10A510020ANT051R
    Input text    name=inputPartValue[3]    T240514200459112
    Input text    name=inputPartValue[4]    MR0KU3CDXK0005045
    Click Element    id=buttonComplete
    Alert Should Be Present    MPI03000001INF Operation Complete Success