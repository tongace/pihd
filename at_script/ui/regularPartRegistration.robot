***Test Cases***
Regular Part ID Registration
    Select Tracking Point
    Scan Production No.
    Register Part
    View Vehicle History Inquiry
    View Operation Logs

***Keywords***
Select Tracking Point
    Open Browser    http://localhost:8080/pihd/partRegistration
    Select From List By Value    id=searchShop    A
    Wait Until Element Contains    id=searchTrackingPoint    1M0 
    Select From List By Value    id=searchTrackingPoint    1M0
    Click Element    id=search   
    Wait Until Element Is Visible    id=partRegistrationSection
    Element Text Should Be    id=shop    A
    Element Text Should Be    id=TrackingPoint    1M0 : Frame-2