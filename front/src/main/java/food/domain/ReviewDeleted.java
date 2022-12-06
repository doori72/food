package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReviewDeleted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String content;

    public ReviewDeleted(Review aggregate){
        super(aggregate);
    }
    public ReviewDeleted(){
        super();
    }
}
