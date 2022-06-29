package dev.toode.reading;

public class Reading {
    private int deviceId;
    private Long timestamp;
    private int value;

    public Reading() {
    }

    public Reading(int deviceId, Long timestamp, int value) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "deviceId=" + deviceId +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
