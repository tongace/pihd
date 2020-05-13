var AppUtils = (function ($) {
    // class properties
    return {
        MODE_ADD: 'ADD',
        MODE_SEARCH: 'SEARCH',
        MODE_EDIT: 'EDIT',
        MODE_REGISTER: 'REGISTER',
        MODE_INITIAL: 'INITIAL',
        MODE_NEXT_VERSION: 'NEXT_VERSION',
        COMBOBOX_ALL: 'All',
        COMBOBOX_SELECT: 'Select',
        toggleGroupMenu: function (obj) {
            var menuGroup = $(obj).parent();
            menuGroup.children(".menu").toggle();
            // hide all other menu group
            var allOtherMenuGroup = $(obj).parent().siblings();
            if (allOtherMenuGroup != null) {
                for (var ii = 0; ii < allOtherMenuGroup.length; ii++) {
                    var otherMenuGroup = allOtherMenuGroup[ii];
                    if ($(otherMenuGroup).children(".menu").is(':visible')) {
                        $(otherMenuGroup).children(".menu").hide();
                    }
                }
            }
            return false;
        },
        setActiveMenu: function (screenId) {
            var creenIdObj = $('#' + screenId)
            creenIdObj.toggleClass("active");
            creenIdObj.parent().show();
            creenIdObj.parent().parent().siblings().children(".menu").hide();
            return false;
        },
        createSelectOption: function (selectObj, comboList, firstItemText) {
            selectObj.find('option').remove().end();
            if (firstItemText != null) {
                selectObj.append($('<option>', {
                    value: firstItemText,
                    text: firstItemText
                }));
            }
            if (comboList != null) {
                for (var ii = 0; ii < comboList.length; ii++) {
                    var item = comboList[ii];
                    selectObj.append($('<option>', {
                        value: item.value,
                        text: item.name
                    }));
                }
            }
        },
        formatDate: function (javaDate, format) {
            if (S(javaDate).isEmpty()) {
                return '';
            } else {
                return moment(new Date(javaDate)).format(format);
            }
        },
        parseDate: function (stringDate, format) {
            if (S(stringDate).isEmpty()) {
                return null;
            } else {
                return moment(stringDate, format).toDate();
            }
        },
        parseDateForDB: function (stringDate, format) {
            if (S(stringDate).isEmpty()) {
                return null;
            } else {
                return moment(stringDate, format).toDate().getTime();
            }
        },
        comfirmModal: function (confirmMessage, params) {
            var messageCode = confirmMessage.substring(0, confirmMessage.indexOf(":"));
            $('#confirmingModal').children(".header").empty();
            $('#confirmingModal').children(".content").empty();
            $('#confirmingModal').children(".header").removeClass("yellow red green");
            $('#confirmingModal').children(".header").append(messageCode);
            if (params != null) {
                for (var indexInArray = 0; indexInArray < params.length; indexInArray++) {
                    var valueOfElement = params[indexInArray];
                    confirmMessage = confirmMessage.replace('{' + indexInArray + '}', valueOfElement);
                }
            }
            var firstConlon = confirmMessage.indexOf(':');
            var messageType = confirmMessage.substring(firstConlon - 3, firstConlon);
            switch (messageType) {
                case 'WRN':
                    $('#confirmingModal').children(".header").addClass("yellow");
                    break;
                case 'CFM':
                    $('#confirmingModal').children(".header").addClass("green");
                    break;
            }
            $('#confirmingModal').children(".content").append(confirmMessage);
            return $('#confirmingModal');
        },
        alertModal: function (alertMessage, params) {
            var messageCode = alertMessage.substring(0, alertMessage.indexOf(":"));
            $('#alertModal').children(".header").empty();
            $('#alertModal').children(".content").empty();
            $('#alertModal').children(".header").removeClass("yellow red green");
            $('#alertModal').children(".header").append(messageCode);
            if (params != null) {
                for (var indexInArray = 0; indexInArray < params.length; indexInArray++) {
                    var valueOfElement = params[indexInArray];
                    alertMessage = alertMessage.replace('{' + indexInArray + '}', valueOfElement);
                }
            }
            var firstConlon = alertMessage.indexOf(':');
            var messageType = alertMessage.substring(firstConlon - 3, firstConlon);
            switch (messageType) {
                case 'INF':
                    $('#alertModal').children(".header").addClass("green");
                    break;
                case 'WRN':
                    $('#alertModal').children(".header").addClass("yellow");
                    break;
                case 'ERR':
                    $('#alertModal').children(".header").addClass("red");
                    break;
            }
            $('#alertModal').children(".content").append(alertMessage);
            return $('#alertModal');
        }
    }
}(jQuery));