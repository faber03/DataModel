package data.model.total;

import com.google.gson.Gson;
import data.model.Sample;

import java.time.LocalDateTime;

public class VehiclesNumberSample extends Sample {
    private int vehiclesNumber;
    private LocalDateTime startTime, endTime;

    public VehiclesNumberSample(String payloadId, int numVehicles, LocalDateTime startTime, LocalDateTime endTime){
        super.setPayloadId(payloadId);
        this.vehiclesNumber = numVehicles;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getVehiclesNumber() {
        return vehiclesNumber;
    }

    public void setVehiclesNumber(int vehiclesNumber) {
        this.vehiclesNumber = vehiclesNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String toString(){
        return new Gson().toJson(this);
    }
}
