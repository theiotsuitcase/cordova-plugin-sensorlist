package com.tis.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
            SensorManager smm;
            List<Sensor> sensorList;
            JSONArray jsonArray = new JSONArray();

            smm = (SensorManager)cordova.getActivity().getSystemService(Context.SENSOR_SERVICE);
            sensorList = smm.getSensorList(Sensor.TYPE_ALL);

            for (int i = 0; i < sensorList.size(); i++)
            {
              JSONObject jsonObj = new JSONObject();
              jsonObj.put("name", sensorList.get(i).getName());

              jsonArray.put(jsonObj);
            }


            callbackContext.success(jsonArray);
        }
        catch(Exception ex){
            callbackContext.error("ex");
        }

            return true;

        } else {
            
            return false;

        }
    }
}
