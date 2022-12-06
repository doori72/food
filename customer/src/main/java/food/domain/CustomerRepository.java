package food.domain;

import food.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="customers", path="customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{

    Optional<Customer> findByCustomerId(String customerId);

}
