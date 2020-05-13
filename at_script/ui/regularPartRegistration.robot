***Test Cases***
Regular Part ID Registration
    Select Tracking Point
    Scan Production No.
    Register Part
    View Vehicle History Inquiry
    View Operation Logs

***Keywords***
Select Tracking Point
    Open Browser    http://localhost:5000/pihd/partRegistration    chrome
    Select From List By Value    id=searchShop    A
    Wait Until Element Contains   id=searchTrackingPoint   IM0
    Select From List By Value    id=searchTrackingPoint    IM0
    Click Element    id=buttonSearch
    Wait Until Element Is Visible    id=partRegistrationSection
    Element Text Should Be    id=labelShop    A
    Element Text Should Be    id=labelTrackingPoint    1M0 : Frame-2
Scan Production Number
    Wait Until Element Is Visible    id=previousTrackingSection
    Table Row Should Contain    id=tablePreviousTracking    1    None
    Wait Until Element Is Visible    id=inputProdutionNo
    Input text    id=inputProductionNo    H30001-01
    Press Keys    id=inputProductionNo    ENTER
Register Part
    Wait Until Element Is Visible    id=partListSection
    Table Row Should Contain    id=tablePartList    1    None
    Input text    id=inputPartValue[0]    9903101111
    Input text    id=inputPartValue[1]    1GD0796211
    Input text    id=inputPartValue[2]    10A510020ANT051R
    Input text    id=inputPartValue[3]    T240514200459112
    Input text    id=inputPartValue[4]    MR0KU3CDXK0005045
    Click Element    id=buttonComplete
    Element Text Should Be    id=labelMessage    MPI03000001INF Operation Complete Success