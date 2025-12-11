package io.cosmos.assign.factory;

import io.cosmos.assign.service.AssignServiceUseCase;
import io.cosmos.assign.service.PerformanceAssignService;
import io.cosmos.assign.service.RoundRobinAssignService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * AssignService / AssignPerformanceService 를 Enum 기반으로 선택해주는 팩토리
 */
@Component
public class AssignServiceFactory {

    private final Map<AssignServiceType, AssignServiceUseCase> services;

    public AssignServiceFactory(RoundRobinAssignService roundRobinAssignService,
                                PerformanceAssignService performanceAssignService) {

        Map<AssignServiceType, AssignServiceUseCase> map =
                new EnumMap<>(AssignServiceType.class);

        map.put(AssignServiceType.ROUND_ROBIN, roundRobinAssignService);
        map.put(AssignServiceType.PERFORMANCE, performanceAssignService);

        this.services = Map.copyOf(map); // 불변 Map
    }

    public AssignServiceUseCase getService(AssignServiceType type) {
        AssignServiceUseCase service = services.get(type);
        if (service == null) {
            throw new IllegalArgumentException("지원하지 않는 AssignServiceType: " + type);
        }
        return service;
    }
}