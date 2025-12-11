package io.cosmos.assign;

import io.cosmos.assign.service.RoundRobinAssignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static io.cosmos.assign.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AssignServiceRoundRobinTest {

    @Autowired
    private RoundRobinAssignService assignService;

    @Test
    void assign_with_roundRobin() {
        List<Customer> customers = getCustomers();
        List<Surveyor> surveyors = getSurveyors();

        printCustomers(customers);

        List<Assign> filteredAssign = assignService.assign(customers, surveyors);

        printFilteredAssign(filteredAssign);

        assertEquals("S2", filteredAssign.get(1).getSurveyor().getId());
    }
}
