*** Setting ***
Library    SeleniumLibrary
Resource    regularPartIdRegistration.robot
Resource    regularPartRegistrationOperationLog.robot
Resource    viewVehicleHistoryInquiry.robot


*** Test Cases ***
regular part registration success
    partIdRegistration.Open screen
    Select Shop  value=A
    Select Tracking Point   value=1M0
    Click Search Tracking Point
    Scan Production No.    value=H30001-01
    Scan Part Value    value=9903101111
    Scan Part Value    value=1GD0796212
    Scan Part Value    value=10A510020ANT05112
    Scan Part Value    value=T240514200459112
    Scan Part Value    value=XXXXXXXXXXXXXXXXX