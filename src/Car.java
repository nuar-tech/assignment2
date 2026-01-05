public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors can not be equal or less than 0");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return getBasePrice() * 0.14 + age * 50;
    }
    @Override
    public void performService(){
        System.out.println("Servicing Car: " + getModel());
        System.out.println("Service every " + getServiceIntervalKm() + " km");
    }

    @Override
    public int getServiceIntervalKm(){
        return 50000;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Type: Car" + ", Model: " + getModel() + ", Year: " + getYear() + ", Number of doors: " + numberOfDoors + ", Base price: " + getBasePrice() + ", Insurance fee: " + calculateInsuranceFee();
    }
}