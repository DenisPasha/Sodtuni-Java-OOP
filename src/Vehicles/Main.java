package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputCarArr = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(inputCarArr[1]);
        double carConsumption = Double.parseDouble(inputCarArr[2]);

        String[] inputTruckArr = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(inputTruckArr[1]);
        double truckConsumption = Double.parseDouble(inputTruckArr[2]);

        BaseVehicle car = new Car(carFuelQuantity,carConsumption);
        BaseVehicle truck = new Truck(truckFuelQuantity,truckConsumption);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String command = commandArr[0];
            String vehicleType = commandArr[1];

            switch (command){
                case "Drive":
                    if (vehicleType.equals("Car")){
                        car.drive(Double.parseDouble(commandArr[2]));
                    }else {
                        truck.drive(Double.parseDouble(commandArr[2]));
                    }
                    break;
                case "Refuel":
                    if (vehicleType.equals("Car")){
                        car.refuel(Double.parseDouble(commandArr[2]));
                    }else {
                        truck.refuel(Double.parseDouble(commandArr[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);

    }
}
