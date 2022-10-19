#ifdef RCT_NEW_ARCH_ENABLED
#import "RNExtplaneSpec.h"

@interface Extplane : NSObject <NativeExtplaneSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Extplane : NSObject <RCTBridgeModule>
#endif

@end
