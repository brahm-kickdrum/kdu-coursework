package org.example.question1;


public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        MessageSender[] senders = new MessageSender[3];
        MessageReceiver[] receivers = new MessageReceiver[3];

        for (int i = 0; i < 3; i++) {
            senders[i] = new MessageSender(messageQueue, i);
            receivers[i] = new MessageReceiver(messageQueue, i);
        }

        for (MessageSender sender : senders) {
            sender.start();
        }

        for (MessageReceiver receiver : receivers) {
            receiver.start();
        }
    }
}