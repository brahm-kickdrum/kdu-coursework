package org.example.question2;

import java.util.logging.Level;
import java.util.logging.Logger;

class MessageReceiverQ2 implements Runnable {
    private static final Logger logger = Logger.getLogger(MessageReceiverQ2.class.getName());

    private MessageQueueQ2 messageQueue;

    public MessageReceiverQ2(MessageQueueQ2 messageQueue) {
        this.messageQueue = messageQueue;
    }

    /**
     * over ridden run function
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String message = messageQueue.getMessage();
                if (message != null) {
                    logger.log(Level.INFO, "Receiver received: {0}", message);
                }
            }
        } finally {
            logger.log(Level.INFO, "Receiver thread finished.");
        }
    }
}
