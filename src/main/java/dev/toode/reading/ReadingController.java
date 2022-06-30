package dev.toode.reading;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReadingController {

    private final ReadingService readingService;

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping("/readings")
    public List<Reading> getReadings() {
        return readingService.getReadings();
    }

    @GetMapping("/readingsBetween")
    public List<DailyReading> getAllReadingsBetweenDates(@RequestParam(name = "startTimestamp") Long startTimestamp, @RequestParam(name = "endTimestamp") Long endTimestamp) {
        return readingService.getAllReadingsBetweenDates(startTimestamp, endTimestamp);
    }

    @GetMapping("/readingsBetweenDetailed")
    public List<Reading> getAllReadingsBetweenDatesDetailed(@RequestParam(name = "startTimestamp") Long startTimestamp, @RequestParam(name = "endTimestamp") Long endTimestamp) {
        return readingService.getAllReadingsBetweenDatesDetailed(startTimestamp, endTimestamp);
    }

    @PostMapping("/reading")
    public void addNewReading(@RequestBody Reading reading) {
        readingService.addReading(reading);
    }

    @PostMapping("/reading10")
    public void addNewReading10(@RequestBody List<Reading> readings) {
        readingService.addReading10(readings);
    }
}
