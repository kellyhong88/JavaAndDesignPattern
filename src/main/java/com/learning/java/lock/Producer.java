package com.learning.java.lock;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Producer implements Runnable {

    private QueueBuffer queueBuffer;

    private boolean keepRunning = true;

    public Producer(QueueBuffer queueBuffer) {
        this.queueBuffer = queueBuffer;
        new Thread(this, "Producer Thread").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (keepRunning) {
            queueBuffer.put(++i);
        }
    }

}
