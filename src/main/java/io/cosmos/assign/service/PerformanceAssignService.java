package io.cosmos.assign.service;

import io.cosmos.assign.assignrule.Filterable;
import io.cosmos.assign.comparator.AssignSortable;
import io.cosmos.assign.distribute.Distributable;
import io.cosmos.assign.distribute.DistributorStrategy;
import io.cosmos.assign.distribute.DistributorType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * RoundRobinDistributor 를 사용하는 기본 Assign 서비스
 */
@Service
public class PerformanceAssignService extends BaseAssignService {

    /**
     * 스프링용 생성자 (RoundRobinDistributor 주입)
     */
    public PerformanceAssignService(Filterable assignRule,
                                    AssignSortable sorter,
                                    @DistributorStrategy(DistributorType.PERFORMANCE)
                                    Distributable distributable) {
        super(assignRule, sorter, distributable);
    }

}
