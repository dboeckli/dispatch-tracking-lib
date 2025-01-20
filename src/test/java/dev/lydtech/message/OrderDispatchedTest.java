package dev.lydtech.message;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class OrderDispatchedTest {

    @Test
    void testBuilderAndGetters() {
        UUID orderId = UUID.randomUUID();
        UUID processedById = UUID.randomUUID();
        String notes = "Test notes";

        OrderDispatched orderDispatched = OrderDispatched.builder()
            .orderId(orderId)
            .processedById(processedById)
            .notes(notes)
            .build();

        assertEquals(orderId, orderDispatched.getOrderId());
        assertEquals(processedById, orderDispatched.getProcessedById());
        assertEquals(notes, orderDispatched.getNotes());
    }

    @Test
    void testAllArgsConstructor() {
        UUID orderId = UUID.randomUUID();
        UUID processedById = UUID.randomUUID();
        String notes = "Test notes";

        OrderDispatched orderDispatched = new OrderDispatched(orderId, processedById, notes);

        assertEquals(orderId, orderDispatched.getOrderId());
        assertEquals(processedById, orderDispatched.getProcessedById());
        assertEquals(notes, orderDispatched.getNotes());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UUID orderId = UUID.randomUUID();
        UUID processedById = UUID.randomUUID();
        String notes = "Test notes";

        OrderDispatched orderDispatched = new OrderDispatched();
        orderDispatched.setOrderId(orderId);
        orderDispatched.setProcessedById(processedById);
        orderDispatched.setNotes(notes);

        assertEquals(orderId, orderDispatched.getOrderId());
        assertEquals(processedById, orderDispatched.getProcessedById());
        assertEquals(notes, orderDispatched.getNotes());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID orderId = UUID.randomUUID();
        UUID processedById = UUID.randomUUID();
        String notes = "Test notes";

        OrderDispatched orderDispatched1 = new OrderDispatched(orderId, processedById, notes);
        OrderDispatched orderDispatched2 = new OrderDispatched(orderId, processedById, notes);

        assertEquals(orderDispatched1, orderDispatched2);
        assertEquals(orderDispatched1.hashCode(), orderDispatched2.hashCode());
    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();
        UUID processedById = UUID.randomUUID();
        String notes = "Test notes";

        OrderDispatched orderDispatched = new OrderDispatched(orderId, processedById, notes);

        String toString = orderDispatched.toString();
        assertTrue(toString.contains(orderId.toString()));
        assertTrue(toString.contains(processedById.toString()));
        assertTrue(toString.contains(notes));
    }
}
