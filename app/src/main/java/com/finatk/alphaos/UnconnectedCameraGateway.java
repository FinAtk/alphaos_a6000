
package com.finatk.alphaos;

/**
 * Safe initial implementation.
 *
 * This class deliberately does not attempt to access Sony hardware.
 * It will be replaced by the Sony integration after the application
 * foundation and build environment have been checked.
 */
public class UnconnectedCameraGateway implements CameraGateway {

    public State getConnectionState() {
        return State.NOT_TESTED;
    }

    public String getConnectionDescription() {
        return "Sony camera integration has not been implemented.";
    }
}
