package DatabaseNew;
import LearnDatabase.DBManager;

import basics.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ESdatabase {

    public ESdatabase() throws SQLException {
        DBManager.setConnection(DBManager.JDBC_Driver_SQLite,DBManager.JDBC_URL_SQLite);
        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();
        statement.execute( "CREATE TABLE IF NOT EXISTS User (username VARCHAR(30) PRIMARY KEY )");
        statement.execute("CREATE TABLE IF NOT EXISTS Debt (debtor VARCHAR(30) PRIMARY KEY REFERENCES User(username), creditor VARCHAR(30) " +
                "REFERENCES User(username), amount DOUBLE) REFERENCES");
        statement.execute("CREATE TABLE IF NOT EXISTS Shop (id VARCHAR(30) PRIMARY KEY , total DOUBLE, creditor " +
                "VARCHAR(30) REFERENCES User(username))");

        /**basics.User { username }
         Debt { debtor, creditor, amount }
         FK: creditor REFERENCES basics.User(username)

         basics.Shop { id, total, creditor }
         FK: creditor REFERENCES basics.User(username)
         **/
    }
    public void saveDebt (Shop shoptoAdd){
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
            statement.execute("INSERT INTO  Debt (debtor, creditor, amount) VALUES (" +  shoptoAdd.getParticipants() + ", "+ shoptoAdd.creditor+","+ shoptoAdd. + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveShop (Shop shoptoAdd){
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
            statement.execute("INSERT INTO  Shop (id, total, creditor) VALUES (" +  shoptoAdd.id + ", "+ shoptoAdd.total+","+ shoptoAdd.creditor + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveUser (User UsertoAdd){
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
            statement.execute("INSERT INTO  User (username) VALUES (" +  UsertoAdd.username + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
