package org.example.question2;

import java.util.concurrent.*;

public class MainQ2 {
    public static void main(String[] args) {
        MessageQueueQ2 messageQueue = new MessageQueueQ2();

        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            senderThreadPool.submit(new MessageSenderQ2(messageQueue, i));
        }

        for (int i = 1; i <= 3; i++) {
            receiverThreadPool.submit(new MessageReceiverQ2(messageQueue));
        }

        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}