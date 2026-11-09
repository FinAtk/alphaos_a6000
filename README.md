# ALPHA OS

An experimental, photography first application interface for the Sony α6000 (ILCE 6000).

ALPHA OS explores a more coherent camera interface, configurable shooting workflows, improved physical control navigation and additional on device photography tools.

The project aims to extend the existing camera experience rather than replace Sony's imaging system or modify proprietary firmware.

## Project direction

- Camera: Sony α6000 / ILCE 6000
- Target firmware: 3.21
- Interface: Minimal, responsive and photography focused
- Architecture: Independent application layer with a separate camera integration layer
- Primary objective: Improve the shooting experience while preserving the camera's existing imaging pipeline

## Current development status

<ins>Experimental application shell</ins>

The initial Android application structure and interface have been committed.

Current interface sections:

- Shoot
- Profiles
- Library
- System

The application currently uses a disconnected camera adapter. The interface does not yet communicate with the camera.

### Implemented in source

- Initial Android application structure
- Native Android interface
- Four section navigation
- Initial shooting workspace
- Placeholder profile screens
- Library placeholder
- System and capability status screens
- Camera abstraction interface
- Explicit untested camera state

### Not yet implemented

- Sony camera connection
- Live camera preview
- Autofocus integration
- Image capture
- Camera setting access
- Physical button and dial integration
- Working colour profile configuration
- Image library access
- On device image recognition
- Custom image processing

No working APK or camera installation has yet been verified.

## Technical approach

ALPHA OS is being developed as an application for the Sony camera environment.

The initial implementation uses the legacy Android application structure found in the PMCADemo reference project.

Sony specific functionality will be isolated behind a camera adapter. This allows the interface to remain usable during development without falsely presenting untested camera functions as operational.

The project will prioritise:

1. A reproducible build environment
2. Reliable interface navigation
3. Camera detection and device information
4. Physical control integration
5. Live preview and capture
6. Configurable shooting profiles
7. Image analysis and recognition research

## Repository structure

```text
alphaos_a6000/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/finatk/alphaos/
│           │   ├── MainActivity.java
│           │   ├── CameraGateway.java
│           │   └── UnconnectedCameraGateway.java
│           └── AndroidManifest.xml
├── docs/
│   ├── PROJECT_STATUS.md
│   ├── PLATFORM_RESEARCH.md
│   └── TECHNICAL_ARCHITECTURE.md
├── build.gradle
└── settings.gradle
