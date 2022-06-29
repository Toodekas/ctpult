package dev.toode.reading;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingService {

    public List<Reading> getReadings() {
        return List.of(new Reading(4, 1588680000000L, 35));
    }
}
