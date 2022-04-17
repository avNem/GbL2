package ex2;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final static Map<Integer, String> phoneBook = new HashMap<>();


    static void add(int phoneNumber, String surname) {
        phoneBook.put(phoneNumber, surname);
    }

    static void get(String surname) {
        for (Map.Entry<Integer, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(surname)) {
                System.out.println(entry.getKey());
            }
        }
    }
}