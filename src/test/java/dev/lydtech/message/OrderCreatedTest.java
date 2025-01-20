package dev.lydtech.message;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderCreatedTest {

    @Test
    void testBuilderAndGetters() {
        UUID orderId = UUID.randomUUID();
        String item = "Item 1";
        
        OrderCreated orderCreated = OrderCreated.builder()
            .orderId(orderId)
            .item(item)
            .build();

        assertEquals(orderId, orderCreated.getOrderId());
        assertEquals(item, orderCreated.getItem());
    }

    @Test
    void testAllArgsConstructor() {
        UUID orderId = UUID.randomUUID();
        String item = "Item 1";
        
                OrderCreated orderCreated = new OrderCreated(orderId, item);

        assertEquals(orderId, orderCreated.getOrderId());
        assertEquals(item, orderCreated.getItem());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        UUID orderId = UUID.randomUUID();
        String item = "Item 1";
        
        OrderCreated orderCreated = new OrderCreated();
        orderCreated.setOrderId(orderId);
        orderCreated.setItem(item);

        assertEquals(orderId, orderCreated.getOrderId());
        assertEquals(item, orderCreated.getItem());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID orderId = UUID.randomUUID();
        String item = "Item 1";

        OrderCreated orderCreated1 = new OrderCreated(orderId, item);
        OrderCreated orderCreated2 = new OrderCreated(orderId, item);

        assertEquals(orderCreated1, orderCreated2);
        assertEquals(orderCreated1.hashCode(), orderCreated2.hashCode());
    }

    @Test
    void testToString() {
        UUID orderId = UUID.randomUUID();
        String item = "Item 1";

        OrderCreated orderCreated = new OrderCreated(orderId, item);

        String toString = orderCreated.toString();
        
        assertTrue(toString.contains(orderId.toString()));
        assertTrue(toString.contains(item));
    }

}
