package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private List<String> options;
    private String storeId;
    private String customerId;
    private String address;

    public CookFinished(FoodCooking aggregate){
        super(aggregate);
    }
    public CookFinished(){
        super();
    }
}
