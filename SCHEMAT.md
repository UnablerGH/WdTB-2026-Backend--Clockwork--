# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 40 · relacje: 5 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| client | Client | 9 | — |
| freelancer_profile | FreelancerProfile | 6 | user_account_id |
| project | Project | 6 | client_id |
| project_member | ProjectMember | 6 | project_id, user_account_id |
| time_entry | TimeEntry | 8 | project_id, user_account_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    client {
        Long id PK
        boolean active
        String city
        String contact_email
        String country
        String name
        String postal_code
        String street
        String tax_id
    }
    freelancer_profile {
        Long id PK
        String company_name
        String currency
        BigDecimal default_hourly_rate
        String tax_id
        Long user_account_id FK
    }
    project {
        Long id PK
        boolean archived
        Long client_id FK
        String currency
        BigDecimal hourly_rate
        String name
    }
    project_member {
        Long id PK
        BigDecimal hourly_rate_override
        LocalDate joined_on
        Long project_id FK
        ProjectRole role
        Long user_account_id FK
    }
    time_entry {
        Long id PK
        boolean billable
        Integer duration_minutes
        Long project_id FK
        TimeEntryStatus status
        String task_description
        Long user_account_id FK
        LocalDate work_date
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    client ||--o{ project : "client_id"
    project ||--o{ project_member : "project_id"
    project ||--o{ time_entry : "project_id"
    user_account ||--o{ project_member : "user_account_id"
    user_account ||--o{ time_entry : "user_account_id"
    user_account ||--o| freelancer_profile : "user_account_id"
```
