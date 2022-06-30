package dev.toode.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {
    @Query("SELECT r FROM Reading r WHERE r.deviceId = ?1")
    List<Reading> findReadingsByDeviceId(int deviceId);

    @Query("SELECT r from Reading r WHERE r.timestamp >= ?1 AND r.timestamp <= ?2")
    List<Reading> findReadingsBetweenTimestamps(Long startTimestamp, Long endTimestamp);
}
