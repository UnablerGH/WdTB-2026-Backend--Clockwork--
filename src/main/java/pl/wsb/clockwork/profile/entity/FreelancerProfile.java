package pl.wsb.clockwork.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.clockwork.account.domain.UserAccount;

import java.math.BigDecimal;

/**
 * Dane firmy freelancera do rozliczeń. Konto to logowanie, profil to dane biznesowe:
 * jedno konto ma najwyżej jeden profil, a profil należy do jednego konta (jeden-do-jednego).
 */
@Entity
@Table(name = "freelancer_profile")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FreelancerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount userAccount;

    @Column(nullable = false, length = 120)
    private String companyName;

    @Column(length = 30)
    private String taxId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal defaultHourlyRate;

    @Column(nullable = false, length = 3)
    private String currency = "PLN";
}
