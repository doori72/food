package food.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Data
public class PickCommand {

        private String orderId;
        private String riderId;
        private String address;


}
