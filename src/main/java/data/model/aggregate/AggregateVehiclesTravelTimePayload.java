package data.model.aggregate;

import com.google.gson.Gson;
import data.model.Payload;

import java.time.LocalDateTime;

public class AggregateVehiclesTravelTimePayload extends Payload {
	private double avgTravelTime;
	private double sdTravelTime;
	private  int numVehicles;
	private LocalDateTime startTime, endTime;

	public AggregateVehiclesTravelTimePayload(String payloadId, double avgTravelTime, double sdTravelTime, int numVehicles, LocalDateTime startTime,
											  LocalDateTime endTime){
		super.setPayloadId(payloadId);
		this.avgTravelTime = avgTravelTime;
		this.sdTravelTime = sdTravelTime;
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

	public double getSdTravelTime() {
		return sdTravelTime;
	}

	public void setSdTravelTime(double sdTravelTime) {
		this.sdTravelTime = sdTravelTime;
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
