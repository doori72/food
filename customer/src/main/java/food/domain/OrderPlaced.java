package food.domain;

import food.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private List<String> options;
    private String address;
    private String customerId;
    private String storeId;
}
