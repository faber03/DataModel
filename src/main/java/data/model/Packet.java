package data.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import data.model.single.SingleVehicleMeanSpeedPayload;
import data.model.single.SingleVehicleTravelTimePayload;
import data.model.aggregate.AggregateVehiclesTravelTimePayload;
import data.model.total.TotalVehiclesMeanSpeedPayload;
import data.model.total.TotalVehiclesTravelTimePayload;
import data.model.total.VehiclesNumberPayload;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class Packet implements Serializable {
    private static final long serialVersionUID = 3930024432958038982L;

    public static final HashMap<String, Class<?>> payloadsMap;
    static {
        payloadsMap = new HashMap<>();
        payloadsMap.put("CameraPayload", CameraPayload.class);
        payloadsMap.put("VehiclesNumberPayload", VehiclesNumberPayload.class);
        payloadsMap.put("SingleVehicleMeanSpeedPayalod", SingleVehicleMeanSpeedPayload.class);
        payloadsMap.put("SingleVehicleTravelTimePayload", SingleVehicleTravelTimePayload.class);
        payloadsMap.put("TotalVehiclesMeanSpeedPayload", TotalVehiclesMeanSpeedPayload.class);
        payloadsMap.put("TotalVehiclesTravelTimePayload", TotalVehiclesTravelTimePayload.class);
        payloadsMap.put("AggregateVehiclesTravelTimePayload", AggregateVehiclesTravelTimePayload.class);
    }

    protected long linkId;
    protected long timestamp;
    protected ArrayList<Payload> payloads;
    
    public Packet() {}
    
    public Packet(long linkId, ArrayList<Payload> payloads){
        this.linkId = linkId;
        this.timestamp = Instant.now().toEpochMilli();
        this.payloads = payloads;
    }

    public Packet(long linkId, Payload payload){
        this.linkId = linkId;
        this.timestamp = Instant.now().toEpochMilli();
        this.payloads = new ArrayList<>();
        this.payloads.add(payload);
    }

    public Packet(long linkId, ArrayList<Payload> payloads, long timestamp){
        this.linkId = linkId;
        this.timestamp = timestamp;
        this.payloads = payloads;
    }

    public Packet(long linkId, Payload payload, long timestamp){
        this.linkId = linkId;
        this.timestamp = timestamp;
        this.payloads = new ArrayList<>();
        this.payloads.add(payload);
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

    public ArrayList<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(ArrayList<Payload> payloads) {
        this.payloads = payloads;
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
