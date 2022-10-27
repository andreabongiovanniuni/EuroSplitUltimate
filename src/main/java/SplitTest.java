import basics.User;

import java.util.ArrayList;
import java.util.List;

public class SplitTest {

    public static void main(String[] args) {
       User u1 = new User("Rick");
        User u2 = new User("Gigi");
        User u3 = new User("Noob");
        User u4 = new User("Lele");
        User u5 = new User("Ali");
     ArrayList<User> users = new ArrayList<>(List.of(u1, u2, u3, u4, u5));
        /**
        List<UserBis> sb1 = new ArrayList<>(List.of(u1, u5));
        List<UserBis> sb2 = new ArrayList<>(List.of(u1));
        List<UserBis> sb3 = new ArrayList<>(List.of(u1, u3));
        List<UserBis> sb4 = new ArrayList<>(List.of(u1, u3, u4));
        ShopBis sh = new ShopBis(13.52, u1, users);
        // EqualSplit test
        sh.EqualSplit();
        System.out.println(u2);
        ShopBis sh1 = new ShopBis(14.21, u1, users);
        sh1.EqualSplit();
        System.out.println(u2);
        ShopBis sh2 = new ShopBis(21.6, u2, users);
        sh2.EqualSplit();
        System.out.println(u2);
        ShopBis sh3 = new ShopBis(9.61, u3, users);
        sh3.EqualSplit();
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        // NotEqualSplit test
        HashMap<UserBis, Double> mp1 = new HashMap<>(Map.of(u1, 2.0, u2, 1., u3, 0.50, u4, 1.50, u5, 5.));
        sh.NotEqualSplit(mp1);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        */
       /* //Special Product
        double[] a = {2.86, 1.66, 1.22, 1.91, 2.95, 3.5, 2.43, 2.60, 2.79, 1.28, 0.48, 0.96, 1.33};
     ArrayList<basics.User> sb1 = new ArrayList<>(List.of(u1, u5));
     ArrayList<basics.User> sb2 = new ArrayList<>(List.of(u1));
     ArrayList<basics.User> sb3 = new ArrayList<>(List.of(u1, u3));
     ArrayList<basics.User> sb4 = new ArrayList<>(List.of(u1));
     ArrayList<basics.User> sb5 = new ArrayList<>(List.of(u1, u4));
     ArrayList<basics.User> sb6 = new ArrayList<>(List.of(u2, u3, u5));
     ArrayList<basics.User> sb7 = new ArrayList<>(List.of(u1, u5));
     ArrayList<basics.User> sb8 = new ArrayList<>(List.of(u1, u3, u4, u5));
     ArrayList<basics.User> sb9 = new ArrayList<>(List.of(u1, u2, u4, u5));
     ArrayList<basics.User> sb10 = new ArrayList<>(List.of(u1, u3, u5, u4));
     ArrayList<basics.User> sb11 = new ArrayList<>(List.of(u1));
     ArrayList<basics.User> sb12 = new ArrayList<>(List.of(u2, u4, u5));
     ArrayList<basics.User> sb13 = new ArrayList<>(List.of(u1, u2, u4));
        basics.Shop sh = new basics.Shop(32.61, u1, users);



        LinkedHashMap<Integer, List<basics.User>> mp2 = new LinkedHashMap<>();

        mp2.put(1, sb1);
        mp2.put(2, sb2);
        mp2.put(3, sb3);
        mp2.put(4, sb4);
        mp2.put(5, sb5);
        mp2.put(6, sb6);
        mp2.put(7, sb7);
        mp2.put(8, sb8);
        mp2.put(9, sb9);
        mp2.put(10, sb10);
        mp2.put(11, sb11);
        mp2.put(12, sb12);
        mp2.put(13, sb13);


        sh.SpecialSplit(a, mp2);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        System.out.println(sh);*/
    }

}
