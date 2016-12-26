package com.tis.sensorlist;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
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

/**
 * This class echoes JSON called from JavaScript.
 */
public class SensorList extends CordovaPlugin {

    /**
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback context used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getAvailableSensors")) {
            try{
            SensorManager smm;
            // Collects all sensors
            List<Sensor> sensorList;
            JSONArray jsonArray = new JSONArray();
            // Sensor manager
            smm = (SensorManager)cordova.getActivity().getSystemService(Context.SENSOR_SERVICE);
            sensorList = smm.getSensorList(Sensor.TYPE_ALL);
            // number of sensors 
            for (int i = 0; i < sensorList.size(); i++)
            {
              JSONObject jsonObj = new JSONObject();
              //finding each sensor name and listing with name.
              jsonObj.put("id", sensorList.get(i).getId());
              jsonObj.put("name", sensorList.get(i).getName());
              jsonObj.put("type", sensorList.get(i).getType());
              jsonObj.put("vendor", sensorList.get(i).getVendor());
              jsonObj.put("maxDelay", sensorList.get(i).getMaxDelay());
              jsonObj.put("maxRange", sensorList.get(i).getMaximumRange());
              jsonObj.put("minDelay", sensorList.get(i).getMinDelay());
              jsonObj.put("power", sensorList.get(i).getPower());
              jsonObj.put("resolution", sensorList.get(i).getResolution());
              jsonObj.put("version", sensorList.get(i).getVersion());
              jsonObj.put("isWakeUpSensor", sensorList.get(i).isWakeUpSensor());
              jsonObj.put("stringType", sensorList.get(i).getStringType());
              

              jsonArray.put(jsonObj);
            }

            // on success , array of Sensors provides
            callbackContext.success(jsonArray);
            }

            //  catch Exception  
            catch(Exception ex){
                callbackContext.error(ex.toString());
            }

            return true;

        } else {
            
            return false;

        }
    }
}