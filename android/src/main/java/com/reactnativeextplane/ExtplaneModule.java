package com.reactnativeextplane;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import org.cutre.soft.ExtPlaneInterface;
import org.cutre.soft.epi.data.DataRef;
import org.cutre.soft.epi.util.Constants;
import org.cutre.soft.epi.util.Observer;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;


@ReactModule(name = ExtplaneModule.NAME)
public class ExtplaneModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Extplane";

    private ReactContext rc;

    public ExtplaneModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.rc = reactContext;
    }

    private ExtPlaneInterface iface = null;

  private void sendEvent(ReactContext reactContext,
                         String eventName,
                         @Nullable WritableMap params) {
    reactContext
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, params);
  }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void start(String ip, int port) throws Exception {
       iface = new ExtPlaneInterface(ip, port);
       iface.start();
     }

    @ReactMethod
    public void includeDataRef(String dataref, Float precision) {
       if (iface != null) {
         iface.includeDataRef(dataref, precision);
       }
     }

    @ReactMethod
    public void excludeDataRef(String dataref) {
       if (iface != null) {
         iface.excludeDataRef(dataref);
       }
     }

    @ReactMethod
    public String[] getDataRefValue(String dataref) {
       if (iface != null) {
         return iface.getDataRefValue(dataref);
       }
       return new String[0];
     }

    @ReactMethod
    public Constants.DataType getDataRefType(String dataref) {
       if (iface != null) {
         return iface.getDataRefType(dataref);
       }
       return null;
     }

    @ReactMethod
    public DataRef getDataRef(String dataref) {
       if (iface != null) {
         return iface.getDataRef(dataref);
       }
       return null;
     }

    @ReactMethod
    public void addListener(String eventName) {
    // Set up any upstream listeners or background tasks as necessary
    }

    @ReactMethod
    public void removeListeners(Integer count) {
    // Remove upstream listeners, stop unnecessary background tasks
    }

    @ReactMethod
    public void observeDataRef(String dataref) {
       if (iface != null) {
         ReactContext a = this.rc;
         Observer<DataRef> s = new Observer<DataRef>() {
           public void update(DataRef object) {
             WritableMap params = Arguments.createMap();
             params.putString("datarefValue", String.valueOf(object));
             sendEvent(a, "DatarefUpdate", params);
           }
         };
         iface.observeDataRef(dataref, s);
       }
     }

//    @ReactMethod
//    public void unObserveDataRef(String dataref) {
//       if (iface != null) {
//         iface.unObserveDataRef(dataref);
//       }
//     }

}
