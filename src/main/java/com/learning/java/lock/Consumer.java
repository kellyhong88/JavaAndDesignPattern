package com.learning.java.lock;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Consumer implements Runnable {

    private QueueBuffer queueBuffer;

    private boolean keepRunning = true;

    public Consumer(QueueBuffer queueBuffer) {
        this.queueBuffer = queueBuffer;
        new Thread(this, "Consumer Thread").start();
    }

    @Override
    public void run() {
        while (keepRunning) {
            queueBuffer.get();
        }
    }

}
