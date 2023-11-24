package edu.pnu.myjdbc.spec;

// Driver.java

import java.util.ServiceLoader;

public interface Driver {

    boolean acceptsURL(String url);

    Connection connect(String url, String user, String password);

}

