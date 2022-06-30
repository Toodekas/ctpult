package dev.toode.reading;

import javax.persistence.*;

@Entity
@Table
public class Reading {
    @Id
    @SequenceGenerator(
            name = "reading_sequence",
            sequenceName = "reading_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reading_sequence"
    )
    private Long id;
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
