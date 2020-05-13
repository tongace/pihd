//<![CDATA[
$(document).ready(function () {
    // event.preventDefault();
    // $('#mainscreen').hide(1000);
    // $('#editscreen').show(1000);
    // $('#roleinfoscreen').hide(1000);
    'use strict'
    $('#SaveEditScreen').form({
        fields: {
            username: {
                identifier: 'userId',
                rules: [{
                    type: 'empty'
                }]
            },
            password: {
                identifier: 'password',
                rules: [{
                    type: 'empty'
                }]
            },
            confirmPassword: {
                identifier: 'confirmPassword',
                rules: [{
                    type: 'empty'
                }]
            },
            name: {
                identifier: 'name',
                rules: [{
                    type: 'empty'
                }]
            },
            section: {
                identifier: 'section',
                rules: [{
                    type: 'empty'
                }]
            },
            email: {
                identifier: 'email',
                rules: [{
                    type: 'empty'
                }]
            },
            extNo: {
                identifier: 'extNo',
                rules: [{
                    type: 'empty'
                }]
            },
            userRole: {
                identifier: 'userRole',
                rules: [{
                    type: 'not[Select]'
                }]
            }
        },
        inline: true,
        on: 'blur'
    });


    $('.ui.dimmer').dimmer({
        closable: false
    });
    $('body').on('click', '#menucaller', function () {
        $('.ui.sidebar')
            .sidebar('setting', 'transition', 'push')
            .sidebar('toggle');
    });
    // timer
    let displayDBServerTime = function () {
        let dateTime = new Date();
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

    $('#searchDateTimeFrom').calendar();

    $('#dateTimeFrom').calendar({
        type: 'date'
    });

    $('#searchScreen')
        .dropdown({
            allowAdditions: true,
            forceSelection: false
        });
    $('#searchStatus')
        .dropdown({
            allowAdditions: true,
            forceSelection: false
        });

    $('.ui .selection .dropdown')
        .dropdown({
            useLabels: false,
            identifier: 'dropdown',
            rules: [{
                value: "0",
                prompt: 'Please enter a value'
            }]
        });
    let table = $('#datatable_result_search').DataTable({
        "ordering": true,
        "lengthChange": false,
        overflow: scroll,
        "buttons": [{
            text: '<i class="green file excel outline icon">',
            titleAttr: 'Export to Excel',
            extend: 'excelHtml5',
            title: 'Supplier Master'
        }, 'pageLength'],
    });
    table.buttons().container().appendTo($('div.eight.column:eq(0)', table.table().container()));

    let table2 = $('#dataResult').DataTable({
        "ordering": true,
        "lengthChange": false,
        overflow: scroll,
        "buttons": [{
            text: '<i class="green file excel outline icon">',
            titleAttr: 'Export to Excel',
            extend: 'excelHtml5',
            title: 'Supplier Master'
        }, 'pageLength'],
    });
    table2.buttons().container().appendTo($('div.eight.column:eq(0)', table.table().container()));

    $('#WBX01281Add').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').hide(1000);
        $('#editscreen').show(1000);
        $('#roleinfoscreen').hide(1000);
    });
    $('#WBX01281Cancel').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').show(1000);
        $('#editscreen').hide(1000);
        $('#roleinfoscreen').hide(1000);
    });

    $('#WBX01281OK').on('click', function (event) {
        // event.preventDefault();
        // $('#SaveEditScreen').form("validat ")
        $('#SaveEditScreen').form('validate form');

    });



    // SaveEditScreen
    $('#WBX01281Cancel').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').show(1000);
        $('#editscreen').hide(1000);
        $('#roleinfoscreen').hide(1000);
    });

    $('#WBX01281ROLEINFO').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').hide(1000);
        $('#editscreen').hide(1000);
        $('#roleinfoscreen').show(1000);
    });
    $('#WBX01281MAINROLE').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').hide(1000);
        $('#editscreen').hide(1000);
        $('#roleinfoscreen').show(1000);
    });



    $('#WBX01281ROLEINFOBACK').on('click', function (event) {
        event.preventDefault();
        $('#mainscreen').hide(1000);
        $('#editscreen').show(1000);
        $('#roleinfoscreen').hide(1000);
    });


    $('#WSY01Register').on("click", function () {
        $('#modileRegis').modal('show');
    });


    $('#WSY01Register').on("click", function () {
        $('#modileRegis').modal('show');
    });

    $('#searchButton').on("click", function () {
        $('#searchResultSection').show(1000);

    });

});
//]]>