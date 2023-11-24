package com.cafe.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order> {
    List<Order> orders = new ArrayList<>();
    private int index=0;

    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public boolean hasNext() {
        if (index<orders.size()) return true;
        return false;
    }

    @Override
    public Order next() {
        return orders.get(index++);
    }
//    @Override
//    public void remove(){
//        orders.remove()
//    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("\n--- 주문 관리자 화면 ---\n" +
                "현재 주문수는 총 ").append(Order.getOrderCounter()).append("입니다.\n\n");
        st.append("< 주문 내역 >\n");
        for (int i=orders.size()-Order.getOrderCounter(); i< orders.size();i++){
            st.append(orders.get(i));
        }
        return st.toString();
    }
}