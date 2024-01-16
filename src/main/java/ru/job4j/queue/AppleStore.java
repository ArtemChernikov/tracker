package ru.job4j.queue;

import java.util.Queue;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 16.01.2024
 */
public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            lastHappyCustomer = queue.poll();
        }
        return lastHappyCustomer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer = null;
        for (int i = 0; i < count + 1; i++) {
            firstUpsetCustomer = queue.poll();
        }
        return firstUpsetCustomer.name();
    }
}
