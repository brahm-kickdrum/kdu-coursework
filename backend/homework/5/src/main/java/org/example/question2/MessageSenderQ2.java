package org.example.question2;

class MessageSenderQ2 implements Runnable {
    private MessageQueueQ2 messageQueue;
    private int senderId;

    public MessageSenderQ2(MessageQueueQ2 messageQueue, int senderId) {
        this.messageQueue = messageQueue;
        this.senderId = senderId;
    }

    /**
     * over ridden run function
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String message = "Message from Sender " + senderId + ": " + i;
            messageQueue.addMessage(message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}


