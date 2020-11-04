package data.util;

import com.google.gson.Gson;
import data.model.Packet;
import data.model.Sample;
import data.model.aggregate.AggregateVehiclesTravelTimeSample;
import data.model.single.SingleVehicleTravelTimeSample;
import data.model.total.TotalVehiclesTravelTimeSample;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PacketGenerator {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String singleVehicleTravelTimeSample(long linkId, double travelTime, String timestamp) {
        SingleVehicleTravelTimeSample sample =
                new SingleVehicleTravelTimeSample("SingleVehicleTravelTimeSample",
                        travelTime, LocalDateTime.parse(timestamp, formatter));
        ArrayList<Sample> list = new ArrayList<>();
        list.add(sample);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }

    public static String totalVehiclesTravelTimeSample(long linkId, double travelTime, int numVehicles,
                                                        LocalDateTime startingDate, LocalDateTime finalDate) {
        TotalVehiclesTravelTimeSample sample = new TotalVehiclesTravelTimeSample(
                "AggregateVehiclesTravelTimeSample",
                travelTime, numVehicles, startingDate, finalDate);
        ArrayList<Sample> list= new ArrayList<>();
        list.add(sample);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }

    public static String aggregateVehiclesTravelTimeSample(long linkId, double avgTravelTime, double sdTravelTime,
                                                            int numVehicles,
                                                            Duration aggPeriod,
                                                            LocalDateTime startingDate,
                                                            LocalDateTime finalDate) {
        AggregateVehiclesTravelTimeSample sample = new AggregateVehiclesTravelTimeSample(
                "AggVehiclesTravelTimeSample",
                avgTravelTime, sdTravelTime, numVehicles, aggPeriod, startingDate, finalDate);
        ArrayList<Sample> list= new ArrayList<>();
        list.add(sample);
        Packet p = new Packet(linkId, list);
        return new Gson().toJson(p);
    }
}
