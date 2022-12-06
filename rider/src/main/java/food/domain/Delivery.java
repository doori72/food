package food.domain;

import food.domain.Picked;
import food.domain.Delivered;
import food.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String riderId;

    @PostPersist
    public void onPostPersist(){





    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }



    public void pick(PickCommand pickCommand){
        setRiderId(pickCommand.getRiderId());
        setAddress(pickCommand.getAddress());
        setStatus("배송중");
        Picked picked = new Picked(this);
        picked.publishAfterCommit();

    }
    public void confirmDelivered(ConfirmDeliveredCommand confirmDeliveredCommand){
        setStatus("배송확정");
        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }

    public static void addDelivery(OrderPlaced orderPlaced){

        /** Example 1:  new item  */
        Delivery delivery = new Delivery();
        delivery.setAddress(orderPlaced.getAddress());
        delivery.setCustomerId(orderPlaced.getCustomerId());
        delivery.setFoodId(orderPlaced.getFoodId());
        delivery.setOrderId(String.valueOf(orderPlaced.getId()));
        delivery.setStatus("배송대기");
        repository().save(delivery);

       

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void updateDelivery(CookFinished cookFinished){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process */
        
        repository().findByOrderId(cookFinished.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("배송가능"); // do something
            repository().save(delivery);


         });
        

        
    }


}
