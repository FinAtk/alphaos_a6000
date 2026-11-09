
# ALPHA OS platform research

## Target hardware

- Camera: Sony ILCE 6000 / α6000
- Firmware: 3.21, as reported by the owner
- Sony camera application platform: API 2.4
- Application runtime: Android 2.3.7 compatibility
- Intended deployment: PlayMemories Camera Apps application environment

Sony platform API 2.4 is not Android API level 2.4. These are separate version systems.

## Installation and deployment

The α6000 is listed as a supported PlayMemories Camera Apps device.

The original Sony PMCA RE project documents installation of custom Android applications over USB. Its documentation also warns that this work relies on reverse engineering and is not officially supported by Sony.

PMCA RE Reloaded is a newer independent implementation. Its project documentation reports successful application installation and settings access on an α6000 running firmware 3.21. The reported test was performed on Linux. Windows deployment remains to be verified independently.

The original Sony PlayMemories Camera Apps download service has closed. ALPHA OS must therefore be packaged and installed independently.

References:

- https://github.com/ma1co/Sony-PMCA-RE
- https://github.com/masterflai/pmca-re-reloaded
- https://masterflai.github.io/pmca-re-reloaded/
- https://github.com/ma1co/OpenMemories-Framework/blob/master/docs/Cameras.md

## Application runtime and build environment

The PMCADemo reference project provides a practical starting point.

Its build configuration uses:

- Android Gradle plugin 2.2.3
- Android compile SDK 10
- Android minimum SDK 10
- Android target SDK 10
- Java source compatibility 1.6
- Android build tools 25.0.2
- OpenMemories Framework
- Sony API stubs

These are legacy dependencies. The project must be kept compatible with the camera runtime rather than adopting current Android development defaults.

The original project uses JCenter and JitPack dependencies. Dependency availability and reproducible builds must be checked before implementation is considered stable.

Reference:

- https://github.com/ma1co/PMCADemo
- https://github.com/ma1co/OpenMemories-Framework

## Verified reference functionality

The PMCADemo source demonstrates the following integration patterns:

### Camera preview

- Opens the Sony CameraEx interface.
- Retrieves the normal Android camera interface.
- Displays the preview through a SurfaceView.
- Starts preview when the surface is created.
- Releases the camera when the activity pauses.

### Physical controls

The reference BaseActivity maps Sony ScalarInput events to application actions.

Documented inputs include:

- Directional buttons
- Enter
- Function
- AEL
- Menu
- Half press shutter
- Full press shutter
- Playback
- Movie record
- Custom button
- Delete
- Lens attachment
- Control dials
- Mode dial

### Focus and capture

The reference CameraActivity maps half press to autofocus and full press to image capture.

These patterns are evidence that the APIs exist in the reference environment. They are not yet proof that every function works correctly on the target camera.

Reference source:

- https://github.com/ma1co/PMCADemo

## Live preview investigation

A separate OpenMemories Framework discussion documents investigation of Sony's CameraSequence interface for live preview.

The discussion describes a preview sequence that retrieves JPEG frames through device memory buffers. It also reports that the standard Android preview callback did not work in that particular investigation.

This is a possible route for more advanced preview processing, but it must not be assumed to work on the α6000 until tested.

Reference:

- https://github.com/ma1co/OpenMemories-Framework/issues/35

## ALPHA OS implementation strategy

The initial application will be divided into separate layers.

1. Interface layer

   Handles navigation, layout, menus, status information and interaction.

2. Application layer

   Handles shooting workflows, profile selection, configuration and application state.

3. Camera abstraction layer

   Defines the camera operations available to the application without tying the interface to Sony specific classes.

4. Sony integration layer

   Implements verified Sony camera functions through OpenMemories and Sony APIs.

5. Data layer

   Stores user preferences, profile definitions and application configuration.

The interface must remain usable when a camera feature is unavailable.

## Feature capability states

Every camera feature must have an explicit state:

- Supported: implementation and validation completed.
- Experimental: implementation exists but requires further validation.
- Unavailable: the required API or hardware capability is not accessible.
- Not tested: no reliable validation has been completed.

The interface must not present an untested feature as operational.

## Initial implementation priorities

1. Establish a buildable Android application.
2. Implement the ALPHA OS navigation and interface.
3. Implement physical button and dial navigation.
4. Establish camera detection and device information.
5. Implement live preview.
6. Implement half press autofocus and capture.
7. Investigate camera setting access.
8. Develop configurable shooting profiles.
9. Investigate image analysis and recognition.
10. Investigate the limits of image processing available to third party applications.

## Colour science limitations

The initial profile system will use only camera settings that can be verified through accessible Sony APIs.

Custom LUTs, tone curves, RAW processing, sensor pipeline changes and ISP modifications must not be claimed unless a technically valid implementation is demonstrated.

The aim is to improve the consistency and usability of the camera's colour output without compromising the stock imaging pipeline.

## Image recognition limitations

Image recognition should initially be treated as an experimental application feature.

Possible applications include:

- Scene classification
- Subject detection
- Composition guidance
- Exposure and focus assistance

The α6000 has limited processing resources. Recognition must not interfere with capture responsiveness or normal camera operation.

The feasibility of running models locally on the camera remains unverified.

## Licensing and attribution

ALPHA OS is an independent project.

The following upstream projects informed the research:

- OpenMemories Framework: MIT licence
- PMCADemo: MIT licence
- Sony PMCA RE: MIT licence
- PMCA RE Reloaded: inspect its current repository licence before reusing code

Any reused source must retain the applicable copyright and licence notices.

No Sony proprietary firmware, private camera data or proprietary Sony application binaries should be redistributed.

## Validation record

| Area | Status |
|---|---|
| α6000 platform compatibility | Documented |
| Firmware 3.21 installation route | Reported by upstream project |
| Windows installation | Not tested |
| Build environment | Reference project inspected |
| ALPHA OS application | Not implemented |
| Physical control integration | Reference implementation inspected |
| Live preview | Reference implementation inspected |
| Capture integration | Reference implementation inspected |
| Custom colour profiles | Not implemented |
| Image recognition | Not implemented |
| Physical camera validation | Required |

This document records research findings, not completed ALPHA OS functionality.
