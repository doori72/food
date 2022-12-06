package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ReviewWritten extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String content;
}


