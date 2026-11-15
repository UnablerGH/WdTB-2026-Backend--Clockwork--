package pl.wsb.clockwork.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.clockwork.account.domain.UserAccount;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Encja łącząca (wiele-do-wielu): projekt ma wiele osób, a osoba pracuje przy wielu projektach.
 * Para ma własne dane (rola, stawka, data dołączenia), dlatego jest osobną encją, a nie @ManyToMany.
 */
@Entity
@Table(name = "project_member",
        uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "user_account_id"}))
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjectRole role;

    /** Stawka tej osoby w projekcie; brak oznacza stawkę projektu. */
    @Column(precision = 10, scale = 2)
    private BigDecimal hourlyRateOverride;

    @Column(nullable = false)
    private LocalDate joinedOn;
}
