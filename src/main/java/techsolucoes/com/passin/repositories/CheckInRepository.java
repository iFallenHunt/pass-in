package techsolucoes.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techsolucoes.com.passin.domain.checkin.CheckIn;

import java.util.Optional;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
    Optional<CheckIn> findByAttendeeId(String attendeeId);
}
