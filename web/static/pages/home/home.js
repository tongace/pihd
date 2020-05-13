//<![CDATA[
$(document).ready(function () {
    $.each($('form'), function (indexInArray, valueOfElement) {
        $(valueOfElement).on('submit', function (event) {
            event.preventDefault();
            return false;
        });
    });
    $('body').on('click', '#menucaller', function () {
        $('.ui.sidebar')
            .sidebar('setting', 'transition', 'push')
            .sidebar('toggle');
    });
    // required for set active menu
    AppUtils.setActiveMenu($('#currentScreenId').val());
    // end required for set active menu
    // menu and button authorization
    // AppUtils.authorizationRender($('#currentScreenId').val());
    // end menu and button authorization

    // timer
    let displayDBServerTime = function () {
        var dateTime = new Date();
        $('.time').text(moment(dateTime).format('DD MMM YYYY HH:mm:ss'));
        setInterval(function () {
            dateTime.setTime((dateTime.getTime() + 1000));
            $('.time').text(moment(dateTime).format('DD MMM YYYY HH:mm:ss'));
        }, 1000);
    };
    // call displayDBServerTime immediately
    displayDBServerTime();
    // repeat call every 5 min to for update
    setInterval(displayDBServerTime, 300000);
});
//]]>