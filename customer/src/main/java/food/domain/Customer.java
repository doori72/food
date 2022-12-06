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

        /** Example 2:  finding and process */
        
        repository().findByCustomerId(reviewWritten.getCustomerId()).ifPresent(customer->{
            int couponCnt = customer.getCouponCnt();

            customer.setCouponCnt(couponCnt + 1); // add coupon
            repository().save(customer);


         });
        

        
    }
    public static void removeCoupon(ReviewDeleted reviewDeleted){

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);
        */
        

        /** Example 2:  finding and process */
        
        repository().findByCustomerId(reviewDeleted.getCustomerId()).ifPresent(customer->{
            customer.setCouponCnt(customer.getCouponCnt() - 1); // remove coupon
            repository().save(customer);
         });
        

        
    }
    public static void addCustomer(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        Customer customer = new Customer();
        customer.setCustomerId(orderPlaced.getCustomerId());
        customer.setCouponCnt(1);   // 가입 쿠폰 증정
        repository().save(customer);

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);


         });
        */

        
    }


}
