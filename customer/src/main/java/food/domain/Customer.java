package food.domain;

import food.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Customer_table")
@Data

public class Customer  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Integer couponCnt;


    public static CustomerRepository repository(){
        CustomerRepository customerRepository = CustomerApplication.applicationContext.getBean(CustomerRepository.class);
        return customerRepository;
    }




    public static void addCoupon(ReviewWritten reviewWritten){

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewWritten.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

        
    }
    public static void removeCoupon(ReviewDeleted reviewDeleted){

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewDeleted.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

        
    }
    public static void addCustomer(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

        
    }


}
