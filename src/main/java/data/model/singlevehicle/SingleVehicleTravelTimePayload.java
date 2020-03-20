package data.model.singlevehicle;

import com.google.gson.Gson;
import data.model.Payload;

import java.time.LocalDateTime;


public class SingleVehicleTravelTimePayload extends Payload {
    private double travelTime;
    private LocalDateTime timestamp;

    public SingleVehicleTravelTimePayload(String payloadId, double travelTime,
                                          LocalDateTime timestamp){
        super.setPayloadId(payloadId);
        this.travelTime = travelTime;
        this.timestamp = timestamp;

    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return new Gson().toJson(this);
    }
}
