public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 6) {
            throw new IllegalArgumentException("Passenger capacity can not be equal or less than 6");
        } else {
            this.passengerCapacity = passengerCapacity;
        }
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return getBasePrice() * 0.14 + age * 100;
    }

    @Override
    public void performService() {
        System.out.println("Servicing Bus: " + getModel());
        System.out.println("Service every " + getServiceIntervalKm() + " km");
    }

    @Override
    public int getServiceIntervalKm() {
        return 100000;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Type: Bus" + ", Model: " + getModel() + ", Year: " + getYear() + ", Passenger capacity: " + passengerCapacity + ", Base price: " + getBasePrice() + ", Insurance fee: " + calculateInsuranceFee();
    }
}