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
    @Autowired CustomerRepository customerRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewWritten'")
    public void wheneverReviewWritten_AddCoupon(@Payload ReviewWritten reviewWritten){

        ReviewWritten event = reviewWritten;
        System.out.println("\n\n##### listener AddCoupon : " + reviewWritten + "\n\n");


        

        // Sample Logic //
        Customer.addCoupon(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewDeleted'")
    public void wheneverReviewDeleted_RemoveCoupon(@Payload ReviewDeleted reviewDeleted){

        ReviewDeleted event = reviewDeleted;
        System.out.println("\n\n##### listener RemoveCoupon : " + reviewDeleted + "\n\n");


        

        // Sample Logic //
        Customer.removeCoupon(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AddCustomer(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AddCustomer : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Customer.addCustomer(event);
        

        

    }

}


