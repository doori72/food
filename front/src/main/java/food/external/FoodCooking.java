package food.external;

import lombok.Data;
import java.util.Date;
@Data
public class FoodCooking {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private Object options;
    private String storeId;
    private String customerId;
    private String address;
}


