package Obstacles;

import Participants.Moving;

public class Wall implements Obstacles{
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean makeMoving(Moving moving) {
        if(height <= moving.jump()) {
            System.out.println(moving + " смог перепрыгнуть высоту " + height);
            return true;
        }else {
            System.out.println(moving + " не смог перепрыгнуть высоту " + height);
            return false;
        }
    }
}
