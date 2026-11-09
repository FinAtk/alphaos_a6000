
# ALPHA OS project status

## Project direction

ALPHA OS is an experimental, photography first interface and software layer for the Sony ILCE 6000 (α6000), targeting firmware 3.21.

The intended experience is hybrid: retain the camera's existing imaging system while exploring a more coherent, responsive interface and additional photography workflows. The visual direction is minimal and designed around fast access to shooting functions.

## Current repository status

This repository is at the beginning of implementation. The existence of this document does not indicate that a working camera application has been built.

### Confirmed

- Target camera: Sony ILCE 6000 (α6000).
- Target firmware reported by the project owner: version 3.21.
- Project direction: photography first, hybrid, minimal interface.
- Development must distinguish documented research, source code, build checks and physical camera validation.

### Not yet implemented or validated

- A buildable camera application.
- Live camera preview or capture integration.
- Reading or writing camera settings.
- Physical button and dial integration.
- Custom image processing, sensor pipeline changes or RAW processing.
- On device image recognition.
- Installation or execution on an α6000.

No claim of hardware compatibility should be made until a build has been installed and tested on the target camera.

## Engineering principles

1. Preserve the stock camera imaging pipeline unless a documented interface proves a safe extension point.
2. Prefer an application layer over replacing camera firmware.
3. Keep camera access behind a small adapter so unsupported APIs do not spread through the interface.
4. Treat image recognition as a later, resource constrained experiment.
5. Make every camera capability report its status as supported, experimental, unavailable or not yet tested.
6. Do not distribute Sony firmware, proprietary Sony applications, NAND dumps or private camera data.
7. Attribute upstream projects and comply with their exact licences before copying or adapting code.

## Immediate development sequence

1. Record platform evidence and known unknowns.
2. Verify the target runtime and toolchain.
3. Establish a minimal application and build configuration.
4. Build the interface independently of camera hardware.
5. Add a camera capability adapter with explicit unsupported states.
6. Validate compilation and static checks.
7. Proceed to physical camera testing when a safely installable build exists.

## Upstream research

These projects are research references, not proof of compatibility:

- OpenMemories Framework: https://github.com/ma1co/OpenMemories-Framework
- OpenMemories Platform: https://github.com/ma1co/OpenMemories-Platform
- Sony PMCA RE: https://github.com/ma1co/Sony-PMCA-RE
- Sony α6000 firmware research: https://github.com/CliffVale/sony-a6000-firmware-research
- Recipe Lab: https://github.com/voxivoid/recipe-lab-sony-pmca

Before reusing source code, inspect the exact revision and licence. Recipe Lab has had different licensing across versions.

## Validation log

| Area | Status |
|---|---|
| Project direction | Defined |
| Target firmware | Reported by owner, not independently verified |
| Platform compatibility | Research required |
| Application source | Not yet implemented |
| Build | Not run |
| Camera installation | Not attempted |
| Hardware validation | Not performed |
