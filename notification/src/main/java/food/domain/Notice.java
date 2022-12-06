package food.domain;

import food.NotificationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notice_table")
@Data

public class Notice  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String message;


    public static NoticeRepository repository(){
        NoticeRepository noticeRepository = NotificationApplication.applicationContext.getBean(NoticeRepository.class);
        return noticeRepository;
    }




    public static void notifyKakao(OrderAccepted orderAccepted){

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

        
    }
    public static void notifyKakao(OrderRejected orderRejected){

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

        
    }
    public static void notifyKakao(CookStarted cookStarted){

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

        
    }
    public static void notifyKakao(CookFinished cookFinished){

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

        
    }
    public static void notifyKakao(Picked picked){

        /** Example 1:  new item 
        Notice notice = new Notice();
        repository().save(notice);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(notice->{
            
            notice // do something
            repository().save(notice);


         });
        */

        
    }


}
