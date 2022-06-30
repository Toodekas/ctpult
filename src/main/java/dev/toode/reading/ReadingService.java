package dev.toode.reading;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }


    public List<Reading> getReadings() {
        return readingRepository.findAll();
    }

    public void addReading(Reading reading) {
        List<Reading> readingsByDeviceId = readingRepository.findReadingsByDeviceId(reading.getDeviceId());
        if(readingsByDeviceId.size() > 0){
            for (Reading currReading: readingsByDeviceId) {
                if(currReading.getTimestamp().equals(reading.getTimestamp())){
                    throw new IllegalStateException("Cannot have two devices with same timestamp");
                }
            }
        }
        readingRepository.save(reading);
    }

    public List<DailyReading> getAllReadingsBetweenDates(Long startTimestamp, Long endTimestamp) {
        List<Reading> readings = readingRepository.findReadingsBetweenTimestamps(startTimestamp, endTimestamp);
        List<DailyReading> dailyReadings = new ArrayList<>();
        for (Reading reading: readings) {
            LocalDate currentDate = new DateTime(reading.getTimestamp()).toLocalDate();
            DailyReading currentReading = new DailyReading(currentDate.toString(), reading.getValue());
            boolean sameDate = false;
            for (DailyReading dReading: dailyReadings) {
                if(dReading.getDate().equals(currentReading.getDate()) && !sameDate){
                    dReading.setValue(dReading.getValue() + currentReading.getValue());
                    sameDate = true;
                }
            }
            if(!sameDate){
                dailyReadings.add(currentReading);
            }

        }
        Collections.sort(dailyReadings);
        return dailyReadings;
    }

    public void addReading10(List<Reading> readings) {
        if(readings.size() != 10){
            throw new IllegalStateException("Payload does not contain 10 values");
        }
        for (Reading reading: readings) {
            this.addReading(reading);
        }
    }

    public List<Reading> getAllReadingsBetweenDatesDetailed(Long startTimestamp, Long endTimestamp) {
        return readingRepository.findReadingsBetweenTimestamps(startTimestamp, endTimestamp);
    }
}
