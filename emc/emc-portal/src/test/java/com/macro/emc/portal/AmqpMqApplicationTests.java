package com.macro.emc.portal;//package com.macro.emc.portal;
//
//
//import com.macro.emc.portal.component.KafkaProducer;
//import com.macro.emc.portal.component.SpringBootProducer;
//import com.macro.emc.portal.domain.QueueEnum;
//import org.junit.jupiter.api.Test;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessagePostProcessor;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
//@SpringBootTest
//public class AmqpMqApplicationTests {
//
//
//    @Resource
//    private AmqpTemplate amqpTemplate;
//    @Resource
//    private SpringBootProducer producer;
//
//    @Resource
//    private KafkaProducer kafkaProducer;
//
//
//    /*
//     * 并发金额操作，使用消息队列排队
//     * */
//    @Test
//    public void rabbitmq() {
//        //给延迟队列发送消息
//        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), 1, new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                //给消息设置延迟毫秒值
//                message.getMessageProperties().setDelay(0);
//                return message;
//            }
//        });
//    }
//
//
//    @Test
//    public void rocketMq() {
//        producer.sendMessage("topic", "message");
//    }
//
//    @Test
//    public void kafka() {
//        kafkaProducer.sendMessage();
//    }
//
//
//}
