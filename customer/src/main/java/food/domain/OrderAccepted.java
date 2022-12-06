package food.domain;

import food.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String orderId;
    private List<String> options;
    private String storeId;
    private String customerId;
    private String address;
}
