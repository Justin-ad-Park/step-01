package io.cosmos.assign;

import io.cosmos.assign.assignrule.Filterable;
import io.cosmos.assign.comparator.AssignSortable;
import io.cosmos.assign.distribute.Distributable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public class AssignService {
    @Autowired
    private final Filterable assignRule;

    @Autowired
    private final AssignSortable sorter;

    @Autowired
    @Qualifier("roundRobinDistributor")
    private final Distributable distributable;

    public AssignService(Filterable assignRule
            , AssignSortable comparator
            , @Qualifier("roundRobinDistributor")Distributable distributable) {
        this.assignRule = assignRule;
        this.sorter = comparator;
        this.distributable = distributable;
    }


    /*
        1. 30세 이상인 고객을 추출하고,
        2. 나이를 오름차순으로 정렬한 후,
        3. 설문 조사원에게 순차적으로 배정(분배)한다.

     */
    public List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors) {
        List<Customer> filteredCustomer = assignRule.filter(customers);

        // 2. 나이를 오름차순으로 정렬
        filteredCustomer = this.sorter.sort(filteredCustomer);

        // 3. 설문 조사원을 순차적으로 배정
        return distributable.distribute(filteredCustomer, surveyors);

    }
}
