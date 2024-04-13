package techsolucoes.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techsolucoes.com.passin.domain.checkin.CheckIn;

public interface ChekinRepository extends JpaRepository<CheckIn, Integer> {
}
