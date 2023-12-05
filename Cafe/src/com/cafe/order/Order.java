package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    private static int orderCounter = 0;
    private int orderNo ;

    private Order.PickUp pickUp;

    public Order() {
        orderCounter++;
        orderNo=orderCounter;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void completed() {
        orderCounter--;
        pickUp.handle(this);


    }

    public void setPickUp(PickUp pickUp) {
        this.pickUp=pickUp;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public static interface PickUp {
        public abstract void handle(Order o);
    }

    //주문번호: 1 - [name=MangoBanana, Price=6300, size=GRANDE, quantity=1, name=Americano, Price=4100, size=TALL, quantity=1]
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("주문번호: ");
        st.append(orderNo).append(" - [");
        for(OrderItem item : items){
            st.append(item).append(", ");
        }
        st.delete(st.length()-2,st.length());
        //st.deleteCharAt(st.length()-2); // "," 제거
        st.append("]\n");
        return st.toString();
    }
}