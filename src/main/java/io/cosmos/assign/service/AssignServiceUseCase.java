package io.cosmos.assign.service;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;

import java.util.List;

/**
 * R01. 공통 인터페이스 도입 (DIP, ISP)
 */
public interface AssignServiceUseCase {
    List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors);
}
