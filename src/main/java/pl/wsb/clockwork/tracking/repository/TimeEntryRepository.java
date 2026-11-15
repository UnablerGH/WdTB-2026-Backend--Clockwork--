package pl.wsb.clockwork.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.clockwork.tracking.entity.TimeEntry;
import pl.wsb.clockwork.tracking.entity.TimeEntryStatus;

import java.util.List;

/**
 * Dostęp do wpisów czasu. Spring Data tworzy zapytania SQL z nazw metod;
 * podkreślenie w nazwie oznacza przejście przez relację (np. project → client → name).
 */
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    /** Wpisy czasu dla projektów danego klienta: time_entry → project → client. */
    List<TimeEntry> findByProject_Client_Name(String clientName);

    /** Wpisy czasu danej osoby o wybranym statusie, np. do zatwierdzenia. */
    List<TimeEntry> findByUserAccount_EmailAndStatus(String email, TimeEntryStatus status);
}
