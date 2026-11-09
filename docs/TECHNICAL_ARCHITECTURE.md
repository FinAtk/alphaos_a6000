# ALPHA OS technical architecture

## 1. Purpose

This document defines the intended technical structure of ALPHA OS, an experimental photography focused application for the Sony α6000 (ILCE 6000).

The architecture is designed around three priorities:

1. A responsive and coherent camera interface.
2. A modular integration with Sony camera functionality.
3. A stable application that preserves the camera's existing imaging pipeline.

ALPHA OS is initially an application layer, not a replacement firmware or a modification of Sony's underlying camera operating system.

The architecture is provisional. All camera dependent functionality must be verified against the actual α6000 and its firmware.

## 2. Target platform

| Property | Target |
|---|---|
| Camera | Sony α6000 / ILCE 6000 |
| Firmware | 3.21 |
| Camera platform | Sony application environment |
| Application language | Java |
| Initial Android compatibility target | API level 10 |
| Initial interface | Native Android views |
| Orientation | Landscape |
| Architecture | Modular application with camera adapter |

The initial source uses a legacy Android Gradle configuration. Its compatibility and build requirements have not yet been verified.

Sony camera platform APIs and Android API levels are separate versioning systems. They must not be treated as interchangeable.

## 3. Architectural overview

ALPHA OS is divided into five logical layers.

```text
+--------------------------------------+
|             Presentation             |
|  Shoot | Profiles | Library | System  |
+--------------------------------------+
                  |
                  v
+--------------------------------------+
|          Application logic           |
| Navigation | State | Settings | Flow  |
+--------------------------------------+
                  |
                  v
+--------------------------------------+
|           Camera gateway             |
| Capabilities | Inputs | Preview      |
| Capture | Exposure | Focus            |
+--------------------------------------+
                  |
                  v
+--------------------------------------+
|          Sony integration             |
| Sony APIs | Camera lifecycle | Events |
+--------------------------------------+
                  |
                  v
+--------------------------------------+
|             Camera hardware          |
| Sensor | Lens | Controls | Storage    |
+--------------------------------------+
