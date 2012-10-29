package com.phonegap.plugins.flurry;

import java.util.HashMap;
import java.util.Map;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import com.flurry.android.FlurryAgent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Flurry extends Plugin {

	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		// TODO Auto-generated method stub
		PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
		try{
			if (action.equals("logEvent")) {
                result = this.logEvent(args.getString(0), args.optJSONObject(1), args.optBoolean(2));

                if (result.length() > 0) {
                    status = PluginResult.Status.ERROR;
                    return new PluginResult(status, result);
                } else {
                    PluginResult pluginResult = new PluginResult(status, result);
                    return pluginResult;
                }
            }else if(action.equals("endTimedEvent")){
            	result = this.endTimedEvent(args.getString(0));
            	if (result.length() > 0) {
                    status = PluginResult.Status.ERROR;
                    return new PluginResult(status, result);
                } else {
                    PluginResult pluginResult = new PluginResult(status, result);
                    return pluginResult;
                }
            }else {
                status = PluginResult.Status.INVALID_ACTION;
            }
			return new PluginResult(status, result);
		} catch (JSONException e){
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
	}
	
	private String logEvent(String eventName, JSONObject options, boolean timed){
		if(options != null){
			Map<String, String> params = new HashMap<String, String>();
			JSONArray names = options.names(); 
			int namesCount = names.length();
			for(int i=0;i<namesCount;i++){
				try {
					params.put(names.getString(i), options.getString(names.getString(i)));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FlurryAgent.logEvent(eventName, params, timed);
		}else{
			FlurryAgent.logEvent(eventName, timed);
		}
		return "";
	}
	
	private String endTimedEvent(String eventName){
		FlurryAgent.endTimedEvent(eventName);
		return "";
	}

}
