package org.example.question1;

class MessageSender extends Thread {

    private final MessageQueue messageQueue;
    private final int senderId;

    public MessageSender(MessageQueue messageQueue, int senderId) {
        this.messageQueue = messageQueue;
        this.senderId = senderId;
    }

    /**
     * over ridden run function
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Sending 5 messages
            String message = "Message from Sender " + senderId + ": " + i;
            messageQueue.addMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}