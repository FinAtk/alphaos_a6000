
package com.finatk.alphaos;

/**
 * Boundary between the ALPHA OS interface and camera hardware.
 *
 * Implementations must only report capabilities that have been
 * verified on the target camera.
 */
public interface CameraGateway {

    enum State {
        SUPPORTED,
        EXPERIMENTAL,
        UNAVAILABLE,
        NOT_TESTED
    }

    State getConnectionState();

    String getConnectionDescription();
}
