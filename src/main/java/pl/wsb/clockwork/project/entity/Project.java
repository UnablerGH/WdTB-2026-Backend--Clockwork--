package pl.wsb.clockwork.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pl.wsb.clockwork.client.entity.Client;

import java.math.BigDecimal;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @Column(nullable = false, length = 3)
    private String currency = "PLN";

    @Column(nullable = false)
    private boolean archived = false;

    /** Klient, dla którego realizowany jest projekt (wiele projektów → jeden klient). */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}