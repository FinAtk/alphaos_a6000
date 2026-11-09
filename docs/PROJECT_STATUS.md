# ALPHA OS project status

## Project overview

ALPHA OS is an experimental, photography focused application interface for the Sony α6000 (ILCE 6000).

Target firmware: 3.21, as reported by the project owner.

The project explores a more coherent shooting interface, configurable photography workflows and improved access to camera functions.

The intended approach is hybrid: preserve Sony's existing imaging system while developing an independent application layer.

## Current development status

The initial application source has been committed to the repository.

The current application contains four interface sections:

- Shoot
- Profiles
- Library
- System

It uses native Android views and a camera abstraction interface. The current camera adapter is deliberately disconnected.

This is an early application prototype, not a functioning replacement camera operating system.

## Confirmed implementation

| Component | Status |
|---|---|
| Android project structure | Committed |
| Main application activity | Committed |
| Initial interface navigation | Committed |
| Shoot interface placeholder | Committed |
| Profiles interface placeholder | Committed |
| Library interface placeholder | Committed |
| System interface placeholder | Committed |
| Camera abstraction | Committed |
| Disconnected camera adapter | Committed |

These entries describe source code presence only. They do not imply successful compilation or operation on the camera.

## Outstanding implementation

| Component | Status |
|---|---|
| Reproducible build environment | Not established |
| Successful APK compilation | Not verified |
| Sony camera detection | Not implemented |
| Live preview | Not implemented |
| Image capture | Not implemented |
| Autofocus integration | Not implemented |
| Camera settings access | Not implemented |
| Physical buttons and dials | Not implemented |
| Functional shooting profiles | Not implemented |
| Image library integration | Not implemented |
| On device image recognition | Research only |
| Custom image processing | Not implemented |
| Camera installation | Not attempted |
| Physical camera validation | Not performed |

## Platform research

Existing community development provides a potential route for third party applications on the α6000.

The OpenMemories Framework lists the A6000 as a supported camera target. Its wrappers expose Sony specific functionality, although not every camera API is implemented or available.

PMCADemo provides a useful reference for application structure, camera preview and physical input handling.

PMCA RE and PMCA RE Reloaded provide research and installation routes for Sony camera applications.

These references establish a plausible development direction, not proof that the current ALPHA OS application works.

Important technical distinction:

Sony's camera application API version and Android API level are separate versioning systems. The Sony platform API version must not be confused with Android API level 10.

## Engineering priorities

### Stage 1: Application foundation

- Establish a reproducible legacy Android build environment.
- Confirm compatible Gradle, Android Gradle Plugin, Java and SDK versions.
- Resolve project configuration problems.
- Produce a debug APK.
- Test application launch independently of camera integration.

### Stage 2: Camera integration

- Investigate Sony camera application APIs.
- Implement camera detection and device information.
- Map physical buttons and control dials.
- Investigate a reliable live preview implementation.
- Implement image capture only after the preview and camera lifecycle are understood.

### Stage 3: Photography workflow

- Develop functional shooting profiles.
- Investigate exposure and focus controls.
- Improve access to frequently used settings.
- Develop a practical image review workflow.
- Ensure the interface remains responsive and usable on the camera display.

### Stage 4: Image analysis

- Investigate on device image recognition.
- Assess available processing resources and memory.
- Prioritise lightweight scene classification and subject detection.
- Explore focus assistance and photographic suggestions.
- Avoid interfering with Sony's existing image processing pipeline.

### Stage 5: Hardware validation

- Install a verified build on the α6000.
- Test physical controls and camera lifecycle.
- Validate preview and capture.
- Measure responsiveness and memory usage.
- Record failures and compatibility limitations.

## Colour science and image processing

The initial project will preserve Sony's stock imaging pipeline.

There is currently no verified method implemented for modifying sensor processing, RAW development, JPEG colour rendering or proprietary image processing stages.

Potential improvements should initially focus on:

- Better exposure and focus guidance.
- Scene and subject recognition.
- Configurable shooting workflows.
- Consistent photographic presets where supported by camera APIs.
- Improved image review and organisation.

Any proposed change to image rendering must be tested against actual camera output. Interface simulations must not be described as changes to the camera's image processing.

## Development principles

1. Photography takes priority over unnecessary interface features.
2. Preserve the existing Sony imaging pipeline.
3. Keep camera integration separate from the interface.
4. Make unsupported features visibly unavailable.
5. Avoid unnecessary background processing.
6. Prioritise responsive navigation and clear controls.
7. Validate every hardware dependent feature on the actual camera.
8. Distinguish researched, implemented, compiled, installed and tested functionality.
9. Credit upstream projects and respect their individual licences.
10. Never distribute proprietary Sony firmware or private camera data.

## Upstream projects and acknowledgements

The following projects provide technical research, reference implementations or installation tools.

- OpenMemories Framework  
  https://github.com/ma1co/OpenMemories-Framework

- OpenMemories Platform  
  https://github.com/ma1co/OpenMemories-Platform

- PMCADemo  
  https://github.com/ma1co/PMCADemo

- Sony PMCA RE  
  https://github.com/ma1co/Sony-PMCA-RE

- PMCA RE Reloaded  
  https://masterflai.github.io/pmca-re-reloaded/

- Sony α6000 firmware research  
  https://github.com/CliffVale/sony-a6000-firmware-research

- Recipe Lab  
  https://github.com/voxivoid/recipe-lab-sony-pmca

These projects are independent upstream work. Their inclusion does not imply endorsement or compatibility.

Before adapting source code, inspect the exact revision and retain the appropriate licence notices and attribution. Different versions of a project may have different licences.

ALPHA OS is an independent project and is not affiliated with Sony.

## Validation log

| Validation | Result |
|---|---|
| Project source committed | Confirmed |
| README updated | Confirmed |
| Platform research | Documented |
| Build environment | Not verified |
| APK compilation | Not performed |
| APK installation | Not performed |
| Camera connection | Not tested |
| Live preview | Not tested |
| Image capture | Not tested |
| Physical controls | Not tested |
| Hardware validation | Not performed |

Last status update: 10 November 2026.
