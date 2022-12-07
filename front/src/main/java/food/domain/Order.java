package food.domain;

import food.domain.OrderPlaced;
import food.domain.OrderCanceled;
import food.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodId;
    
    
    
    @ElementCollection
    
    private List<String> options;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String storeId;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){
        // Get request from FoodCooking
        //food.external.FoodCooking foodCooking =
        //    Application.applicationContext.getBean(food.external.FoodCookingService.class)
        //    .getFoodCooking(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public void review(){
        //
    }





}
