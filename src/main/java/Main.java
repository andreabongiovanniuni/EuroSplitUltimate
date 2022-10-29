import GUI.LaunchPageGUI;
import basics.Group;
import database.ESdatabase;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Group g = new Group();
        /* HELP  */
        try {
            ESdatabase DbEuroSplit = new ESdatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new LaunchPageGUI(g);

    }
}