package dev.lydtech.message;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DispatchCompletedTest {

    @Test
    void testBuilderAndGetters() {
        UUID orderId = UUID.randomUUID();
        String dispatchedDate = "2023-06-15";

        DispatchCompleted dispatchCompleted = DispatchCompleted.builder()
            .orderId(orderId)
            .dispatchedDate(dispatchedDate)
            .build();

        assertEquals(orderId, dispatchCompleted.getOrderId());
        assertEquals(dispatchedDate, dispatchCompleted.getDispatchedDate());
    }

    @Test
    void testAllArgsConstructor() {
        UUID orderId = UUID.randomUUID();
        String dispatchedDate = "2023-06-15";

        DispatchCompleted dispatchCompleted = new DispatchCompleted(orderId, dispatchedDate);

        assertEquals(orderId, dispatchCompleted.getOrderId());
        assertEquals(dispatchedDate, dispatchCompleted.getDispatchedDate());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UUID orderId = UUID.randomUUID();
        String dispatchedDate = "2023-06-15";

        DispatchCompleted dispatchCompleted = new DispatchCompleted();
        dispatchCompleted.setOrderId(orderId);
        dispatchCompleted.setDispatchedDate(dispatchedDate);

        assertEquals(orderId, dispatchCompleted.getOrderId());
        assertEquals(dispatchedDate, dispatchCompleted.getDispatchedDate());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID orderId = UUID.randomUUID();
        String dispatchedDate = "2023-06-15";

        DispatchCompleted dispatchCompleted1 = new DispatchCompleted(orderId, dispatchedDate);
        DispatchCompleted dispatchCompleted2 = new DispatchCompleted(orderId, dispatchedDate);

        assertEquals(dispatchCompleted1, dispatchCompleted2);
        assertEquals(dispatchCompleted1.hashCode(), dispatchCompleted2.hashCode());
    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();
        String dispatchedDate = "2023-06-15";

        DispatchCompleted dispatchCompleted = new DispatchCompleted(orderId, dispatchedDate);

        String toString = dispatchCompleted.toString();
        assertTrue(toString.contains(orderId.toString()));
        assertTrue(toString.contains(dispatchedDate));
    }

}
