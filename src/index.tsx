const Extplane = require('./NativeExtplane').default;

export function start(ip: string, port: number = 51000) {
  Extplane.start(ip, port);
}

export function includeDataRef(dataRefName: string, precision: number = 0.1) {
  Extplane.includeDataRef(dataRefName, precision);
}

export function excludeDataRef(dataRefName: string) {
  Extplane.excludeDataRef(dataRefName);
}

export function getDataRefValue(dataRefName: string) {
  return Extplane.getDataRefValue(dataRefName);
}

export function getDataRefType(dataRefName: string) {
  Extplane.getDataRefType(dataRefName);
}

export function getDataRef(dataRefName: string) {
  return Extplane.getDataRef(dataRefName);
}

export function observeDataRef(dataRefName: string) {
  Extplane.observeDataRef(dataRefName);
}

export function unObserveDataRef(dataRefName: string) {
  Extplane.unObserveDataRef(dataRefName);
}

// TODO
// iface.setDataRefValue(altimeterSettingDataRefName, "30.0");
// iface.setDataRefValue(engintThrottleDataRefName, new String[] {"1.0", "1.0", "1.0", "1.0", "1.0", "1.0", "1.0", "1.0"});
// iface.sendMessage(new DataRefCommand(DataRefCommand.DATAREF_ACTION.SET, dataRefName, value))
