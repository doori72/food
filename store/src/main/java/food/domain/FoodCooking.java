package food.domain;

import food.domain.OrderAccepted;
import food.domain.OrderRejected;
import food.domain.CookStarted;
import food.domain.CookFinished;
import food.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="FoodCooking_table")
@Data

public class FoodCooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String orderId;
    
    
    
    @ElementCollection
    
    private List<String> options;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){












    }

    public static FoodCookingRepository repository(){
        FoodCookingRepository foodCookingRepository = StoreApplication.applicationContext.getBean(FoodCookingRepository.class);
        return foodCookingRepository;
    }



    public void accept(AcceptCommand acceptCommand){
        setStatus("접수됨");
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
        
    }
    public void reject(RejectCommand rejectCommand){
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        setStatus("거부됨");
    }
    public void start(StartCommand startCommand){
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
        setStatus("요리시작");
    }
    public void finish(FinishCommand finishCommand){
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
        setStatus("요리완료");
    }

    public static void addOrder(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        FoodCooking foodCooking = new FoodCooking();
        foodCooking.setAddress(orderPlaced.getAddress());
        foodCooking.setCustomerId(orderPlaced.getCustomerId());
        foodCooking.setFoodId(orderPlaced.getFoodId());
        foodCooking.setOrderId(String.valueOf(orderPlaced.getId()));
        foodCooking.setStatus("미결재");
        foodCooking.setStoreId(orderPlaced.getStoreId());
        repository().save(foodCooking);

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(foodCooking->{
            
            foodCooking // do something
            repository().save(foodCooking);


         });
        */

        
    }
    public static void updateOrder(Paid paid){

        /** Example 1:  new item 
        FoodCooking foodCooking = new FoodCooking();
        repository().save(foodCooking);

        */

        /** Example 2:  finding and process */
        
        repository().findByOrderId(paid.getOrderId()).ifPresent(foodCooking->{
            foodCooking.setStatus("결재완료"); // do something
            System.out.println(">>>> foodCooking.getStatus() : " + foodCooking.getStatus());
            repository().save(foodCooking);
         });
        

        
    }


}
