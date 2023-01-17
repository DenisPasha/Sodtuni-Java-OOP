package P05Polymorphism.Exercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputCarArr = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(inputCarArr[1]);
        double carConsumption = Double.parseDouble(inputCarArr[2]);
        double carTankCapacity = Double.parseDouble(inputCarArr[3]);

        String[] inputTruckArr = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(inputTruckArr[1]);
        double truckConsumption = Double.parseDouble(inputTruckArr[2]);
        double truckTankCapacity = Double.parseDouble(inputTruckArr[3]);

        String[] inputBusArr = scanner.nextLine().split(" ");
        double busFuelQuantity = Double.parseDouble(inputBusArr[1]);
        double busConsumption = Double.parseDouble(inputBusArr[2]);
        double busTankCapacity = Double.parseDouble(inputBusArr[3]);

        BaseVehicle car = new Car(carFuelQuantity,carConsumption,carTankCapacity);
        BaseVehicle truck = new Truck(truckFuelQuantity,truckConsumption,truckTankCapacity);
        BaseVehicle bus = new Bus(busFuelQuantity,busConsumption,busTankCapacity);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String command = commandArr[0];
            String vehicleType = commandArr[1];

            switch (command){
                case "Drive":
                    if (vehicleType.equals("Car")){
                        car.drive(Double.parseDouble(commandArr[2]));
                    }else if (vehicleType.equals("Truck")){
                        truck.drive(Double.parseDouble(commandArr[2]));
                    }else {

                        if (bus.getClass().getSimpleName().equals(Bus.class.getSimpleName())){
                               Bus bus1 = (Bus) bus;
                               bus1.driveFull(Double.parseDouble(commandArr[2]));
                            }
                    }
                    break;
                case "Refuel":
                    if (vehicleType.equals("Car")){
                        car.refuel(Double.parseDouble(commandArr[2]));
                    }else if (vehicleType.equals("Truck")){
                        truck.refuel(Double.parseDouble(commandArr[2]));
                    }else {
                        bus.refuel(Double.parseDouble(commandArr[2]));
                    }
                    break;
                case "DriveEmpty":
                    bus.drive(Double.parseDouble(commandArr[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
