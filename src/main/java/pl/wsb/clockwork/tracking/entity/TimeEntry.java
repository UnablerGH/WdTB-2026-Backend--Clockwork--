package pl.wsb.clockwork.tracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pl.wsb.clockwork.account.domain.UserAccount;
import pl.wsb.clockwork.project.entity.Project;

import java.time.LocalDate;

@Entity
@Table(name = "time_entry")
@Getter
@Setter
@NoArgsConstructor
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String taskDescription;

    @Column(nullable = false)
    private LocalDate workDate;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(nullable = false)
    private boolean billable = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TimeEntryStatus status = TimeEntryStatus.DRAFT;

    /** Projekt, do którego przypisano czas pracy (wiele wpisów → jeden projekt). */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /** Osoba, która zalogowała czas (wiele wpisów → jedno konto). */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;
}