# Cordova Sensorlist Plugin

Sensorlist Plugin provides list of Sensors available in an android device. 

## How to use

#### Create a new ionic Project
```bash
$ ionic start mySensorListApp blank
```

#### Add Android platform
```bash
$ cd mySensorListApp
$ ionic platform add android
 ```

### Install the plugin
```bash
$ ionic plugin add https://github.com/theiotsuitcase/cordova-plugin-sensorlist.git
```

Update `mySensorListApp/www/js/app.js` to fetch the list of sensors from a controller

```js
app.controller('AppCtrl', function($ionicPlatform, $scope) {
    $ionicPlatform.ready(function() {
        window.cordova.plugins.SensorList.getAvailableSensors(function(sensorsList) {
            $scope.sensorsList = sensorsList;
            // For some reason change detection is not working!
            $scope.$apply();            
        }, function(ex) {
            console.log('Error', ex);
        });
    });
})
```

Sample output

```json
[
  {
    "name": "BBK-proxacross",
    "type": 28,
    "vendor": "BBK",
    "maxDelay": 10000000,
    "maxRange": 1,
    "minDelay": 0,
    "power": 0.18000000715255737,
    "resolution": 1,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.across",
  },
  {
    "name": "lis3dh-accel",
    "type": 1,
    "vendor": "STMicroelectronics",
    "maxDelay": 10000000,
    "maxRange": 156.8000030517578,
    "minDelay": 10000,
    "power": 0.009999999776482582,
    "resolution": 0.009999999776482582,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.accelerometer",
  },
  {
    "name": "hscdtd007a-mag",
    "type": 2,
    "vendor": "ALPS ELECTRIC CO., LTD.",
    "maxDelay": 10000000,
    "maxRange": 4800,
    "minDelay": 10000,
    "power": 0.6000000238418579,
    "resolution": 0.15000000596046448,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.magnetic_field",
  },
  {
    "name": "TMD277X-proximity",
    "type": 8,
    "vendor": "Taos",
    "maxDelay": 10000000,
    "maxRange": 5,
    "minDelay": 10000,
    "power": 0.18000000715255737,
    "resolution": 5,
    "version": 1,
    "isWakeUpSensor": true,
    "stringType": "android.sensor.proximity",
  },
  {
    "name": "TMD277X-light",
    "type": 5,
    "vendor": "Taos",
    "maxDelay": 10000000,
    "maxRange": 6553,
    "minDelay": 150000,
    "power": 0.15000000596046448,
    "resolution": 0.012500000186264515,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.light",
  },
  {
    "name": "hscdtd007a-orientation",
    "type": 3,
    "vendor": "oem",
    "maxDelay": 10000000,
    "maxRange": 360,
    "minDelay": 20000,
    "power": 1,
    "resolution": 0.00390625,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.orientation",
  },
  {
    "name": "hscdtd007a-pseudo-gyro",
    "type": 4,
    "vendor": "oem",
    "maxDelay": 10000000,
    "maxRange": 50,
    "minDelay": 10000,
    "power": 1,
    "resolution": 0.009999999776482582,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.gyroscope",
  },
  {
    "name": "hscdtd007a-linear-acceleration",
    "type": 10,
    "vendor": "oem",
    "maxDelay": 10000000,
    "maxRange": 40,
    "minDelay": 10000,
    "power": 1,
    "resolution": 0.009999999776482582,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.linear_acceleration",
  },
  {
    "name": "hscdtd007a-rotation-vector",
    "type": 11,
    "vendor": "oem",
    "maxDelay": 10000000,
    "maxRange": 1,
    "minDelay": 10000,
    "power": 1,
    "resolution": 5.960464477539063e-8,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.rotation_vector",
  },
  {
    "name": "hscdtd007a-gravity",
    "type": 9,
    "vendor": "oem",
    "maxDelay": 10000000,
    "maxRange": 40,
    "minDelay": 10000,
    "power": 1,
    "resolution": 0.009999999776482582,
    "version": 1,
    "isWakeUpSensor": false,
    "stringType": "android.sensor.gravity",
  }
]
```

And `mySensorListApp/www/index.html` to display the list

```html
<body ng-app="starter" ng-controller="AppCtrl">
    <ion-pane>
        <ion-header-bar class="bar-stable">
            <h1 class="title">Android Sensors List</h1>
        </ion-header-bar>
        <ion-content>
            <ul class="list">
                <li class="item" ng-repeat="sensor in sensorsList">
                    {{sensor.name}}
                </li>
            </ul>
        </ion-content>
    </ion-pane>
</body>
```
    
#### Run the code
```bash
$ ionic run android
```
