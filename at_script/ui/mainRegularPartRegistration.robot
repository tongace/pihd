*** Setting ***
Resource    regularPartRegistration.robot
Resource    regularPartRegistrationOperationLog.robot
Resource    viewVehicleHistoryInquiry.robot


***Test Cases***
regular part registration success
    view vehicle history
    Select Menu Operation Log
    Input Search DateTime From
    Select Combobox Screen
    Click Search
    View Search Result Data Not Found