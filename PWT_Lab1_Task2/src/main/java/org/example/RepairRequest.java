package org.example;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

enum RepairStatus {IN_PROGRESS, COMPLETE}

@RequiredArgsConstructor
public class RepairRequest {
    @NonNull private Car car;
    @Getter
    @Setter
    private RepairStatus status = RepairStatus.IN_PROGRESS;

    private int currentDuration = 0;

    public void refreshStatus(){
        if (currentDuration == 1 ){
            setStatus(RepairStatus.COMPLETE);
            car.setCondition(CarCondition.WORKING);
        }else{currentDuration += 1;}
    }
}
