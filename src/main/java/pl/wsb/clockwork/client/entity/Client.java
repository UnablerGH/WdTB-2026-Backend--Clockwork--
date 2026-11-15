package pl.wsb.clockwork.client.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.clockwork.project.entity.Project;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 160)
    private String contactEmail;

    @Column(length = 30)
    private String taxId;

    @Column(nullable = false)
    private boolean active = true;

    @Embedded
    private Address billingAddress;

    /** Projekty klienta: drugi koniec relacji Project.client (nie tworzy nowej kolumny). */
    @OneToMany(mappedBy = "client")
    private List<Project> projects = new ArrayList<>();
}