package data.model.total;

import com.google.gson.Gson;
import data.model.Sample;

import java.time.LocalDateTime;

public class TotalVehiclesTravelTimeSample extends Sample {

    private double avgTravelTime;
    private  int numVehicles;
    private LocalDateTime startTime, endTime;

    public TotalVehiclesTravelTimeSample(String payloadId, double avgTravelTime, int numVehicles, LocalDateTime startTime,
                                         LocalDateTime endTime){
        super.setPayloadId(payloadId);
        this.avgTravelTime = avgTravelTime;
        this.numVehicles = numVehicles;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getAvgTravelTime() {
        return avgTravelTime;
    }

    public void setAvgTravelTime(double avgTravelTime) {
        this.avgTravelTime = avgTravelTime;
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
