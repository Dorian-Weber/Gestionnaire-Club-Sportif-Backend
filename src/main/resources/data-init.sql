INSERT INTO sport (sport_name) VALUES
                   ('Football'),
                   ('Basketball'),
                   ('Tennis'),
                   ('Natation'),
                   ('Athlétisme');


INSERT INTO discipline (discipline_name, event_record, world_record, sport_id) VALUES
                    ('100m Sprint', '9.58 s', '9.58 s', 5),
                    ('200m Sprint', '19.19 s', '19.19 s', 5),
                    ('Saut en hauteur', '2.45 m', '2.45 m', 5),
                    ('Saut en longueur', '8.95 m', '8.95 m', 5),
                    ('Lancer de javelot', '98.48 m', '98.48 m', 5),
                    ('100m Papillon', '49.45 s', '49.45 s', 4),
                    ('200m Nage libre', '1:42.00', '1:42.00', 4),
                    ('50m Brasse', '25.95 s', '25.95 s', 4),
                    ('Simple', NULL, NULL, 3),
                    ('Double', NULL, NULL, 3);

INSERT INTO event_type (event_type_name) VALUES
                     ('Match'),
                     ('Tournoi'),
                     ('Compétition'),
                     ('Entraînement'),
                     ('Exhibition');


INSERT INTO event (event_name, event_description, event_date, event_type_id, sport_id) VALUES
                    ('Match amical FC Metz vs Nancy', 'Rencontre amicale entre deux clubs lorrains.', '2026-03-12 18:00:00', 1, 1),
                    ('Tournoi régional U18', 'Tournoi de jeunes équipes locales.', '2026-04-05 14:00:00', 2, 1),
                    ('Entraînement intensif FC Metz', 'Séance technique et physique.', '2026-05-02 10:00:00', 4, 1),
                    ('Match Basket Metz vs Strasbourg', 'Match de championnat régional.', '2026-03-20 20:00:00', 1, 2),
                    ('Tournoi 3v3 Metz Centre', 'Tournoi urbain de basket 3 contre 3.', '2026-06-11 15:00:00', 2, 2),
                    ('Entraînement tactique Basket Metz', 'Séance axée sur les systèmes offensifs.', '2026-04-18 09:00:00', 4, 2),
                    ('Open de Metz – Simple', 'Match de simple du tournoi local.', '2026-05-22 16:00:00', 3, 3),
                    ('Open de Metz – Double', 'Match de double du tournoi local.', '2026-05-23 14:00:00', 3, 3),
                    ('Entraînement Tennis – Service', 'Séance dédiée au service.', '2026-04-10 11:00:00', 4, 3),
                    ('Compétition 100m Papillon', 'Finale départementale.', '2026-07-02 10:00:00', 3, 4),
                    ('Compétition 200m Nage libre', 'Épreuve régionale.', '2026-07-03 11:00:00', 3, 4),
                    ('Entraînement Natation – Endurance', 'Séance longue distance.', '2026-04-08 08:00:00', 4, 4),
                    ('Meeting Metz – 100m', 'Course de sprint.', '2026-06-15 14:00:00', 3, 5),
                    ('Meeting Metz – 200m', 'Course de demi-fond rapide.', '2026-06-15 15:00:00', 3, 5),
                    ('Meeting Metz – Saut en hauteur', 'Concours de saut.', '2026-06-16 10:00:00', 3, 5),
                    ('Meeting Metz – Saut en longueur', 'Concours de saut.', '2026-06-16 11:00:00', 3, 5),
                    ('Meeting Metz – Javelot', 'Concours de lancer.', '2026-06-17 09:00:00', 3, 5),
                    ('Exhibition Football – Stars Lorraines', 'Match caritatif.', '2026-09-01 18:00:00', 5, 1),
                    ('Exhibition Basket – Metz Legends', 'Match de gala.', '2026-09-10 19:00:00', 5, 2),
                    ('Exhibition Tennis – Duo Show', 'Démonstration de double.', '2026-09-15 17:00:00', 5, 3);

INSERT INTO country (country_name) VALUES
                   ('France'),
                   ('Allemagne'),
                   ('Espagne'),
                   ('Italie'),
                   ('États-Unis'),
                   ('Canada'),
                   ('Brésil'),
                   ('Royaume-Uni'),
                   ('Japon'),
                   ('Australie');


INSERT INTO athlete (athlete_name, athlete_first_name, athlete_birth_date, country_id) VALUES
                    ('Dupont', 'Lucas', '1994-03-12', 1),
                    ('Martin', 'Hugo', '1996-07-22', 1),
                    ('Bernard', 'Clément', '1992-11-05', 1),
                    ('Schneider', 'Anna', '1995-02-18', 2),
                    ('Müller', 'Karl', '1990-09-30', 2),
                    ('Gonzalez', 'Carlos', '1993-04-14', 3),
                    ('Lopez', 'Maria', '1997-06-21', 3),
                    ('Rossi', 'Luca', '1991-12-01', 4),
                    ('Bianchi', 'Marco', '1995-08-09', 4),
                    ('Smith', 'Emily', '1994-10-03', 5),
                    ('Johnson', 'Michael', '1988-05-27', 5),
                    ('Brown', 'Sarah', '1992-01-15', 5),
                    ('Wilson', 'David', '1993-03-19', 5),
                    ('Clark', 'Sophia', '1996-09-11', 5),
                    ('Dubois', 'Antoine', '1998-02-07', 1),
                    ('Petit', 'Julien', '1997-04-25', 1),
                    ('Keller', 'Sven', '1993-06-30', 2),
                    ('Weber', 'Nina', '1999-01-20', 2),
                    ('Navarro', 'Pablo', '1995-03-17', 3),
                    ('Santos', 'Rafael', '1992-12-12', 7),
                    ('Oliveira', 'Bruna', '1996-07-08', 7),
                    ('Campbell', 'Oliver', '1994-11-29', 8),
                    ('Baker', 'Chloe', '1997-05-14', 8),
                    ('Tanaka', 'Haruto', '1993-09-02', 9),
                    ('Sato', 'Yui', '1998-03-28', 9),
                    ('Wilson', 'Jack', '1991-10-10', 10),
                    ('Miller', 'Ava', '1996-12-22', 10),
                    ('Anderson', 'Noah', '1995-08-18', 10),
                    ('Thompson', 'Lily', '1997-06-05', 10),
                    ('Garcia', 'Miguel', '1994-04-12', 3);-am

INSERT INTO team (team_name) VALUES
                     ('FC Metz'),
                     ('AS Nancy'),
                     ('Strasbourg United'),
                     ('Lyon Olympique'),
                     ('Paris Est Club'),
                     ('Metz Basket Club'),
                     ('Strasbourg Hoops'),
                     ('Nancy Dunkers'),
                     ('Lyon Shooting Stars'),
                     ('Paris Court Kings');

INSERT INTO team_athletes (team_id, athlete_id) VALUES
                        (1, 1), (1, 2), (1, 3),
                        (2, 4), (2, 5), (2, 6),
                        (3, 7), (3, 8), (3, 9),
                        (4, 10), (4, 11), (4, 12),
                        (5, 13), (5, 14), (5, 15),
                        (6, 16), (6, 17), (6, 18),
                        (7, 19), (7, 20), (7, 21),
                        (8, 22), (8, 23), (8, 24),
                        (9, 25), (9, 26), (9, 27),
                        (10, 28), (10, 29), (10, 30);

INSERT INTO event_teams (event_id, team_id) VALUES
                        (1, 1), (1, 2),
                        (2, 3), (2, 4), (2, 5),
                        (3, 1),

                        (4, 6), (4, 7),
                        (5, 8), (5, 9), (5, 10),
                        (6, 6),

                        (18, 1), (18, 3),
                        (19, 6), (19, 8);

INSERT INTO event_athletes (event_id, athlete_id) VALUES
                          (7, 10), (7, 11),
                          (8, 12), (8, 13), (8, 14), (8, 15),
                          (9, 16), (9, 17),

                          (10, 18), (10, 19),
                          (11, 20), (11, 21),
                          (12, 22), (12, 23),

                          (13, 24), (13, 25),
                          (14, 26), (14, 27),
                          (15, 28), (15, 29),
                          (16, 30), (16, 1),
                          (17, 2), (17, 3),

                          (20, 10), (20, 12), (20, 14), (20, 16);

INSERT INTO athlete_disciplines (athlete_id, discipline_id) VALUES
                (24, 1),
                (25, 1),
                (26, 2),
                (27, 2),
                (28, 3),
                (29, 4),
                (30, 5),
                (1, 1),
                (2, 3),
                (3, 4),
                (18, 6),
                (19, 7),
                (20, 7),
                (21, 8),
                (22, 6),
                (23, 8),
                (10, 9),
                (11, 9),
                (12, 10),
                (13, 10),
                (14, 9),
                (15, 10);

INSERT INTO account_type (account_type_name) VALUES
             ('Admin'),
             ('User public'),
             ('Super Admin'),
             ('User private'),
             ('user closed');

INSERT INTO app_user (app_user_name, app_user_first_name, app_user_pseudo, app_user_email, app_user_password, app_user_phone, created_date, last_modified_date, account_type_id) VALUES
                 ('Dupont', 'Jean', 'jdupont', 'jean.dupont@mail.com', 'password', '0600000001', now(), now(), 2),
                 ('Martin', 'Claire', 'cmartin', 'claire.martin@mail.com', 'password', '0600000002', now(), now(), 2),
                 ('Bernard', 'Luc', 'lbernard', 'luc.bernard@mail.com', 'password', '0600000003', now(), now(), 2),
                 ('Petit', 'Sophie', 'spetit', 'sophie.petit@mail.com', 'password', '0600000004', now(), now(), 2),
                 ('Robert', 'Hugo', 'hrobert', 'hugo.robert@mail.com', 'password', '0600000005', now(), now(), 2),
                 ('Moreau', 'Emma', 'emmoreau', 'emma.moreau@mail.com', 'password', '0600000006', now(), now(), 2),
                 ('Fischer', 'Karl', 'kfischer', 'karl.fischer@mail.com', 'password', '0600000007', now(), now(), 2),
                 ('Schmidt', 'Anna', 'aschmidt', 'anna.schmidt@mail.com', 'password', '0600000008', now(), now(), 2),
                 ('Lopez', 'Carlos', 'clopez', 'carlos.lopez@mail.com', 'password', '0600000009', now(), now(), 2),
                 ('Gomez', 'Maria', 'mgomez', 'maria.gomez@mail.com', 'password', '0600000010', now(), now(), 2),
                 ('Rossi', 'Marco', 'mrossi', 'marco.rossi@mail.com', 'password', '0600000011', now(), now(), 2),
                 ('Bianchi', 'Luca', 'lbianchi', 'luca.bianchi@mail.com', 'password', '0600000012', now(), now(), 2),
                 ('Smith', 'Emily', 'esmith', 'emily.smith@mail.com', 'password', '0600000013', now(), now(), 2),
                 ('Johnson', 'David', 'djohnson', 'david.johnson@mail.com', 'password', '0600000014', now(), now(), 2),
                 ('Brown', 'Sarah', 'sbrown', 'sarah.brown@mail.com', 'password', '0600000015', now(), now(), 2),
                 ('Wilson', 'Jack', 'jwilson', 'jack.wilson@mail.com', 'password', '0600000016', now(), now(), 2),
                 ('Miller', 'Ava', 'amiller', 'ava.miller@mail.com', 'password', '0600000017', now(), now(), 2),
                 ('Anderson', 'Noah', 'nanderson', 'noah.anderson@mail.com', 'password', '0600000018', now(), now(), 2),
                 ('Thompson', 'Lily', 'lthompson', 'lily.thompson@mail.com', 'password', '0600000019', now(), now(), 2),
                 ('Campbell', 'Oliver', 'ocampbell', 'oliver.campbell@mail.com', 'password', '0600000020', now(), now(), 2);


INSERT INTO relation (first_user_id, second_user_id, relation_status) VALUES
                      (1, 2, 'accepted'),
                      (1, 3, 'accepted'),
                      (2, 4, 'pending'),
                      (3, 5, 'accepted'),
                      (6, 7, 'rejected'),
                      (8, 9, 'accepted'),
                      (10, 11, 'pending'),
                      (12, 13, 'accepted'),
                      (14, 15, 'accepted'),
                      (16, 17, 'pending');


INSERT INTO vote (user_id, event_id, athlete_id, vote_value) VALUES
                     (1, 1, 1, 5),
                     (4, 2, 7, 4),
                     (5, 2, 8, 3),
                     (7, 4, 16, 5),
                     (9, 5, 22, 4),
                     (10, 6, 16, 5),
                     (11, 7, 10, 4),
                     (13, 8, 12, 5),
                     (15, 10, 18, 3),
                     (16, 11, 20, 4),
                     (18, 13, 24, 5),
                     (19, 14, 26, 4);


INSERT INTO status_presence (status_presence_name) VALUES
            ('Présent'),
            ('Absent'),
            ('En attente');

INSERT INTO reservation (status_presence_id, created_at, event_id, app_user_id) VALUES
                (1, now(), 1, 1),
                (2, now(), 1, 2),
                (3, now(), 1, 3),
                (1, now(), 2, 4),
                (1, now(), 2, 5),
                (3, now(), 3, 6),
                (1, now(), 4, 7),
                (2, now(), 4, 8),
                (1, now(), 5, 9),
                (1, now(), 6, 10),
                (1, now(), 7, 11),
                (3, now(), 7, 12),
                (1, now(), 8, 13),
                (2, now(), 9, 14),
                (1, now(), 10, 15),
                (1, now(), 11, 16),
                (3, now(), 12, 17),
                (1, now(), 13, 18),
                (1, now(), 14, 19),
                (2, now(), 15, 20);


INSERT INTO platform (platform_name) VALUES
            ('Nord'),
            ('Sud'),
            ('Est'),
            ('Ouest');

INSERT INTO Level (level_name,platform_id) VALUES
            ('HautNord',1),
            ('MilieuNord',1),
            ('BasNord',1),
            ('HautSud',2),
            ('MilieuSud',2),
            ('BasSud',2),
            ('HautEst',3),
            ('MilieuEst',3),
            ('BasEst',3),
            ('HautOuest',4),
            ('MilieuOuest',4),
            ('BasOuest',4);

INSERT INTO seat (seat_number, level_id, reservation_id) VALUES
            ('A1', 1, 1),
            ('A2', 1, 1),
            ('B1', 2, 4),
            ('B2', 2, 4),
            ('B3', 2, 5),
            ('B4', 2, 5),
            ('C1', 3, 7),
            ('C2', 3, 7),
            ('D1', 4, 9),
            ('D2', 4, 9),
            ('E1', 5, 10),
            ('E2', 5, 10),
            ('F1', 6, 11),
            ('F2', 6, 11),
            ('G1', 7, 13),
            ('G2', 7, 13),
            ('H1', 8, 15),
            ('H2', 8, 15),
            ('I1', 9, 16),
            ('I2', 9, 16),
            ('J1', 10, 18),
            ('J2', 10, 18),
            ('K1', 11, 19),
            ('K2', 11, 19),
            ('L1', 12, 20),
            ('L2', 12, 20),
            ('M1', 1, null), ('M2', 1, null),
            ('N1', 2, null), ('N2', 2, null),
            ('O1', 3, null), ('O2', 3, null),
            ('P1', 4, null), ('P2', 4, null),
            ('Q1', 5, null), ('Q2', 5, null),
            ('R1', 6, null), ('R2', 6, null),
            ('S1', 7, null), ('S2', 7, null),
            ('T1', 8, null), ('T2', 8, null),
            ('U1', 9, null), ('U2', 9, null),
            ('V1', 10, null), ('V2', 10, null),
            ('W1', 11, null), ('W2', 11, null),
            ('X1', 12, null), ('X2', 12, null);
