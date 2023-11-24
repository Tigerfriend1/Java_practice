package main.java.myjdbc.spec;

class MySQLConnection implements Connection {

    public MySQLConnection(String databaseURL, String username, String password) {

        this.databaseURL = databaseURL;

        this.username = username;

        this.password = password;

    }

    // Implement your code

}