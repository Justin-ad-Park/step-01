package io.cosmos.assign.factory;

import io.cosmos.assign.service.AssignServiceUseCase;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


/**
 * BaseAssignService의 구현체를 Enum 기반으로 선택해주는 팩토리
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