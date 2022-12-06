package food.domain;

import food.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Picked extends AbstractEvent {

    private Long id;
    private String status;
    private String orderId;
    private String address;
    private String customerId;
    private String foodId;
    private String riderId;
}
