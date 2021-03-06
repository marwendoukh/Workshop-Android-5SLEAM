package tn.sleam.five.marwen.a5sleam.recyclerview.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tn.sleam.five.marwen.a5sleam.recyclerview.entity.User;


/**
 * Created by wael on 02/10/2017.
 */

public class DataSource {

    private static HashMap<String, List<User>> usersInCountries = new HashMap<>();

    public static void setUsersInCountries() {
        List<User> users = new ArrayList<>();

        users.add(new User("Wael Mallek", "Bizerte"));
        users.add(new User("Imed Amri", "Sidi Bouzid"));
        users.add(new User("Nader Rahamn", "Sousse"));
        users.add(new User("Houssem Lassoued", "Rafraf"));
        usersInCountries.put("Tunisia", users);

        List<User> users2 = new ArrayList<>();
        users2.add(new User("Parfait Desrosiers", "Paris"));
        users2.add(new User("Benjamin Dupéré", "Croix"));
        users2.add(new User("Juliette Labossière", "Le Port"));
        usersInCountries.put("France", users2);

        List<User> users3 = new ArrayList<>();
        users3.add(new User("Angela J. Schaefer", "Florida"));
        users3.add(new User("Joel M. Brown", "LA"));
        usersInCountries.put("USA", users3);
    }

    public static List<User> getUsersByCountry(String country) {
        // check if the list is empty
        if (usersInCountries.size() == 0)
            setUsersInCountries();
        return usersInCountries.get(country);
    }

    public static boolean checkCountryExists(String country) {
        return usersInCountries.containsKey(country);
    }

    // add user
    public static void addUser(User user, String country) {
        System.out.println(user.getName());
        List<User> users = new ArrayList<>();
        users.addAll(getUsersByCountry(country));
        System.out.println(users.size());
        users.add(user);
        System.out.println(users.size());
        usersInCountries.put(country, users);
        System.out.println(usersInCountries.values());
    }

}
