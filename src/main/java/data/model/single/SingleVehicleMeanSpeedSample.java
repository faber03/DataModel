package data.model.single;

import com.google.gson.Gson;
import data.model.Sample;

import java.time.LocalDateTime;


public class SingleVehicleMeanSpeedSample extends Sample {

    private double meanSpeed;
    private LocalDateTime timestamp;

    public SingleVehicleMeanSpeedSample(String payloadId, double meanSpeed, LocalDateTime timestamp) {
        super.setPayloadId(payloadId);
        this.meanSpeed = meanSpeed;
        this.timestamp = timestamp;
    }

    public double getMeanSpeed() {
        return meanSpeed;
    }

    public void setMeanSpeed(double meanSpeed) {
        this.meanSpeed = meanSpeed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return  new Gson().toJson(this);
    }
}
