const Extplane = require('./NativeExtplane').default;

export function multiply(a: number, b: number): number {
  return Extplane.multiply(a, b);
}
