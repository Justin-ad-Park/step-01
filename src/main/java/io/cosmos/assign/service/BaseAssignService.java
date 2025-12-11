package io.cosmos.assign.service;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;
import io.cosmos.assign.assignrule.Filterable;
import io.cosmos.assign.comparator.AssignSortable;
import io.cosmos.assign.distribute.Distributable;

import java.util.List;
import java.util.Objects;

/**
 * R02. 템플릿 메서드 역할을 하는 공통 기반 서비스.
 * - 어떤 Distributor 를 쓸지는 하위 클래스가 결정
 * - 로직(필터링, 정렬, 분배)은 여기서 공통 관리
 */
public abstract class BaseAssignService implements AssignServiceUseCase {

    private final Filterable assignRule;
    private final AssignSortable sorter;
    private final Distributable distributable;

    protected BaseAssignService(Filterable assignRule,
                                AssignSortable sorter,
                                Distributable distributable) {
        this.assignRule = Objects.requireNonNull(assignRule);
        this.sorter = Objects.requireNonNull(sorter);
        this.distributable = Objects.requireNonNull(distributable);
    }

    @Override
    public List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors) {
        // 1. 필터링
        List<Customer> filteredCustomer = assignRule.filter(customers);

        // 2. 정렬
        List<Customer> sortedCustomer = sorter.sort(filteredCustomer);

        // 3. 분배
        return distributable.distribute(sortedCustomer, surveyors);
    }

    protected Filterable getAssignRule() {
        return assignRule;
    }

    protected AssignSortable getSorter() {
        return sorter;
    }

    protected Distributable getDistributable() {
        return distributable;
    }
}