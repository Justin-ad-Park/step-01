package io.cosmos.assign.assignrule;

import io.cosmos.assign.Customer;
import org.springframework.stereotype.Component;

@Component
public class AgeFilter implements Filterable {
    private int minAge;
    private int maxAge;

    public AgeFilter() {
        this.minAge = 30;
        this.maxAge = 100;
    }

    @Override
    public boolean isSatisfied(Customer customer) {
        if(this.minAge <= customer.getAge()
        && customer.getAge() <= this.maxAge) {
            return true;
        }

        return false;
    }
}
