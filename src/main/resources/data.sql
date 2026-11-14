-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: konta wszystkich osób z zespołu (reguła R1.03)
insert into user_account (email, display_name, role, created_at) values
                                                                     ('s850663@student.wroclaw.merito.pl', 'Wojciech', 'USER', current_timestamp),
                                                                     ('s961259@student.wroclaw.merito.pl', 'Nikodem',  'USER', current_timestamp),
                                                                     ('s494794@student.wroclaw.merito.pl', 'Bartosz',  'USER', current_timestamp),
                                                                     ('admin@example.com',                 'Admin',    'ADMIN', current_timestamp);

-- LAB 02: dane startowe dla nowych tabel (minimum 3 wiersze w każdej tabeli - reguła R2.03)
insert into client (name, contact_email, tax_id, active) values
                                                             ('TechNova Sp. z o.o.',   'kontakt@technova.pl',  'PL5213001122', true),
                                                             ('GreenRetail Polska',    'biuro@greenretail.pl', 'PL7811998877', true),
                                                             ('FinTrack Solutions',    'hello@fintrack.io',    'PL1132994455', false);

insert into project (name, hourly_rate, currency, archived) values
                                                                ('Sklep B2B - moduł płatności', 160.00, 'PLN', false),
                                                                ('Aplikacja mobilna CRM',       185.00, 'PLN', false),
                                                                ('Migracja bazy danych',        150.00, 'PLN', true);

insert into time_entry (task_description, work_date, duration_minutes, billable) values
                                                                                     ('Implementacja API koszyka i walidacji',      '2026-03-10', 180, true),
                                                                                     ('Konfiguracja środowiska testowego i CI/CD',  '2026-03-11', 120, true),
                                                                                     ('Spotkanie statusowe i wycena nowego etapu',  '2026-03-12', 45,  false);