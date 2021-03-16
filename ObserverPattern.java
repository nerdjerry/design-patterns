import java.util.ArrayList;

interface Observer{
    public void update(double price);

}

interface Subject{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();
}

class StockSubject implements Subject{
    private ArrayList<Observer> observers;
    private double ibmPrice;

    public StockSubject(){
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
        
    }

    @Override
    public void notifyObserver() {
        // TODO Auto-generated method stub
        for(Observer observer : observers){
            observer.update(this.ibmPrice);
        }
        
    }

    public void setIBMPrice(double ibmPrice){
        this.ibmPrice = ibmPrice;
        this.notifyObserver();
    }

    public double getIBMPrice(){
        return this.ibmPrice;
    }
}

class StockObserver implements Observer{

    private double ibmPrice;
    private static int observerUID = 0;
    private int observerID;

    private Subject stockObserver;

    StockObserver(Subject subject){
        this.stockObserver = subject;
        this.observerID = ++observerUID;
        stockObserver.register(this);
    }

    @Override
    public void update(double price) {
        // TODO Auto-generated method stub
        this.ibmPrice = price;
        System.out.println(observerID + "\nIBM: " + this.ibmPrice);
    }
}

class Driver{
    public static void main(String[] args){
        StockSubject subject = new StockSubject();
        StockObserver observer1 = new StockObserver(subject);

        subject.setIBMPrice(197.00);
    }
}