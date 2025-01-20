package dev.lydtech.message;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrackingStatusUpdatedTest {

    @Test
    void testBuilderAndGetters() {
        UUID orderId = UUID.randomUUID();
        TrackingStatus status = TrackingStatus.PREPARING;

        TrackingStatusUpdated trackingStatusUpdated = TrackingStatusUpdated.builder()
            .orderId(orderId)
            .status(status)
            .build();

        assertEquals(orderId, trackingStatusUpdated.getOrderId());
        assertEquals(status, trackingStatusUpdated.getStatus());
    }

    @Test
    void testAllArgsConstructor() {
        UUID orderId = UUID.randomUUID();
        TrackingStatus status = TrackingStatus.DISPATCHED;

        TrackingStatusUpdated trackingStatusUpdated = new TrackingStatusUpdated(orderId, status);

        assertEquals(orderId, trackingStatusUpdated.getOrderId());
        assertEquals(status, trackingStatusUpdated.getStatus());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UUID orderId = UUID.randomUUID();
        TrackingStatus status = TrackingStatus.PREPARING;

        TrackingStatusUpdated trackingStatusUpdated = new TrackingStatusUpdated();
        trackingStatusUpdated.setOrderId(orderId);
        trackingStatusUpdated.setStatus(status);

        assertEquals(orderId, trackingStatusUpdated.getOrderId());
        assertEquals(status, trackingStatusUpdated.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID orderId = UUID.randomUUID();
        TrackingStatus status = TrackingStatus.PREPARING;

        TrackingStatusUpdated trackingStatusUpdated1 = new TrackingStatusUpdated(orderId, status);
        TrackingStatusUpdated trackingStatusUpdated2 = new TrackingStatusUpdated(orderId, status);

        assertEquals(trackingStatusUpdated1, trackingStatusUpdated2);
        assertEquals(trackingStatusUpdated1.hashCode(), trackingStatusUpdated2.hashCode());
    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();
        TrackingStatus status = TrackingStatus.DISPATCHED;

        TrackingStatusUpdated trackingStatusUpdated = new TrackingStatusUpdated(orderId, status);

        String toString = trackingStatusUpdated.toString();
        assertTrue(toString.contains(orderId.toString()));
        assertTrue(toString.contains(status.toString()));
    }

}
