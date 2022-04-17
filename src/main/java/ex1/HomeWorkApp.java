package ex1;

import java.util.*;

public class HomeWorkApp {
    public static void main(String[] args) {
        Set<String> unicWords = new HashSet<>();
        Map<String, Integer> finalWords = new HashMap<>();
        String[] words = {"мир", "желтый", "фиолетовый", "red", "yellow", "black",
                "черный", "world", "мир", "желтый"};

        Collections.addAll(unicWords, words);
        System.out.println("список уникальных слов " + unicWords);

        for (int i = 0; i < words.length; i++) {
            if(!finalWords.containsKey(words[i])) {
                finalWords.put(words[i], 1);
            } else {
                finalWords.put(words[i], finalWords.get(words[i]) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : finalWords.entrySet()) {
            System.out.println(entry.getKey() + " повторяется " + entry.getValue() + " раз");
        }






    }
}
