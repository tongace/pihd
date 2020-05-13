$(document).ready(function () {
    'use strict'
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

    $('#critriaForm').form({
        fields: {
            searchedShop: {
                identifier: 'searchedShop',
                rules: [{
                    type: 'not[Select]'
                }]
            },
            searchedTrackingPoint: {
                identifier: 'searchedTrackingPoint',
                rules: [{
                    type: 'not[Select]'
                }]
            }
        },
        inline: true,
        on: 'blur'
    });
    $('#searchShop').dropdown({
        forceSelection: false
    });
    $('#searchTrackingPoint').dropdown({
        forceSelection: false
    });
    $('#buttonSearch').on('click', function () {
        $('#partRegistrationSection').show();
        $('#previousTrackingSection').show();
        $('#operationSection').show();
        $('#inputProductionNo').focus();
    });
    $('#inputProductionNo').keypress(function (event) {
        if (event.which == 13) {
            $('#partListSection').show();
            $('#operationButtonPanel').show();
            $('#buttonComplete').hide();
            let inputPartvalues = $('[name="inputPartvalue"]');
            inputPartvalues[0].focus();
        }
    });

    $('[name="inputPartvalue"]').each(function (index, obj, ) {
        $(obj).on('keypress', function (event) {
            if (event.which == 13) {
                console.log($(obj).parent());
                $('#buttonComplete').show();
                let statusColumn = $('.statusColumn')[index]
                $(statusColumn).text('OK');
                $(statusColumn).addClass('okStatus');
                if (index < $('[name="inputPartvalue"]').length - 1) {
                    $('[name="inputPartvalue"]')[index + 1].focus();
                }
            }
        });
    });

    $('#buttonComplete').on('click', function () {
        $('#partRegistrationSection').show();
        $('#previousTrackingSection').show();
        $('#operationSection').show();
        $('#partListSection').hide();
        $('#operationButtonPanel').hide();
        $('#buttonComplete').hide();
        $('#inputProductionNo').focus();
        $('#inputProductionNo').val('');
        $('#tablePreviousTracking').parent().siblings(":first").text('H30001-01')
        $('#tablePreviousTracking').parent().siblings(":first").addClass('okStatus');
    });

});