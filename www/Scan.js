var Scan = {
    createEvent: function(fullPath, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'Scan', // mapped to our native Java class called "Calendar"
            'addRemove', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "fullPath": fullPath
            }]
        );
    }
}

module.exports = Scan;

