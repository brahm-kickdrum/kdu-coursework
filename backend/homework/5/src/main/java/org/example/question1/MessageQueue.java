package org.example.question1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MessageQueue {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    /**
     * addMessage function adds a message to the queue and handle exceptions
     * @param message
     */
    public void addMessage(String message) {
        try {
            queue.put(message);
            synchronized (this) {
                notifyAll();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * getMessage function retrieves a message from the queue
     * @return
     */

    public String getMessage() {
        try {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }
            }
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}