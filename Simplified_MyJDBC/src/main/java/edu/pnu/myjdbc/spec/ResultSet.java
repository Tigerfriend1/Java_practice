package edu.pnu.myjdbc.spec;


// ResultSet.java

import java.util.ServiceLoader;

public interface ResultSet {

    boolean next();

    int getInt(String columnLabel);

    String getString(String columnLabel);

}

