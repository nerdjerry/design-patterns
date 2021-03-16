class Pizza{
    private String dough;
    private String sauce;
    private String topping;

    public void setDough(String dough){this.dough = dough;}
    public void setSauce(String sauce){this.sauce = sauce;}
    public void setTopping(String topping){this.topping = topping;}

    public void taste(){
        System.out.println("Pizza with " + dough +" dough," + sauce + " sauce and" + topping + " topping");
    }
}

abstract class PizzaBuilder{
    protected Pizza pizza;

    PizzaBuilder(){}

    //Getter to return Pizza
    public Pizza getPizza(){return pizza;}

    public void createNewPizzaProduct(){
        pizza = new Pizza();
    }

    //Methods that will be implemented by builders
    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTop();
}

class Margherita extends PizzaBuilder{
    public void buildDough() {pizza.setDough("cross");}
    public void buildSauce(){pizza.setSauce("tomato");}
    public void buildTop(){pizza.setTopping("Mozzarela + Basil");}
}

class Spicy extends PizzaBuilder{
    public void buildDough(){pizza.setDough("pan baked");}
    public void buildSauce(){pizza.setDough("Tomato + Chili");}
    public void buildTop(){pizza.setTopping("Pepporoni + Salami");}
}

class Cook{
    private PizzaBuilder builder;

    public void tastePizze(){builder.getPizza().taste();}

    public void makePizza(PizzaBuilder builder){
        this.builder = builder;
        builder.createNewPizzaProduct();
        builder.buildDough();
        builder.buildSauce();
        builder.buildTop();
    }
}

class Client{
   public static void main(String args[]){
        Cook cook = new Cook();
        Margherita margheritaBuilder = new Margherita();
        Spicy spicyBuilder = new Spicy();

        cook.makePizza(margheritaBuilder);
        cook.tastePizze();

        cook.makePizza(spicyBuilder);
        cook.tastePizze();
    }
}