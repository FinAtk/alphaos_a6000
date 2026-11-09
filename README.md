# ALPHA OS

An experimental, photography first application interface for the Sony α6000 (ILCE 6000).

ALPHA OS explores a more coherent camera interface, configurable shooting workflows, improved physical control navigation and additional on device photography tools.

The project aims to extend the existing camera experience rather than replace Sony's imaging system or modify proprietary firmware.

## Project direction

- Camera: Sony α6000 / ILCE 6000
- Target firmware: 3.21
- Interface: Minimal, responsive and photography focused
- Architecture: Independent application layer with separate camera integration
- Primary objective: Improve the shooting experience while preserving the stock imaging pipeline

## Current status

**Early application prototype**

The initial Android application structure and interface have been committed.

Current interface sections:

- Shoot
- Profiles
- Library
- System

The application currently uses a disconnected camera adapter. It does not yet communicate with the camera.

### Present in source

- Initial Android application structure
- Native Android interface
- Four section navigation
- Initial shooting workspace
- Profile and library placeholders
- System and capability status screens
- Camera abstraction interface
- Explicit untested camera state

### Not yet implemented or verified

- Successful application build
- Sony camera connection
- Live camera preview
- Autofocus integration
- Image capture
- Camera setting access
- Physical button and dial integration
- Functional colour profile configuration
- Image library access
- On device image recognition
- Custom image processing
- Installation and operation on the camera

No working APK or camera installation has yet been verified.

## Technical approach

ALPHA OS is being developed as an application layer for the Sony camera environment.

The initial implementation uses a legacy Android application structure informed by existing Sony camera development projects.

Sony specific functionality will be isolated behind a camera adapter. Unsupported features must remain clearly identified rather than being presented as operational.

Development priorities:

1. Establish a reproducible build environment.
2. Improve interface navigation and responsiveness.
3. Investigate camera detection and device information.
4. Integrate physical controls.
5. Investigate live preview and image capture.
6. Develop configurable shooting profiles.
7. Research image analysis and recognition within the camera's hardware limitations.

## Project principles

- Preserve Sony's existing imaging pipeline.
- Prioritise photography and shooting usability.
- Avoid unnecessary interface complexity.
- Keep camera integration modular.
- Clearly distinguish implemented, experimental and unsupported features.
- Validate functionality on the actual camera before claiming compatibility.
- Credit upstream projects and respect their licences.

## Repository structure

```text
alphaos_a6000/
├── app/
│   └── src/main/
│       ├── java/com/finatk/alphaos/
│       │   ├── MainActivity.java
│       │   ├── CameraGateway.java
│       │   └── UnconnectedCameraGateway.java
│       └── AndroidManifest.xml
├── docs/
│   ├── PROJECT_STATUS.md
│   ├── PLATFORM_RESEARCH.md
│   └── TECHNICAL_ARCHITECTURE.md
├── build.gradle
└── settings.gradle
