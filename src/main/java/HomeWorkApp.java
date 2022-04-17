import Obstacles.Obstacles;
import Obstacles.Treadmill;
import Obstacles.Wall;
import Participants.Cat;
import Participants.Human;
import Participants.Moving;
import Participants.Robot;

public class HomeWorkApp {
    public static void main(String[] args) {
        Human human = new Human("Vasya");
        Cat cat = new Cat("Myrzik");
        Robot robot = new Robot("Android");

        Treadmill treadmill = new Treadmill(150);
        Wall wall = new Wall(2);

        Moving[] movers = {human, cat, robot};
        Obstacles[] obstacles = {treadmill, wall};

        for (Moving mover : movers) {
            for (Obstacles obstacle : obstacles) {
                obstacle.makeMoving(mover);
            }
        }


    }
}
