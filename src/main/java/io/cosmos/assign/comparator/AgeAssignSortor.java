package io.cosmos.assign.comparator;

import io.cosmos.assign.Customer;
import org.springframework.stereotype.Component;

@Component
public class AgeAssignSortor implements AssignSortable {
    @Override
    public int compare(Customer before, Customer after) {
        return before.getAge() - after.getAge();
    }
}
