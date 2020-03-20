package data.model;

import com.google.gson.Gson;

import java.time.LocalDateTime;

public class CameraPayload extends  Payload {
    private Byte[] img;
    private LocalDateTime timestamp;
    private boolean atRoadEntrance;

    public CameraPayload(String payloadId, Byte[] img, LocalDateTime timestamp, boolean atRoadEntrance){
        super.setPayloadId(payloadId);
        this.img = img;
        this.timestamp = timestamp;
        this.atRoadEntrance = atRoadEntrance;
    }

    public Byte[] getImg() {
        return img;
    }

    public void setImg(Byte[] img) {
        this.img = img;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isAtRoadEntrance() {
        return atRoadEntrance;
    }

    public void setAtRoadEntrance(boolean atRoadEntrance) {
        this.atRoadEntrance = atRoadEntrance;
    }

    public String toString(){
        return  new Gson().toJson(this);
    }
}
