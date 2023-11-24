package edu.pnu.myjdbc.impl.mysql;


import edu.pnu.myjdbc.spec.ResultSet;

import java.util.HashMap;
import java.util.Map;

public class MySQLResultSet implements ResultSet {

    private final Map<String, Object>[] data = new Map[] {

            new HashMap<String, Object>() {{

                put("id", 1);

                put("age", 25);

                put("first", "Edward");

                put("last", "Kim");

            }},

    };
    private int currentCount=-1;

    @Override
    public boolean next() {
        if(currentCount >= data.length-1) return false;
        currentCount++;
        return true;
    }

    @Override
    public int getInt(String columnLabel) {
        try{
            return (int) data[currentCount].get(columnLabel);
        }catch (Exception e){
            System.out.println("int로 변환할 수 없는 값입니다.");
            return 0;
        }

    }

    @Override
    public String getString(String columnLabel) {

        return (String) data[currentCount].get(columnLabel);
    }

}