package dev.lydtech.message;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DispatchPreparingTest {

    @Test
    void testBuilderAndGetters() {
        UUID orderId = UUID.randomUUID();

        DispatchPreparing dispatchPreparing = DispatchPreparing.builder()
            .orderId(orderId)
            .build();

        assertEquals(orderId, dispatchPreparing.getOrderId());
    }

    @Test
    void testAllArgsConstructor() {
        UUID orderId = UUID.randomUUID();

        DispatchPreparing dispatchPreparing = new DispatchPreparing(orderId);

        assertEquals(orderId, dispatchPreparing.getOrderId());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UUID orderId = UUID.randomUUID();

        DispatchPreparing dispatchPreparing = new DispatchPreparing();
        dispatchPreparing.setOrderId(orderId);

        assertEquals(orderId, dispatchPreparing.getOrderId());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID orderId = UUID.randomUUID();

        DispatchPreparing dispatchPreparing1 = new DispatchPreparing(orderId);
        DispatchPreparing dispatchPreparing2 = new DispatchPreparing(orderId);

        assertEquals(dispatchPreparing1, dispatchPreparing2);
        assertEquals(dispatchPreparing1.hashCode(), dispatchPreparing2.hashCode());
    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();

        DispatchPreparing dispatchPreparing = new DispatchPreparing(orderId);

        String toString = dispatchPreparing.toString();
        assertTrue(toString.contains(orderId.toString()));
    }
    

}
