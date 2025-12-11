package io.cosmos.assign.factory;

public enum AssignServiceType {

    ROUND_ROBIN("roundRobinAssignService"),
    PERFORMANCE("performanceAssignService");

    private final String beanName;

    AssignServiceType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}