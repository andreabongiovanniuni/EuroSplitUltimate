package database;

import basics.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static database.DBManager.connection;

public class ESdatabase {
    public ESdatabase() throws SQLException {
        DBManager.setConnection(DBManager.JDBC_Driver_SQLite, DBManager.JDBC_URL_SQLite);
        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS User (username VARCHAR(30) PRIMARY KEY )");
        statement.execute("CREATE TABLE IF NOT EXISTS Shop (id VARCHAR(30) PRIMARY KEY , total  DOUBLE, creditor VARCHAR(30) REFERENCES User(username))");
        statement.execute("CREATE TABLE IF NOT EXISTS Debt (creditor VARCHAR(30) REFERENCES User(username), " + "debtor VARCHAR(30) REFERENCES User(username), amount DOUBLE  ,  PRIMARY KEY(creditor, debtor))");
        statement.execute("CREATE TABLE IF NOT EXISTS Partecipate (debtor VARCHAR(30) REFERENCES User(username), " + "id VARCHAR(30) REFERENCES Shop(id), PRIMARY KEY(debtor, id))");
    }

    public static void insertShop(Shop shopToAdd) {
        String sql = "INSERT INTO Shop(id, total, creditor) VALUES(?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, shopToAdd.id);
            pstmt.setString(2, String.valueOf(shopToAdd.total));
            pstmt.setString(3, shopToAdd.username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertUser(User userToAdd) throws RuntimeException {
        String sql = "INSERT INTO User(username) VALUES(?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, userToAdd.username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        /*Connection connection = null;
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
        }*/
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
        Set<String> keys = debtToAdd.debts.keySet();
        for (String key : keys) {
            String sql = "INSERT INTO Debt(creditor, debtor, amount) VALUES(?,?,?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, key);
                pstmt.setString(2, debtToAdd.username);
                pstmt.setString(3, String.valueOf(debtToAdd.debts.get(key)));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void insertParticipate(Shop shopToAdd) {
        String sql = "INSERT INTO Participate(debtor, id) VALUES(?,?)";
        for (int i = 0; i < shopToAdd.participants.size(); i++) {
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, shopToAdd.participants.get(i).getUsername());
                pstmt.setString(2, shopToAdd.id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}