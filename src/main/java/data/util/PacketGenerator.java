package data.util;

import com.google.gson.Gson;
import data.model.Packet;
import data.model.Payload;
import data.model.single.SingleVehicleTravelTimePayload;
import data.model.aggregate.AggregateVehiclesTravelTimePayload;
import data.model.total.TotalVehiclesTravelTimePayload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PacketGenerator {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String singleVehicleTravelTimePayload(long linkId, double travelTime, String timestamp) {
        SingleVehicleTravelTimePayload payload =
                new SingleVehicleTravelTimePayload("SingleVehicleTravelTimePayload",
                        travelTime, LocalDateTime.parse(timestamp, formatter));
        ArrayList<Payload> list = new ArrayList<>();
        list.add(payload);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }

    public static String totalVehiclesTravelTimePayload(long linkId, double travelTime, int numVehicles,
                                                        LocalDateTime startingDate, LocalDateTime finalDate) {
        TotalVehiclesTravelTimePayload payload = new TotalVehiclesTravelTimePayload(
                "AggregateVehiclesTravelTimePayload",
                travelTime, numVehicles, startingDate, finalDate);
        ArrayList<Payload> list= new ArrayList<>();
        list.add(payload);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }

    public static String aggTotalVehiclesTravelTimePayload(long linkId, double avgTravelTime, double sdTravelTime, int numVehicles,
                                                        LocalDateTime startingDate, LocalDateTime finalDate) {
        AggregateVehiclesTravelTimePayload payload = new AggregateVehiclesTravelTimePayload(
                "AggVehiclesTravelTimePayload",
                avgTravelTime, sdTravelTime, numVehicles, startingDate, finalDate);
        ArrayList<Payload> list= new ArrayList<>();
        list.add(payload);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }
}
