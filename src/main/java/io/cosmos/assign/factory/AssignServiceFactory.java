package io.cosmos.assign.factory;

import io.cosmos.assign.service.AssignServiceUseCase;
import io.cosmos.assign.service.PerformanceAssignService;
import io.cosmos.assign.service.RoundRobinAssignService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * AssignService / AssignPerformanceService 를 Enum 기반으로 선택해주는 팩토리
 */
@Component
public class AssignServiceFactory {

    private final ApplicationContext context;

    public AssignServiceFactory(ApplicationContext context) {
        this.context = context;
    }

    public AssignServiceUseCase getService(AssignServiceType type) {
        return context.getBean(type.getBeanName(), AssignServiceUseCase.class);
    }
}