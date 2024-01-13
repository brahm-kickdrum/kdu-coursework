package org.example.question1;
import java.util.logging.Level;
import java.util.logging.Logger;

class MessageReceiver extends Thread {

    private final MessageQueue messageQueue;
    private final int receiverId;
    private static final Logger logger = Logger.getLogger(MessageReceiver.class.getName());


    public MessageReceiver(MessageQueue messageQueue, int receiverId) {
        this.messageQueue = messageQueue;
        this.receiverId = receiverId;
    }

    /**
     * over ridden run function
     */
    @Override
    public void run() {
        while (true) {
            String message = messageQueue.getMessage();
            if (message != null) {
                logger.log(Level.INFO, "Receiver {0} received: {1}", new Object[]{receiverId, message});
            }
        }
    }
}