package main.java.myjdbc.spec;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

class MySQLResultSet implements ResultSet {

    private final Map<String, Object>[] data = new Map[] {

            new HashMap<String, Object>() {{

                put("id", 1);

                put("age", 25);

                put("first", "Edward");

                put("last", "Kim");

            }},

    };

    // Implement your code

}