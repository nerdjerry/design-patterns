abstract class Animal{
    MoveLogic movement;

    Animal(MoveLogic movementLogic){
        movement = movementLogic;
    }

    abstract void howDoIMove();
}

class Human extends Animal{

    Human(MoveLogic walking){
        super(walking);
    }

    @Override
    void howDoIMove() {
        // TODO Auto-generated method stub
        movement.move();
    }
}

class Fish extends Animal{
    
    Fish(MoveLogic swimming){
        super(swimming);
    }

    @Override
    void howDoIMove() {
        // TODO Auto-generated method stub
        movement.move();
    }
}

interface MoveLogic{
    public void move();
}

class Walk implements MoveLogic{

    @Override
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("Move by legs");
    }

}

class Swim implements MoveLogic{

    @Override
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("Move by swimming");
    }

}

public class Bridge {
    
    public static void main(String[] args){
        Animal person = new Human(new Walk());
        Animal shark = new Fish(new Swim());

        person.howDoIMove();
        shark.howDoIMove();
    }

}
