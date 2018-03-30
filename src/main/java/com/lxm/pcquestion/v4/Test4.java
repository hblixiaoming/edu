package com.lxm.pcquestion.v4;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.AppleConsumer;
import com.lxm.pcquestion.AppleProducer;
import com.lxm.pcquestion.Container;

public class Test4 {
    public static void main(String[] args) throws Exception {
        Container<Apple> appleContainer = new NormalQueueContainer();

        AppleProducer appleProducer = new AppleProducer(appleContainer);
        Thread producer = new Thread(appleProducer, "ProducerThread");
        producer.start();

        AppleConsumer appleConsumer = new AppleConsumer(appleContainer);
        Thread consumer = new Thread(appleConsumer, "ConsumerThread");
        consumer.start();
    }
}
