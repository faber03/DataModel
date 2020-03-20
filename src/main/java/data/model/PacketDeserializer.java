package data.model;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PacketDeserializer implements JsonDeserializer<Packet> {

    @Override
    public Packet deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null)
            return null;
        else{
            Packet packet = new Packet();
            JsonObject jo = jsonElement.getAsJsonObject();
            JsonArray ja = jo.getAsJsonArray("payloads");

            ArrayList<Payload> payloads = new ArrayList<>();
            JsonElement payloadIdJson;
            String payloadId;
            Class<?> c;
            for(JsonElement je: ja){
                JsonObject jeo = je.getAsJsonObject();
                payloadIdJson = jeo.get("payloadId");
                if(payloadIdJson != null){
                    payloadId = payloadIdJson.getAsString();
                    if(Packet.payloadsMap.containsKey(payloadId)){
                        c = (Packet.payloadsMap.get(payloadId));
                        payloads.add((Payload) new Gson().fromJson(jeo, c));
                    }
                }
            }

            packet.setPayloads(payloads);

            JsonElement temp;
            temp = jo.get("linkId");
            if (temp != null) packet.setLinkId(temp.getAsLong());

            temp = jo.get("timestamp");
            if (temp != null) packet.setTimestamp(temp.getAsLong());

            return  packet;
        }
    }
}
