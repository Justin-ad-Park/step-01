package io.cosmos.assign.factory;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignFacade {

    private final AssignServiceFactory assignServiceFactory;

    public AssignFacade(AssignServiceFactory assignServiceFactory) {
        this.assignServiceFactory = assignServiceFactory;
    }

    public List<Assign> assign(AssignServiceType type,
                               List<Customer> customers,
                               List<Surveyor> surveyors) {
        return assignServiceFactory
                .getService(type)
                .assign(customers, surveyors);
    }
}