public class EnemyAttacker{
    public static void main(String[] args){
        EnemyTank r506 = new EnemyTank();
        enemyrobot robo = new enemyrobot();
        enemyattacker adapter = new EnemyRobotAdapter(robo);

        adapter.assigndriver();
        adapter.driveforward();
        adapter.fireweapon();
    }
}
interface enemyattacker{
    public void fireweapon();
    public void driveforward();
    public void assigndriver();
}
class EnemyTank implements enemyattacker{
    public void fireweapon(){
        System.out.println("The Enemy tank weapon has fired.");
    }
    public void driveforward(){
        System.out.println("The tank is driving forward");
    }
    public void assigndriver(){
        System.out.println("The driver has been assigned to the tank");
    }
}
class enemyrobot{
    public void smashwithHands(){
        System.out.println("The Enemy robot has smashed with it hands");

    }
    public void movesforward(){
      System.out.println("The robot is moving forward");
    }
    public void controlledby(){
        System.out.println("The robot control has been assigned to someone");
    }
}
class EnemyRobotAdapter implements enemyattacker{
    enemyrobot robot;
    public EnemyRobotAdapter(enemyrobot newrobot){
        this.robot = newrobot;
    }
    public void fireweapon(){
        robot.smashwithHands();
    };
    public void driveforward(){
        robot.movesforward();
    };
    public void assigndriver(){
        robot.controlledby();
    };
}