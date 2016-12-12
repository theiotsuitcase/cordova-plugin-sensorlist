# Cordova Sensorlist Plugin

Sensorlist Plugin provides list of Sensors available in an android device. 

## How to use

#### Create a new ionic Project
```bash
$ ionic start mySensorListApp blank
```

#### Add Android platform
```bash
$ ionic platform add android
 ```

### Install the plugin
```bash
$ cd mySensorListApp
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
