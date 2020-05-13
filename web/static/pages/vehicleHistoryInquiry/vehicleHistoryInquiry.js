//<![CDATA[
$(document).ready(function () {
    // event.preventDefault();
    // $('#mainscreen').hide(1000);
    // $('#editscreen').show(1000);
    // $('#roleinfoscreen').hide(1000);
    'use strict'
    $('#SaveEditScreen').form({
        fields: {
            NewPartId: {
                identifier: 'NewPartId',
                rules: [{
                    type: 'empty'
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
        // let dateTime = new Date();
        // $('.time').text(moment(dateTime).format('DD MMM YYYY HH:mm:ss'));
        // setInterval(function () {
        //     dateTime.setTime((dateTime.getTime() + 1000));
        //     $('.time').text(moment(dateTime).format('DD MMM YYYY HH:mm:ss'));
        // }, 1000);
    };
    // call displayDBServerTime immediately
    displayDBServerTime();
    // repeat call every 5 min to for update
    setInterval(displayDBServerTime, 300000);


    // $('#date_from').calendar{
    //     type: 'date',
    // }
    $('#date_from').calendar({
        type: 'date'
    });
    $('#date_to').calendar({
        type: 'date'
    });


    $('#planLineOffFrom').calendar({
        type: 'date'
    });
    $('#planLineOffTo').calendar({
        type: 'date'
    });



    $('#WBX0USERROLE')
        .dropdown({
            allowAdditions: true,
            forceSelection: false
        });
    $('#WSY01UserRoleInfoEditScreen')
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
    let table = $('#dataResult').DataTable({
        "scrollX": true,
        "ordering": true,
        "lengthChange": false,
        "buttons": [{
            text: '<i class="green file excel outline icon">',
            titleAttr: 'Export to Excel',
            extend: 'excelHtml5',
            title: 'Supplier Master'
        }, 'pageLength'],
    });
    table.buttons().container().appendTo($('div.eight.column:eq(0)', table.table().container()));
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

    $('#IP0501281OK').on('click', function (event) {
        alert("kk")
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


    $('#searchButton').on("click", function () {
        $('#searchResultSection').show(1000);
        //modileRegis modileRegisErr
    });

    $('#searchedTrackingPoint').dropdown({
        forceSelection: false
    });
    $('#shift_no').dropdown({
        forceSelection: false
    });
    $('#cfc').dropdown({
        forceSelection: false
    });
    $('#tracibility').dropdown({
        forceSelection: false
    });
});
//]]>