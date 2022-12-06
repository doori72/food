package food.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NoticeRepository noticeRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAccepted'")
    public void wheneverOrderAccepted_NotifyKakao(@Payload OrderAccepted orderAccepted){

        OrderAccepted event = orderAccepted;
        System.out.println("\n\n##### listener NotifyKakao : " + orderAccepted + "\n\n");


        

        // Sample Logic //
        Notice.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_NotifyKakao(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener NotifyKakao : " + orderRejected + "\n\n");


        

        // Sample Logic //
        Notice.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_NotifyKakao(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener NotifyKakao : " + cookStarted + "\n\n");


        

        // Sample Logic //
        Notice.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookFinished'")
    public void wheneverCookFinished_NotifyKakao(@Payload CookFinished cookFinished){

        CookFinished event = cookFinished;
        System.out.println("\n\n##### listener NotifyKakao : " + cookFinished + "\n\n");


        

        // Sample Logic //
        Notice.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_NotifyKakao(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener NotifyKakao : " + picked + "\n\n");


        

        // Sample Logic //
        Notice.notifyKakao(event);
        

        

    }

}


