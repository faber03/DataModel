package data.model.totalvehicles;

import com.google.gson.Gson;
import data.model.Payload;

import java.time.LocalDateTime;


public class TotalVehiclesMeanSpeedPayload extends Payload {
    private double meanSpeed;
    private int numVehicles;
    private LocalDateTime startTime, endTime;

    public TotalVehiclesMeanSpeedPayload(String payloadId, double meanSpeed, int numVehicles, LocalDateTime startTime,
                                         LocalDateTime endTime){
        super.setPayloadId(payloadId);
        this.meanSpeed = meanSpeed;
        this.numVehicles = numVehicles;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getMeanSpeed() {
        return meanSpeed;
    }

    public void setMeanSpeed(double meanSpeed) {
        this.meanSpeed = meanSpeed;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
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
