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

    //  @ReactMethod
    //  public void unObserveDataRef(String dataref) {
    //    if (iface != null) {
    //      iface.unObserveDataRef(dataref);
    //    }
    //  }
    }
}
