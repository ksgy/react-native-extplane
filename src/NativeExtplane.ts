import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  start(ip: string, port: number): void;
  includeDataRef(dataRefName: string, precision: number): void;
  excludeDataRef(dataRefName: string): void;
  getDataRefValue(dataRefName: string): string;
  getDataRefType(dataRefName: string): object;
  getDataRef(dataRefName: string): string;
  observeDataRef(dataRefName: string): void;
  unObserveDataRef(dataRefName: string): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>('Extplane');
