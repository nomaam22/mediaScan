
package org.media.scan;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Scan extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    	//PluginResult.Status status = PluginResult.Status.OK;
    	
        //String result = "";
    	
        try {
            if ( action.equals("refresh") ) {

            	String filePath = args.getString(0);
            	filePath = filePath.replaceAll("^file://", "");
            	
            	if (filePath.equals("")) {
            		callbackContext.error("null path passed");
                    return false;
            	}            	
            	
            	File file = new File(filePath);

                Intent scanIntent = new Intent(
                                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                scanIntent.setData(Uri.fromFile(file));

                // For more information about cordova.getContext() look here:
                // http://simonmacdonald.blogspot.com/2012/07/phonegap-android-plugins-sometimes-we.html?showComment=1342400224273#c8740511105206086350
                //Context context = cordova.getContext();
                //context.sendBroadcast(scanIntent);
            	
                this.cordova.getActivity().startActivity( scanIntent );
                callbackContext.success("good");
                return true;
            	            	
            	
               //JSONObject arg_object = args.getJSONObject(0);
               //Intent calIntent = new Intent( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile( arg_object.getString("fullPath") ) );

               //this.cordova.getActivity().startActivity( calIntent );
               //callbackContext.success("good");
               //return true;

            } else {
                callbackContext.error("invalid action phrase");

            }

            return false;

        } catch(Exception e) {

            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
        
        
        

    }

}

