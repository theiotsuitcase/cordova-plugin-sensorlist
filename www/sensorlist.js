/*global cordova, module*/

module.exports = {
    fetch: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "SensorList", "fetch", []);
    }
};
