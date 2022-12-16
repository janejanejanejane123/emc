package com.macro.emc.portal.component;//package com.macro.emc.portal.component;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TopicComponent {
//
//    @KafkaListener(topics = {"hello"})
//    public void handMessage(ConsumerRecord<String, String> record){
//        String topic = record.topic();
//        String msg = record.value();
//        System.out.println("消费者接受消息：topic-->"+topic+",msg->>"+msg);
//    }
//}
