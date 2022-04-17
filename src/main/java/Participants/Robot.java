package Participants;

public class Robot implements Moving{
    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public int jump() {
        return 100;
    }

    @Override
    public int run() {
        return 1000;
    }
}
