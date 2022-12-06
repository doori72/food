package food.infra;
import food.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CustomerHateoasProcessor implements RepresentationModelProcessor<EntityModel<Customer>>  {

    @Override
    public EntityModel<Customer> process(EntityModel<Customer> model) {

        
        return model;
    }
    
}
