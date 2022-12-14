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
    @Autowired FoodCookingRepository foodCookingRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AddOrder(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AddOrder : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        FoodCooking.addOrder(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_UpdateOrder(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener UpdateOrder : " + paid + "\n\n");


        

        // Sample Logic //
        FoodCooking.updateOrder(event);
        

        

    }

}


