package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Delivered extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
    private String address;
    private String customerId;
    private String foodId;

    public Delivered(Delivery aggregate){
        super(aggregate);
    }
    public Delivered(){
        super();
    }
}
