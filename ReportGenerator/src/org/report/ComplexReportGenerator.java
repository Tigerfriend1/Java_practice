package org.report;

import java.util.List;

//고객의 수: 4 명 입니다
//
//150: 홍길동
//
//350: 우수한
//
//450: 훌륭한
//
//550: 최고의
//
//점수 합계: 1500

public class ComplexReportGenerator extends AbstractReportGenerator {
    @Override
    protected boolean customerReportCondition(Customer customer) {
        if (customer.getPoint()>=100){ //100점 이상만 선택
            return true;
        }
        return false;
    }

    @Override
    protected String getReportHeader(List<Customer> customers) {
        StringBuilder st = new StringBuilder("고객의 수: ");
        st.append(customers.size());
        st.append(" 명 입니다\n");
        return st.toString();
    }

    @Override
    protected String getReportForCustomer(Customer customer) {
        StringBuilder st = new StringBuilder();
        st.append(customer.getPoint());
        st.append(": ");
        st.append(customer.getName());
        st.append("\n");

        return st.toString();
    }

    @Override
    protected String getReportFooter(List<Customer> customers) {
        StringBuilder st = new StringBuilder("점수 합계: ");
        int sum=0;
        for(Customer customer : customers){
            sum+=customer.getPoint();
        }
        st.append(sum);
        return st.toString();
    }
}
