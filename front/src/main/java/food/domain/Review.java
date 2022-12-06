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

    @PostPersist
    public void onPostPersist(){


        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();



        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();

        // Get request from Order
        //food.external.Order order =
        //    Application.applicationContext.getBean(food.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);

    }
    @PreRemove
    public void onPreRemove(){
    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = FrontApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}
