
# ALPHA OS technical architecture

## 1. Overview

ALPHA OS is designed as a photography focused application layer for the Sony ILCE 6000 (α6000).

The initial implementation will use the existing Sony camera application environment rather than attempting to replace the camera firmware.

The architecture separates the user interface from camera specific functionality. This allows the interface to be developed and tested independently, while camera integration is investigated incrementally.

## 2. Target platform

| Property | Current finding |
|---|---|
| Camera | Sony ILCE 6000 |
| Model identifier | ILCE-6000 |
| Owner reported firmware | 3.21 |
| Sony camera platform | OpenMemories lists API 2.4 |
| Development reference | OpenMemories Framework |
| Installation research | Sony PMCA RE and related community tools |
| Physical validation | Pending |

The Sony platform API version is not the same thing as the Android API level.

The precise Android runtime version, available libraries, memory limits, screen characteristics and application permissions must be verified against the target camera before selecting a final build configuration.

## 3. Core architecture

The application will be divided into five main layers.

### Presentation layer

Responsible for the interface and user interaction.

Planned components:

- Home and shooting dashboard
- Exposure information panel
- Shooting mode interface
- Custom colour profile browser
- Focus and composition tools
- Image review interface
- Settings and system information

The presentation layer must not directly call undocumented Sony APIs.

### Application layer

Coordinates user actions and application state.

Responsibilities:

- Navigation
- Shooting workflow state
- Profile selection
- Settings presentation
- Capability checks
- Error handling
- Session management

### Camera abstraction layer

Provides a consistent interface between ALPHA OS and the camera.

Proposed responsibilities:

- Camera identification
- Firmware identification
- Available capability detection
- Exposure setting access, where supported
- Focus information, where supported
- Capture requests, where supported
- Media browsing
- Camera event reporting

Every operation must have an explicit result. Unsupported operations must not silently appear successful.

### Sony integration layer

Contains the implementation that communicates with the Sony camera environment.

This layer will be developed only against APIs verified in the OpenMemories source, Sony API stubs, documentation or controlled hardware tests.

No undocumented API should be treated as functional merely because a similarly named class exists in another camera application.

### Data and configuration layer

Stores ALPHA OS preferences and application data.

Planned data:

- User interface preferences
- Custom profile definitions
- Profile metadata
- Application settings
- Capability information
- Diagnostic logs

Camera configuration must remain separate from application preferences. The application must not overwrite camera settings without an explicit user action.

## 4. Capability model

Each camera feature must expose one of the following states:

| State | Meaning |
|---|---|
| Supported | Confirmed through a working implementation |
| Experimental | Implemented but not reliably validated |
| Unavailable | The required API or hardware capability is absent |
| Not tested | Compatibility has not yet been established |

This is particularly important for camera controls. A control displayed in the interface must not imply that the camera has accepted the requested setting.

## 5. Interface direction

The visual direction is minimal, functional and photography first.

Design priorities:

1. Clear shooting information.
2. Fast access to frequently used functions.
3. Consistent navigation.
4. Large and legible controls.
5. Minimal visual interruption while composing.
6. Responsive transitions without unnecessary animation.
7. Clear feedback when a setting changes or an operation fails.

The interface should be designed around the camera's physical display and controls rather than simply shrinking a modern smartphone interface.

## 6. Colour profile system

The initial colour profile system will describe combinations of camera settings that are actually available through verified camera APIs.

Each profile should contain:

- Profile name
- Description
- Intended lighting conditions
- Intended photographic character
- Supported camera setting values
- Compatibility information
- Version number

Profiles must distinguish between settings that have been successfully applied and settings that are only recommendations.

The first implementation will not claim to install custom LUTs, alter sensor colour science or modify Sony's image processing pipeline.

## 7. Image recognition research

Image recognition is a secondary development objective.

Potential applications include:

- Scene classification
- Subject identification
- Composition assistance
- Exposure guidance
- Contextual shooting recommendations

The initial research should prioritise lightweight models and efficient image processing.

Before implementation, the project must establish:

- Available processing hardware
- Memory limits
- Available image access methods
- Supported image formats
- Whether inference can run without interrupting shooting
- Power and thermal implications

Recognition must remain optional and must not interfere with normal camera operation.

## 8. Development and testing strategy

### Stage 1: Platform verification

- Inspect OpenMemories Framework.
- Inspect Sony API stubs.
- Confirm build tooling and supported Java version.
- Identify the camera's application environment.
- Verify the installation pathway for firmware 3.21.

### Stage 2: Interface prototype

- Build the navigation structure.
- Implement the shooting dashboard.
- Implement reusable controls.
- Add mock camera data.
- Test screen layouts and interaction states.

### Stage 3: Camera integration

- Implement camera identification.
- Connect verified camera information APIs.
- Add supported media access.
- Investigate exposure and capture APIs.
- Add error handling and capability reporting.

### Stage 4: Photography features

- Implement supported shooting workflows.
- Develop the colour profile system.
- Investigate focus and composition assistance.
- Measure performance and memory usage.

### Stage 5: Advanced features

- Investigate image recognition.
- Explore additional camera information.
- Evaluate whether further image processing is possible without modifying proprietary firmware.

## 9. Safety and reliability

ALPHA OS must not depend on replacing the camera's original firmware.

Development and installation must avoid:

- Unverified firmware modifications
- Unnecessary writes to camera system storage
- Unbacked changes to camera settings
- Unverified background processes
- Unsupported assumptions about hardware capabilities

All experimental functionality should be isolated so that it can be disabled without affecting the rest of the application.

## 10. Upstream projects and attribution

The following projects provide the technical foundation for research.

### OpenMemories Framework

https://github.com/ma1co/OpenMemories-Framework

Provides a framework for developing Android applications for supported Sony cameras, including the α6000.

### OpenMemories Platform

https://github.com/ma1co/OpenMemories-Platform

Provides further research and documentation concerning Sony camera application environments.

### Sony PMCA RE

https://github.com/ma1co/Sony-PMCA-RE

A community project for interacting with Sony cameras and installing applications.

### Sony α6000 firmware research

https://github.com/CliffVale/sony-a6000-firmware-research

A research reference for investigating the camera's firmware.

These projects are research dependencies, not components that have automatically been incorporated into ALPHA OS.

Any source code reused or adapted must retain the appropriate attribution and comply with the licence of the exact revision used.

## 11. Current implementation status

| Component | Status |
|---|---|
| Project direction | Defined |
| Platform reference identified | Research confirmed |
| Application architecture | Documented |
| Interface implementation | Pending |
| Camera adapter | Pending |
| Sony API integration | Pending |
| Colour profile engine | Pending |
| Image recognition | Research stage |
| Build configuration | Pending |
| Physical camera testing | Pending |
