import java.util.*;

public class HomeWorkApp {
    public static void main(String[] args) {
        String[] words = {"мир", "желтый", "фиолетовый", "red", "yellow", "black",
        "черный", "world", "мир", "желтый"};

        Set<String> unicWords = new HashSet<>();

        Collections.addAll(unicWords, words);
        System.out.println(unicWords);
    }
}
