package data.model.single;

import com.google.gson.Gson;
import data.model.Payload;

import java.time.LocalDateTime;


public class SingleVehicleMeanSpeedPayload extends Payload {

    private double meanSpeed;
    private LocalDateTime timestamp;

    public SingleVehicleMeanSpeedPayload(String payloadId, double meanSpeed, LocalDateTime timestamp) {
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
