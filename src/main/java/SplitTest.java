import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitTest {

    public static void main(String[] args) {
        User u1 = new User("Rick");
        User u2 = new User("Gigi");
        User u3 = new User("Noob");
        User u4 = new User("Lele");
        User u5 = new User("Ali");
        List<User> users = new ArrayList<>(List.of(u1, u2, u3, u4, u5));
        List<User> sb1 = new ArrayList<>(List.of(u1, u5));
        List<User> sb2 = new ArrayList<>(List.of(u1));
        List<User> sb3 = new ArrayList<>(List.of(u1, u3));
        List<User> sb4 = new ArrayList<>(List.of(u1, u3, u4));
        Shop sh = new Shop(13.52, u1, users);
        // EqualSplit test
        sh.EqualSplit();
        System.out.println(u2);
        Shop sh1 = new Shop(14.21, u1, users);
        sh1.EqualSplit();
        System.out.println(u2);
        Shop sh2 = new Shop(21.6, u2, users);
        sh2.EqualSplit();
        System.out.println(u2);
        Shop sh3 = new Shop(9.61, u3, users);
        sh3.EqualSplit();
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        // NotEqualSplit test
        HashMap<User, Double> mp1 = new HashMap<>(Map.of(u1, 2.0, u2, 1., u3, 0.50, u4, 1.50, u5, 5.));
        sh.NotEqualSplit(mp1);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        //Special Product
        double[] a = {2.86, 1.66, 1.22, 2.95};
        HashMap<Integer, List<User>> mp2 = new HashMap<>(Map.of(1, sb1, 2, sb2, 3, sb3, 4, sb4));
        sh.SpecialSplit(a, mp2);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        System.out.println(sh);
    }

}
