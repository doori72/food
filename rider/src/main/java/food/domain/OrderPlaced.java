package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private Object options;
    private String address;
    private String customerId;
    private String storeId;
}


