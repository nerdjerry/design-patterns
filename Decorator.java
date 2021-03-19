interface PizzaDecoration{
    public String getDescription();
}

class PlainPizza implements PizzaDecoration{

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Plain Pizza";
    }

}

abstract class PizzaDecorator implements PizzaDecoration{
    PizzaDecoration pizza;

    PizzaDecorator(PizzaDecoration pizza){
        this.pizza = pizza;
    }

    public String getDescription(){
        return pizza.getDescription();
    }
}

class Mozerella extends PizzaDecorator{

    Mozerella(PizzaDecoration pizza) {
        super(pizza);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return pizza.getDescription() + " , Mozerlla";
    }
}

class TomatoSauce extends PizzaDecorator{

    TomatoSauce(PizzaDecoration pizza) {
        super(pizza);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return pizza.getDescription() + " , Tomato Sauce";
    }
}

class Decorator{

    public static void main(String[] args){
        PizzaDecoration pizza = new PlainPizza();
        System.out.println(pizza.getDescription());
        PizzaDecoration mozerallaTomatoSauce = new TomatoSauce(new Mozerella(pizza));
        System.out.println(mozerallaTomatoSauce.getDescription());

    }
}