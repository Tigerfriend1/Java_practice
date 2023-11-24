package main.java.myjdbc.spec;

import java.sql.ResultSet;

public class MySQLStatement implements Statement {

    @Override

    public ResultSet executeQuery(String query) {

        // Simulated query execution

        return new MySQLResultSet();

    }

}