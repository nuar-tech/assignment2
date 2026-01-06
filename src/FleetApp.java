import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles;
    private Scanner scanner;
    public FleetApp(){
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void run(){
        while(true){
            printMenu();
            int num = scanner.nextInt();
            scanner.nextLine();

            switch(num){
                case 1:
                    printAll();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addBus();
                    break;
                case 4:
                    showTotal();
                    break;
                case 5:
                    showVehicles();
                    break;
                case 6:
                    performServiceAll();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid number choice");
            }
        }
    }
    public void printMenu(){
        System.out.println("1.Print all vehicles");
        System.out.println("2.Add new car");
        System.out.println("3.Add new bus");
        System.out.println("4.Show total insurance fees");
        System.out.println("5.Show vehicles older than N years");
        System.out.println("6.Perform service for all vehicles");
        System.out.println("7.Quit");
        System.out.println("Enter number");
    }

    public void printAll(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles found");
            return;
        }
        for(int i = 0; i < vehicles.size(); i++){
            Vehicle v = vehicles.get(i);
            System.out.println(v);
        }
    }

    public void addCar(){
        System.out.println("Enter model of car: ");
        String model = scanner.nextLine();

        System.out.println("Enter year of car: ");
        int year = scanner.nextInt();

        System.out.println("Enter base price of car: ");
        double basePrice = scanner.nextDouble();

        System.out.println("Enter number of doors: ");
        int numberOfDoors = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(model, year, basePrice, numberOfDoors);
        vehicles.add(car);
        System.out.println("Car added");
    }

    public void addBus(){
        System.out.println("Enter model of bus: ");
        String model = scanner.nextLine();

        System.out.println("Enter year of bus: ");
        int year = scanner.nextInt();

        System.out.println("Enter base price of bus: ");
        double basePrice = scanner.nextDouble();

        System.out.println("Enter capacity of passengers: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine();

        Bus bus = new Bus(model, year, basePrice, passengerCapacity);
        vehicles.add(bus);
        System.out.println("Bus added");
    }

    public void showTotal(){
        double total = 0.0;
        for(int i = 0; i < vehicles.size(); i++){
            Vehicle v = vehicles.get(i);
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance fee: " + total);
    }

    public void showVehicles(){
        System.out.println("Enter current year: ");
        int currentYear = scanner.nextInt();

        System.out.println("Enter minimum age for filter: ");
        int minage = scanner.nextInt();

        boolean exist = false;
        for(int i = 0; i < vehicles.size(); i++){
            Vehicle v = vehicles.get(i);
            if(v.getAge(currentYear) > minage){
                System.out.println(v);
                exist = true;
            }
        }
        if(exist == false){
            System.out.println("No cars found older");
        }
    }

    public void performServiceAll(){
        System.out.println("Servicing all vehicles");
        for(int i = 0; i < vehicles.size(); i++){
            vehicles.get(i).performService();
        }
    }
}