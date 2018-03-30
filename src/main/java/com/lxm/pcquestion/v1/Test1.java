package com.lxm.pcquestion.v1;

import com.lxm.pcquestion.Apple;
import com.lxm.pcquestion.AppleConsumer;
import com.lxm.pcquestion.AppleProducer;
import com.lxm.pcquestion.Container;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Container<Apple> appleContainer = new BlockintQueueV1Container();

        AppleProducer appleProducer = new AppleProducer(appleContainer);
        Thread producer = new Thread(appleProducer, "ProducerThread");
        producer.start();

        AppleConsumer appleConsumer = new AppleConsumer(appleContainer);
        Thread consumer = new Thread(appleConsumer, "ConsumerThread");
        consumer.start();
    }
}
