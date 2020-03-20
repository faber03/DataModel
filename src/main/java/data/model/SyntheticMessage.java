package data.model;

import java.io.Serializable;

public class SyntheticMessage implements Serializable {
    private long id;
    private String areaName;
    private String timestamp;
    private double avgSpeed;
    private String avgTravelTime;

    public SyntheticMessage(long id, String areaName, String timestamp, double avgSpeed, String avgTravelTime){
        this.id = id;
        this.areaName = areaName;
        this.timestamp = timestamp;
        this.avgSpeed = avgSpeed;
        this.avgTravelTime = avgTravelTime;
    }
}
