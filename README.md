# MapboxIssuesDemonstrator

https://github.com/mapbox/mapbox-gl-native/issues/13116

Mapbox crash when embedded in a fragment.
The crash seems to happen when the fragment is removed before Mapbox has finished initialization.

To reproduce, just click show and hide.

io.mapwize.mapboxissuesdemonstrator A/libc: Fatal signal 11 (SIGSEGV), code 1, fault addr 0x0 in tid 1166 (GLThread 2882), pid 1116 (uesdemonstrator)
