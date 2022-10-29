package database;

import basics.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class ESdatabase {
    public ESdatabase() throws SQLException {
        DBManager.setConnection(DBManager.JDBC_Driver_SQLite, DBManager.JDBC_URL_SQLite);
        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS User (username VARCHAR(30) PRIMARY KEY )");

        statement.execute("CREATE TABLE IF NOT EXISTS Shop (id VARCHAR(30) PRIMARY KEY , total  DOUBLE, creditor VARCHAR(30) REFERENCES User(username))");
        statement.execute("CREATE TABLE IF NOT EXISTS Debt (creditor VARCHAR(30) REFERENCES User(username), " +
                "debtor VARCHAR(30) REFERENCES User(username), amount DOUBLE  )  PRIMARY KEY (creditor, debtor)");
        statement.execute("CREATE TABLE IF NOT EXISTS Partecipate (debtor VARCHAR(30) REFERENCES User(username)" +
                 "id VARCHAR(30) REFERENCES Shop(id)) PRIMARY KEY (debtor, id)");
    }

    public static void insertShop(Shop shopToAdd) {
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute("INSERT INTO  Shop (id, total, creditor) VALUES (" + shopToAdd.id + ", " + shopToAdd.total + "," + shopToAdd.creditor + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertUser(User userToAdd) throws RuntimeException {
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute("INSERT INTO  User (username) VALUES (" + userToAdd.username + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser(String usernameToDelete) throws RuntimeException {
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute("DELETE FROM  User  WHERE username=" + usernameToDelete + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertDebt(User debtToAdd) {
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Set<String> keys = debtToAdd.debts.keySet();
            for (String key : keys) {
                statement.execute("INSERT INTO  Debt (creditor, amount, debtor) VALUES (" + key + ", " + debtToAdd.debts.get(key) + "," + debtToAdd.username + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertParticipate(Shop shopToAdd){
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            for (int i=0; i<shopToAdd.participants.size();i++) {
                statement.execute("INSERT INTO  Partecipate (debtor, id) VALUES (" + shopToAdd.participants.get(i).getUsername() +
                        ", " + shopToAdd.id + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}