package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private Object options;
    private String storeId;
    private String customerId;
    private String address;
}


