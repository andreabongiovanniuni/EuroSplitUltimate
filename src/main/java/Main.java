import GUI.LaunchPageGUI;
import basics.Group;
import database.ESdatabase;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Group g = new Group();
        /* HELP  */
        ESdatabase DbEuroSplit = new ESdatabase("eurosplitdatas.sqlite");

        new LaunchPageGUI(g);

    }
}