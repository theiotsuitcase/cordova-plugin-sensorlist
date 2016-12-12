var exec = require('cordova/exec');

/**
 * returns success , error String arguments
 * 
 */
exports.getAvailableSensors = function(success, error) {
    exec(success, error, "SensorList", "getAvailableSensors");
};
