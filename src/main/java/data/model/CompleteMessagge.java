package data.model;

import java.io.Serializable;

public class CompleteMessagge implements Serializable {
    private long id;
    private float length;
    private int ffs, speedlimit, frc, netclass, fow;
    private String routenumber, areaname, name, geom, timestamp, avgTraveltime;
    private double avgSpeed;

    public CompleteMessagge(long id, float length, int ffs, int speedlimit, int frc, int netclass,
                            int fow, String routenumber, String areaname, String name, String geom,
                            String timestamp, double avgSpeed, String avgTravelTime){
        this.id = id;
        this.length = length;
        this.ffs = ffs;
        this.speedlimit = speedlimit;
        this.frc = frc;
        this.netclass = netclass;
        this.fow = fow;
        this.routenumber = routenumber;
        this.areaname = areaname;
        this.name = name;
        this.geom = geom;
        this.timestamp = timestamp;
        this.avgSpeed = avgSpeed;
        this.avgTraveltime = avgTravelTime;
    }
}
