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
            JsonArray ja = jo.getAsJsonArray("samples");

            ArrayList<Sample> samples = new ArrayList<>();
            JsonElement sampleIdJson;
            String sampleId;
            Class<?> c;
            for(JsonElement je: ja){
                JsonObject jeo = je.getAsJsonObject();
                sampleIdJson = jeo.get("sampleId");
                if(sampleIdJson != null){
                    sampleId = sampleIdJson.getAsString();
                    if(Packet.samplesMap.containsKey(sampleId)){
                        c = (Packet.samplesMap.get(sampleId));
                        samples.add((Sample) new Gson().fromJson(jeo, c));
                    }
                }
            }

            packet.setSamples(samples);

            JsonElement temp;
            temp = jo.get("linkId");
            if (temp != null) packet.setLinkId(temp.getAsLong());

            temp = jo.get("timestamp");
            if (temp != null) packet.setTimestamp(temp.getAsLong());

            return  packet;
        }
    }
}
