package food.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="DeliveryList_table")
@Data
public class DeliveryList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String address;
        private String foodId;
        private String customerId;


}
