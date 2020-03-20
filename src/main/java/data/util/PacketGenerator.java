package data.util;

import com.google.gson.Gson;
import data.model.Packet;
import data.model.Payload;
import data.model.singlevehicle.SingleVehicleTravelTimePayload;
import data.model.totalvehicles.TotalVehiclesTravelTimePayload;

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
                "TotalVehiclesTravelTimePayload",
                travelTime, numVehicles, startingDate, finalDate);
        ArrayList<Payload> list= new ArrayList<>();
        list.add(payload);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }
}
