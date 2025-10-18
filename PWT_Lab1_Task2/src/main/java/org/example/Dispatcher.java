package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class Dispatcher {
    public Trip assign(Jobcard jc, ArrayList<Car> cars, ArrayList<Driver> drivers){
        String cargoType = jc.getCargoType();
        float cargoWeight = jc.getCargoWeight();
        Car defaultCar = new Car(-1, 999999, 0, "", CarCondition.WORKING, false);
        Driver defaultDriver = new Driver("",999,false,0);
        Car car = defaultCar;
        Driver driver = defaultDriver;
        for (Car c :cars){
            if (c.isAvailable() && c.getType().equals(cargoType)) {
                if (c.getLoadCapacity() >= cargoWeight && c.getLoadCapacity() < car.getLoadCapacity()) {
                    car = c;
                }
            }
        }
        for (Driver d : drivers){
            if (d.isAvailable()){
                if (d.getExperience() >= car.getDifficulty() && d.getExperience() < driver.getExperience()){
                    driver = d;
                }
            }
        }
        if (!driver.equals(defaultDriver) && !car.equals(defaultCar)){
            driver.setAvailable(false);
            car.setAvailable(false);
            return new Trip(driver, car, jc, TripStatus.IN_PROGRESS);
        } else {return null;}
    }
}
