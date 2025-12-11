package io.cosmos.assign.factory;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.cosmos.assign.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacadeTest {

    @Autowired
    AssignFacade assignFacade;

    @Test
    void performance_assign_테스트() {
        List<Customer> customers = getCustomers();
        List<Surveyor> surveyors = getSurveyors();

        printCustomers(customers);

        List<Assign> filteredAssign  = assignFacade.assign(AssignServiceType.ROUND_ROBIN, customers, surveyors);

        printFilteredAssign(filteredAssign);

        assertEquals("S2", filteredAssign.get(1).getSurveyor().getId());
    }
}
