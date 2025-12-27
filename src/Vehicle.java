public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    public Vehicle(String model, int year, double basePrice){
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public double getBasePrice() {
        return basePrice;
    }

    public void setModel(String model) {
        if(model == null) {
            System.out.println("Model can not be empty");
        }
        this.model = model;
    }

    public void setYear(int year) {
        if(year > 2025 || year < 1950) {
            System.out.println("Year must be in range 1950 - 2025");
        }
        this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if(basePrice <= 0) {
            System.out.println("Base price can not be equal or less than 0");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();
    @Override
    public String toString() {
        return String.format("ID: %d, Model: %s, Year: %d, Base Price: %.2f", id, model, year, basePrice);
    }
}