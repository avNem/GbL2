package Obstacles;

import Participants.Moving;

public class Treadmill implements Obstacles{
    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean makeMoving(Moving moving) {
        if(distance <= moving.run()) {
            System.out.println(moving + " смог пробежать дистанцию " + distance);
            return true;
        }else {
            System.out.println(moving + " не смог пробежать дистанцию " + distance);
            return false;
        }
    }
}
