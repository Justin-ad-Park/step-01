package io.cosmos.assign.distribute;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@DistributorStrategy(DistributorType.ROUND_ROBIN)
public class RoundRobinDistributor implements Distributable {
    @Override
    public List<Assign> distribute(List<Customer> customers, List<Surveyor> surveyors) {
        int i = 0;

        List<Assign> assigns = new ArrayList<>();
        for (Customer customer : customers) {
            Surveyor surveyor = surveyors.get(i % surveyors.size());
            Assign newAssign = new Assign(customer, surveyor);
            assigns.add(newAssign);
            i++;
        }

        return assigns;
    }
}
