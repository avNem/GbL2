package Participants;

public class Cat implements Moving{
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public int jump() {
        return 1;
    }

    @Override
    public int run() {
        return 20;
    }
}
