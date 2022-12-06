package food.domain;

import food.domain.ReviewWritten;
import food.domain.ReviewDeleted;
import food.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Review_table")
@Data

public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String content;

   

    @PrePersist
    public void onPrePersist() {
        // req/res 형식으로 오더정보조회 후 해당 오더의 고객ID 설정
        food.external.Order order =
           FrontApplication.applicationContext.getBean(food.external.OrderService.class)
           .getOrder(Long.valueOf(getOrderId()));
        
        setCustomerId(order.getCustomerId());

        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();
    }

    @PostPersist
    public void onPostPersist(){
    }

    @PreRemove
    public void onPreRemove() {
        // req/res 형식으로 오더정보조회 후 해당 오더의 고객ID 설정
        food.external.Order order =
           FrontApplication.applicationContext.getBean(food.external.OrderService.class)
           .getOrder(Long.valueOf(getOrderId()));
        
        setCustomerId(order.getCustomerId());

        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {

    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = FrontApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}
