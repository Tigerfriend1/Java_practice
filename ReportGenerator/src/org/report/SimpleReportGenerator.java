package org.report;

import java.util.List;

//고객의 수: 5 명
//
//홍길동: 150
//
//우수한: 350
//
//부족한: 50
//
//훌륭한: 450
//
//최고의: 550
public class SimpleReportGenerator extends AbstractReportGenerator {
    @Override
    protected boolean customerReportCondition(Customer customer) {
        return true;
    }

    @Override
    protected String getReportHeader(List<Customer> customers) {
        StringBuilder st = new StringBuilder("고객의 수: ");
        st.append(customers.size());
        st.append(" 명\n");
        return st.toString();
    }

    @Override
    protected String getReportForCustomer(Customer customer) {
        StringBuilder st = new StringBuilder();
        st.append(customer.getName());
        st.append(": ");
        st.append(customer.getPoint());
        st.append("\n");

        return st.toString();
    }


    @Override
    protected String getReportFooter(List<Customer> customers) {
        return "\n";
    }
}
