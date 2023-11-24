package edu.pnu.myjdbc.spec;

// Connection.java

import java.util.ServiceLoader;

public interface Connection {

    Statement createStatement();

}
