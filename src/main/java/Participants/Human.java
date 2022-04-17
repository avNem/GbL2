package Participants;

public class Human implements Moving{
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public int jump() {
        return 2;
    }

    @Override
    public int run() {
        return 100;
    }
}
