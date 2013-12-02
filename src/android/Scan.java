
package org.media.scan;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

public class Scan extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if ( action != null && action.length() > 0 ) {

               JSONObject arg_object = args.getJSONObject(0);
               Intent calIntent = new Intent( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile( arg_object.getString("fullPath") ) );

               this.cordova.getActivity().startActivity( calIntent );
               callbackContext.success("good");
               return true;

            } else {
                callbackContext.error("invalid");

            }

            return false;

        } catch(Exception e) {

            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }

    }

}

