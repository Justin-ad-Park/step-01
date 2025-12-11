package io.cosmos.assign;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static List<Surveyor> getSurveyors() {
        Surveyor surveyor1 = new Surveyor("S1", "조사원#1");
        Surveyor surveyor2 = new Surveyor("S2", "조사원#2");

        List<Surveyor> surveyors = new ArrayList<>();
        surveyors.add(surveyor1);
        surveyors.add(surveyor2);
        return surveyors;
    }

    public static List<Customer> getCustomers() {
        Customer customer1 = new Customer("C1", "고객#1", "19911001", "W", "", "");
        Customer customer2 = new Customer("C2", "고객#2", "19901001", "M", "", "");
        Customer customer3 = new Customer("C3", "고객#3", "19891001", "M", "", "");
        Customer customer4 = new Customer("C4", "고객#4", "19971001", "W", "", "");
        Customer customer5 = new Customer("C5", "고객#5", "19921001", "M", "", "");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        return customers;
    }

    // 아래 헬퍼 메서드들은 기존 테스트 클래스에서 그대로 가져오면 됨
    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer.getName() + "(" + customer.getAge() + ")");
        }
        System.out.println();
    }

    public static void printFilteredAssign(List<Assign> filteredAssign) {
        for (Assign assign : filteredAssign) {
            System.out.println(
                    assign.getCustomer().getName() + "(" +
                            assign.getCustomer().getAge() + "): " +
                            assign.getSurveyor().getId()
            );
        }
    }
}
