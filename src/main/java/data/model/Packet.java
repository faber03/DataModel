package data.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import data.model.aggregate.AggregateVehiclesTravelTimeSample;
import data.model.single.SingleVehicleMeanSpeedSample;
import data.model.single.SingleVehicleTravelTimeSample;
import data.model.total.TotalVehiclesMeanSpeedSample;
import data.model.total.TotalVehiclesTravelTimeSample;
import data.model.total.VehiclesNumberSample;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class Packet implements Serializable {
    private static final long serialVersionUID = 3930024432958038982L;

    public static final HashMap<String, Class<?>> samplesMap;
    static {
        samplesMap = new HashMap<>();
        samplesMap.put("CameraSample", CameraSample.class);
        samplesMap.put("VehiclesNumberSample", VehiclesNumberSample.class);
        samplesMap.put("SingleVehicleMeanSpeedSample", SingleVehicleMeanSpeedSample.class);
        samplesMap.put("SingleVehicleTravelTimeSample", SingleVehicleTravelTimeSample.class);
        samplesMap.put("TotalVehiclesMeanSpeedSample", TotalVehiclesMeanSpeedSample.class);
        samplesMap.put("TotalVehiclesTravelTimeSample", TotalVehiclesTravelTimeSample.class);
        samplesMap.put("AggregateVehiclesTravelTimeSample", AggregateVehiclesTravelTimeSample.class);
    }

    protected long linkId;
    protected long timestamp;
    protected ArrayList<Sample> samples;
    
    public Packet() {}
    
    public Packet(long linkId, ArrayList<Sample> samples){
        this.linkId = linkId;
        this.timestamp = Instant.now().toEpochMilli();
        this.samples = samples;
    }

    public Packet(long linkId, Sample sample){
        this.linkId = linkId;
        this.timestamp = Instant.now().toEpochMilli();
        this.samples = new ArrayList<>();
        this.samples.add(sample);
    }

    public Packet(long linkId, ArrayList<Sample> samples, long timestamp){
        this.linkId = linkId;
        this.timestamp = timestamp;
        this.samples = samples;
    }

    public Packet(long linkId, Sample sample, long timestamp){
        this.linkId = linkId;
        this.timestamp = timestamp;
        this.samples = new ArrayList<>();
        this.samples.add(sample);
    }

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Sample> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<Sample> samples) {
        this.samples = samples;
    }

    public static String toJson(Object o){
        return new Gson().toJson(o);
    }

    public static Packet fromJson(String packetJson){
        GsonBuilder gsonBuilder = new GsonBuilder();

        JsonDeserializer<Packet> deserializer = new PacketDeserializer();
        gsonBuilder.registerTypeAdapter(Packet.class, deserializer);

        Gson customGson = gsonBuilder.create();

        return putTimestamp(customGson.fromJson(packetJson, Packet.class));
    }

    public static Packet putTimestamp(Packet packet){
        if(packet.timestamp <= 0) packet.setTimestamp(Instant.now().toEpochMilli());
        return packet;
    }

    public String toString(){
        return new Gson().toJson(this);
    }
}
