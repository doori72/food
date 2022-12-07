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
        if (status.equals("요리시작") || status.equals("요리완료")) {
            System.out.println(">>>> 요리가 시작되기 전에만 주문취소가 가능합니다.");
            return;
        }
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public void review(){
        //
    }



    public static void updateStatus(CookFinished cookFinished){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process */
        
        repository().findById(Long.valueOf(cookFinished.getOrderId())).ifPresent(order->{
            
            order.setStatus(cookFinished.getStatus()); // 요리 상태 업데이트
            repository().save(order);


         });
        

        
    }


}
