package org.example;

import java.util.ArrayList;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Dispatcher dispatcher = new Dispatcher();
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<Jobcard> jobcards = new ArrayList<>();
        ArrayList<RepairRequest> repairRequests = new ArrayList<>();
        ArrayList<Trip> trips = new ArrayList<>();
        Random random = new Random();

        cars.add(new Car(1, 50, 1, "Solid", CarCondition.WORKING, true));
        cars.add(new Car(2, 100, 3, "Solid", CarCondition.WORKING, true));
        cars.add(new Car(3, 50, 2, "Liquid", CarCondition.WORKING, true));
        cars.add(new Car(4, 200, 4, "Liquid", CarCondition.WORKING, true));

        drivers.add(new Driver("Driver 1", 3, true, 0));
        drivers.add(new Driver("Driver 2", 1, true, 0));
        drivers.add(new Driver("Driver 3", 2, true, 0));
        drivers.add(new Driver("Driver 4", 4, true, 0));

        jobcards.add(new Jobcard(1, "Destination 1", 500, "Solid", 30));
        jobcards.add(new Jobcard(2, "Destination 2", 250, "Liquid", 45));
        jobcards.add(new Jobcard(3, "Destination 3", 300, "Solid", 45));
        jobcards.add(new Jobcard(4, "Destination 4", 150, "Liquid", 150));
        jobcards.add(new Jobcard(5, "Destination 5", 700, "Liquid", 50));
        jobcards.add(new Jobcard(6, "Destination 6", 180, "Solid", 75));

        for (int day = 1; day < 15; day++){
            System.out.println("Day " + day);

            for (Trip t : trips){
                if (t.getStatus() == TripStatus.IN_PROGRESS){
                    t.refreshStatus();
                }
            }

            for (RepairRequest r : repairRequests){
                if (r.getStatus() == RepairStatus.IN_PROGRESS){
                    r.refreshStatus();
                }
            }

            try{
                Jobcard incomeJobcard = jobcards.get(random.nextInt(jobcards.size()));
                Trip trip = dispatcher.assign(incomeJobcard, cars, drivers);
                if (trip != null){
                    trips.add(trip);
                    System.out.println("Диспетчер призначив новий рейс:\n" + trip);
                    jobcards.remove(incomeJobcard);
                }else {
                    System.out.println("Цього дня не було призначено жодного рейсу.");
                }
            }catch (Exception _){System.out.println("Цього дня не було призначено жодного рейсу.");}

            for (Trip t : trips){
                if (t.getStatus() == TripStatus.IN_PROGRESS){
                    if (random.nextInt(20) == 0){
                        t.getCar().setCondition(CarCondition.BROKEN);
                        repairRequests.add(t.getDriver().requestRepair(t.getCar()));
                    }
                }
            }
        }
        System.out.println("Історія рейсів:");
        for (Trip t : trips){
            System.out.println(t);
        }
    }
}