package edu.pnu.myjdbc.spec;

// Statement.java

import java.util.ServiceLoader;

public interface Statement {

    ResultSet executeQuery(String query);

}

