package org.example;


import lombok.*;

enum TripStatus {IN_PROGRESS, COMPLETE}

@Getter
@RequiredArgsConstructor
@ToString(includeFieldNames = false)
public class Trip {
    @NonNull private Driver driver;
    @NonNull private Car car;
    @NonNull private Jobcard jobcard;
    @Setter
    @NonNull private TripStatus status;

    private int currentDuration = 0;
    private int repairDays = 0;

    public void refreshStatus(){
        if (currentDuration == (int) Math.ceil(jobcard.getDistance() / 50) ){
            setStatus(TripStatus.COMPLETE);
            car.setAvailable(true);
            driver.setAvailable(true);
            driver.setMoney(driver.getMoney() + (repairDays + currentDuration) * car.getDifficulty());
        } else if (car.getCondition() == CarCondition.BROKEN) {repairDays += 1;}
        else{currentDuration += 1;}
    }
}
