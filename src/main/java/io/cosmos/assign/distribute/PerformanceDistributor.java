package io.cosmos.assign.distribute;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DistributorStrategy(DistributorType.PERFORMANCE)
public class PerformanceDistributor implements Distributable {
    @Override
    public List<Assign> distribute(List<Customer> customers, List<Surveyor> surveyors) {
        return List.of();
    }
}
