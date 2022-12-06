package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CancelPaid extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;

    public CancelPaid(Payment aggregate){
        super(aggregate);
    }
    public CancelPaid(){
        super();
    }
}
