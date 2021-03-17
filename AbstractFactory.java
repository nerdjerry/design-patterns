interface DoorHandle_AbstractProduct{
    public void printSerialNumber();
}

class BMWDoorHandle implements DoorHandle_AbstractProduct{

    @Override
    public void printSerialNumber() {
        // TODO Auto-generated method stub
        System.out.println("Door Handle : BMW123");
    }

}

class FordDoorHandle implements DoorHandle_AbstractProduct{

    @Override
    public void printSerialNumber() {
        // TODO Auto-generated method stub
        System.out.println("Door Handle : Ford123");
        
    }

}

interface AbstractFactory{
    public DoorHandle_AbstractProduct createDoorHandle();
}

class BMWFactory implements AbstractFactory{

    @Override
    public DoorHandle_AbstractProduct createDoorHandle() {
        // TODO Auto-generated method stub
        return new BMWDoorHandle();
    }

}

class FordFactory implements AbstractFactory{

    @Override
    public DoorHandle_AbstractProduct createDoorHandle() {
        // TODO Auto-generated method stub
        return new FordDoorHandle();
    }

}

class User{
    public static void main(String[] args){
        AbstractFactory factory;
        DoorHandle_AbstractProduct product;

        factory = new BMWFactory();
        product = factory.createDoorHandle();

        product.printSerialNumber();

        factory = new FordFactory();
        product = factory.createDoorHandle();

        product.printSerialNumber();
    }
}