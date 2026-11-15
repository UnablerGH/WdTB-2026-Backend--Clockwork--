-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.

-- LAB 01: konta wszystkich osób z zespołu (reguła R1.03)
insert into user_account (email, display_name, role, created_at) values
    ('s850663@student.wroclaw.merito.pl', 'Wojciech', 'USER',  current_timestamp),
    ('s961259@student.wroclaw.merito.pl', 'Nikodem',  'USER',  current_timestamp),
    ('s494794@student.wroclaw.merito.pl', 'Bartosz',  'USER',  current_timestamp),
    ('admin@example.com',                 'Admin',    'ADMIN', current_timestamp);

-- LAB 02: dane startowe dla tabel zespołu (minimum 3 wiersze w każdej tabeli - reguła R2.03)

-- client (adres do faktury to klasa wbudowana Address: kolumny street, city, postal_code, country)
insert into client (name, contact_email, tax_id, active, street, city, postal_code, country) values
    ('TechNova Sp. z o.o.', 'kontakt@technova.pl',  'PL5213001122', true,  'ul. Legnicka 48',     'Wrocław',  '54-202', 'PL'),
    ('GreenRetail Polska',  'biuro@greenretail.pl', 'PL7811998877', true,  'ul. Półwiejska 12',   'Poznań',   '61-888', 'PL'),
    ('FinTrack Solutions',  'hello@fintrack.io',    'PL1132994455', false, 'ul. Prosta 20',       'Warszawa', '00-850', 'PL');

-- project (client_id: numer wiersza z tabeli client)
insert into project (name, hourly_rate, currency, archived, client_id) values
    ('Sklep B2B - moduł płatności', 160.00, 'PLN', false, 1),
    ('Aplikacja mobilna CRM',       185.00, 'PLN', false, 2),
    ('Migracja bazy danych',        150.00, 'PLN', true,  1);

-- time_entry (status: enum TimeEntryStatus zapisany jako tekst; project_id i user_account_id: numery wierszy z tabel project i user_account)
insert into time_entry (task_description, work_date, duration_minutes, billable, status, project_id, user_account_id) values
    ('Implementacja API koszyka i walidacji',     '2026-03-10', 180, true,  'INVOICED', 1, 1),
    ('Konfiguracja środowiska testowego i CI/CD', '2026-03-11', 120, true,  'APPROVED', 1, 2),
    ('Spotkanie statusowe i wycena nowego etapu', '2026-03-12', 45,  false, 'DRAFT',    2, 3);

-- ===== LAB 03 · project_member (encja łącząca project ↔ user_account) =====
insert into project_member (project_id, user_account_id, role, hourly_rate_override, joined_on) values
    (1, 1, 'OWNER',     null,   '2026-03-01'),
    (1, 2, 'DEVELOPER', 140.00, '2026-03-02'),
    (2, 2, 'OWNER',     null,   '2026-03-05'),
    (2, 3, 'REVIEWER',  120.00, '2026-03-06');

-- ===== LAB 03 · freelancer_profile (jeden profil na konto: user_account_id bez powtórzeń) =====
insert into freelancer_profile (user_account_id, company_name, tax_id, default_hourly_rate, currency) values
    (1, 'Pietrzak Software',  'PL8971234567', 150.00, 'PLN'),
    (2, 'Jaśkowiak Dev',      'PL8987654321', 140.00, 'PLN'),
    (3, 'Kaczor IT Services', null,           130.00, 'PLN');
