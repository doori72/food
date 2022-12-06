package food.infra;
import food.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class NoticeHateoasProcessor implements RepresentationModelProcessor<EntityModel<Notice>>  {

    @Override
    public EntityModel<Notice> process(EntityModel<Notice> model) {

        
        return model;
    }
    
}
