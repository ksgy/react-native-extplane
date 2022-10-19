package com.reactnativeextplane;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import org.cutre.soft.ExtPlaneInterface;


@ReactModule(name = ExtplaneModule.NAME)
public class ExtplaneModule extends NativeExtplaneSpec {
    public static final String NAME = "Extplane";

    public ExtplaneModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    private ExtPlaneInterface iface = null;

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

     @Override
     public void start(String ip, int port) throws Exception {
       iface = new ExtPlaneInterface(ip, port);
       iface.start();
     }

     @Override
     public void includeDataRef(String dataref, Float precision) {
       if (iface != null) {
         iface.includeDataRef(dataref, precision);
       }
     }

     @Override
     public void excludeDataRef(String dataref) {
       if (iface != null) {
         iface.excludeDataRef(dataref);
       }
     }

     @Override
     public String[] getDataRefValue(String dataref) {
       if (iface != null) {
         return iface.getDataRefValue(dataref);
       }
       return new String[0];
     }

     @Override
     public Constants.DataType getDataRefType(String dataref) {
       if (iface != null) {
         return iface.getDataRefType(dataref);
       }
       return null;
     }

     @Override
     public DataRef getDataRef(String dataref) {
       if (iface != null) {
         return iface.getDataRef(dataref);
       }
       return null;
     }

     @Override
     public void observeDataRef(String dataref, Callback callback) {
       if (iface != null) {
         Observer<DataRef> s = new Observer<DataRef>() {
           public void update(DataRef object) {
             callback.invoke(object);
           }
         };
         iface.observeDataRef(dataref, s);
       }
     }

     @Override
     public void unObserveDataRef(String dataref) {
       if (iface != null) {
         iface.unObserveDataRef(dataref);
       }
     }

}
