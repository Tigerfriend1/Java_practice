package edu.pnu.myjdbc.impl.mysql;

class MySQLConnection implements Connection {

    public MySQLConnection(String databaseURL, String username, String password) {

        this.databaseURL = databaseURL;

        this.username = username;

        this.password = password;

    }

    // Implement your code

}