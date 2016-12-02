package com.tis.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SensorList extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("fetch")) {
            try{
            SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
            List<Sensor> listSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);
            List<String> listSensorType = new ArrayList<String>();
            for(int i=0; i<listSensor.size(); i++){
                listSensorType.add(listSensor.get(i).getName());
            }

            callbackContext.success(listSensorType);
        }
        catch(exception ex){
            callbackContext.error(ex);
        }

            return true;

        } else {
            
            return false;

        }
    }
}
