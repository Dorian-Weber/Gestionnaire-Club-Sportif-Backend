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
                    ('Match amical FC Metz vs Nancy', 'Rencontre amicale entre deux clubs lorrains.', '2027-03-12 18:00:00', 1, 1),
                    ('Tournoi régional U18', 'Tournoi de jeunes équipes locales.', '2026-04-05 14:00:00', 2, 1),
                    ('Entraînement intensif FC Metz', 'Séance technique et physique.', '2026-05-02 10:00:00', 4, 1),
                    ('Match Basket Metz vs Strasbourg', 'Match de championnat régional.', '2026-03-20 20:00:00', 1, 2),
                    ('Tournoi 3v3 Metz Centre', 'Tournoi urbain de basket 3 contre 3.', '2026-06-11 15:00:00', 2, 2),
                    ('Entraînement tactique Basket Metz', 'Séance axée sur les systèmes offensifs.', '2026-04-18 09:00:00', 4, 2),
                    ('Open de Metz – Simple', 'Match de simple du tournoi local.', '2027-05-22 16:00:00', 3, 3),
                    ('Open de Metz – Double', 'Match de double du tournoi local.', '2027-05-23 14:00:00', 3, 3),
                    ('Entraînement Tennis – Service', 'Séance dédiée au service.', '2027-04-10 11:00:00', 4, 3),
                    ('Compétition 100m Papillon', 'Finale départementale.', '2027-07-02 10:00:00', 3, 4),
                    ('Compétition 200m Nage libre', 'Épreuve régionale.', '2027-07-03 11:00:00', 3, 4),
                    ('Entraînement Natation – Endurance', 'Séance longue distance.', '2027-04-08 08:00:00', 4, 4),
                    ('Meeting Metz – 100m', 'Course de sprint.', '2027-06-15 14:00:00', 3, 5),
                    ('Meeting Metz – 200m', 'Course de demi-fond rapide.', '2027-06-15 15:00:00', 3, 5),
                    ('Meeting Metz – Saut en hauteur', 'Concours de saut.', '2027-06-16 10:00:00', 3, 5),
                    ('Meeting Metz – Saut en longueur', 'Concours de saut.', '2027-06-16 11:00:00', 3, 5),
                    ('Meeting Metz – Javelot', 'Concours de lancer.', '2027-06-17 09:00:00', 3, 5),
                    ('Exhibition Football – Stars Lorraines', 'Match caritatif.', '2027-09-01 18:00:00', 5, 1),
                    ('Exhibition Basket – Metz Legends', 'Match de gala.', '2027-09-10 19:00:00', 5, 2),
                    ('Exhibition Tennis – Duo Show', 'Démonstration de double.', '2027-09-15 17:00:00', 5, 3);

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
                    ('Garcia', 'Miguel', '1994-04-12', 3);

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
             ('ADMIN'),
             ('SUPER_ADMIN'),
             ('USER');

-- MDP : RootRoot!1
INSERT INTO app_user (app_user_name, app_user_first_name, app_user_pseudo, app_user_email, app_user_password, app_user_phone,app_user_visibility, created_date, last_modified_date, account_type_id) VALUES
                 ('Dupont', 'Jean', 'jdupont', 'jean.dupont@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000001','PRIVATE', now(), now(), 3),
                 ('Martin', 'Claire', 'cmartin', 'claire.martin@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000002','PRIVATE', now(), now(), 1),
                 ('Bernard', 'Luc', 'lbernard', 'luc.bernard@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000003','PRIVATE', now(), now(), 2),
                 ('Petit', 'Sophie', 'spetit', 'sophie.petit@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000004','PRIVATE', now(), now(), 3),
                 ('Robert', 'Hugo', 'hrobert', 'hugo.robert@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000005','PRIVATE', now(), now(), 3),
                 ('Moreau', 'Emma', 'emmoreau', 'emma.moreau@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000006','PRIVATE', now(), now(), 3),
                 ('Fischer', 'Karl', 'kfischer', 'karl.fischer@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000007','PRIVATE', now(), now(), 3),
                 ('Schmidt', 'Anna', 'aschmidt', 'anna.schmidt@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000008','PRIVATE', now(), now(), 3),
                 ('Lopez', 'Carlos', 'clopez', 'carlos.lopez@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000009','PRIVATE', now(), now(), 3),
                 ('Gomez', 'Maria', 'mgomez', 'maria.gomez@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000010','PRIVATE', now(), now(), 3),
                 ('Rossi', 'Marco', 'mrossi', 'marco.rossi@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000011','PRIVATE', now(), now(), 3),
                 ('Bianchi', 'Luca', 'lbianchi', 'luca.bianchi@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000012','PRIVATE', now(), now(), 3),
                 ('Smith', 'Emily', 'esmith', 'emily.smith@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000013','PRIVATE', now(), now(), 3),
                 ('Johnson', 'David', 'djohnson', 'david.johnson@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000014','PRIVATE', now(), now(), 3),
                 ('Brown', 'Sarah', 'sbrown', 'sarah.brown@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000015','PRIVATE', now(), now(), 3),
                 ('Wilson', 'Jack', 'jwilson', 'jack.wilson@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000016','PRIVATE', now(), now(), 3),
                 ('Miller', 'Ava', 'amiller', 'ava.miller@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000017','PRIVATE', now(), now(), 3),
                 ('Anderson', 'Noah', 'nanderson', 'noah.anderson@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000018','PRIVATE', now(), now(), 3),
                 ('Thompson', 'Lily', 'lthompson', 'lily.thompson@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000019','PRIVATE', now(), now(), 3),
                 ('Campbell', 'Oliver', 'ocampbell', 'oliver.campbell@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000020','PRIVATE', now(), now(), 3),
                 ('Durand', 'Paul', 'pdurand', 'paul.durand@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000021','PRIVATE', now(), now(), 3),
                 ('Leroy', 'Camille', 'cleroy', 'camille.leroy@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000022','PRIVATE', now(), now(), 3),
                 ('Faure', 'Mathieu', 'mfaure', 'mathieu.faure@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000023','PRIVATE', now(), now(), 3),
                 ('Gauthier', 'Julie', 'jgauthier', 'julie.gauthier@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000024','PRIVATE', now(), now(), 3),
                 ('Leclerc', 'Antoine', 'aleclerc', 'antoine.leclerc@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000025','PRIVATE', now(), now(), 3),
                 ('Morel', 'Chloe', 'cmorel', 'chloe.morel@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000026','PRIVATE', now(), now(), 3),
                 ('Girard', 'Thomas', 'tgirard', 'thomas.girard@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000027','PRIVATE', now(), now(), 3),
                 ('Perrin', 'Laura', 'lperrin', 'laura.perrin@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000028','PRIVATE', now(), now(), 3),
                 ('Renaud', 'Nicolas', 'nrenaud', 'nicolas.renaud@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000029','PRIVATE', now(), now(), 3),
                 ('Lemoine', 'Sophie', 'slemoine', 'sophie.lemoine@mail.com', '$2a$10$GcfxgrA73G2trpiQ5lNKTea3l7B/.31LdSi/2TqGeK7BtW1pLJ1Su', '0600000030','PRIVATE', now(), now(), 3);


INSERT INTO relation (first_user_id, second_user_id, relation_status) VALUES
          (1, 2, 'ACCEPTED'), (2, 3, 'PENDING'),
          (3, 4, 'REJECTED'), (4, 5, 'ACCEPTED'),
          (5, 6, 'PENDING'),  (6, 7, 'REJECTED'),
          (7, 8, 'ACCEPTED'), (8, 9, 'PENDING'),
          (9, 10, 'REJECTED'), (10, 11, 'ACCEPTED'),
          (11, 12, 'PENDING'), (12, 13, 'REJECTED'),
          (13, 14, 'ACCEPTED'), (14, 15, 'PENDING'),
          (15, 16, 'REJECTED'), (16, 17, 'ACCEPTED'),
          (17, 18, 'PENDING'),  (18, 19, 'REJECTED'),
          (19, 20, 'ACCEPTED'), (20, 21, 'PENDING'),
          (21, 22, 'REJECTED'), (22, 23, 'ACCEPTED'),
          (23, 24, 'PENDING'),  (24, 25, 'REJECTED'),
          (25, 26, 'ACCEPTED'), (26, 27, 'PENDING'),
          (27, 28, 'REJECTED'), (28, 29, 'ACCEPTED'),
          (29, 30, 'PENDING'),  (30, 1, 'REJECTED'),
          (1, 4, 'ACCEPTED'),  (2, 5, 'ACCEPTED'),
          (3, 6, 'PENDING'),  (4, 7, 'ACCEPTED'),
          (5, 8, 'ACCEPTED'), (6, 9, 'PENDING'),
          (7, 10, 'ACCEPTED'), (8, 11, 'ACCEPTED'),
          (9, 12, 'PENDING'),  (10, 13, 'ACCEPTED'),
          (11, 14, 'ACCEPTED'), (12, 15, 'PENDING'),
          (13, 16, 'ACCEPTED'), (14, 17, 'ACCEPTED'),
          (15, 18, 'PENDING'), (16, 19, 'ACCEPTED'),
          (17, 20, 'ACCEPTED'), (18, 21, 'PENDING'),
          (19, 22, 'ACCEPTED'), (20, 23, 'ACCEPTED'),
          (21, 24, 'PENDING'), (22, 25, 'ACCEPTED'),
          (23, 26, 'ACCEPTED'), (24, 27, 'PENDING'),
          (25, 28, 'ACCEPTED'), (26, 29, 'ACCEPTED'),
          (27, 30, 'PENDING'), (28, 1, 'ACCEPTED'),
          (29, 2, 'ACCEPTED'), (30, 3, 'PENDING');



INSERT INTO vote (event_rating, user_id, event_id, athlete_id) VALUES
                     (4,1, 2, 7),
                     (3,1, 4,16),
                     (2,1,6, 16),
                     (1,4, 2, 7),
                     (2,5, 2, 8),
                     (1,7, 4, 16),
                     (2,9, 5, 22),
                     (4,10, 6, 16),
                     (5,11, 7, 10),
                     (1,13, 8, 12),
                     (3,15, 10, 18),
                     (2,16, 11, 20),
                     (1,18, 13, 24),
                     (5,19, 14, 26);


INSERT INTO status_presence (status_presence_name) VALUES
            ('Présent'),
            ('Absent'),
            ('En attente');

INSERT INTO reservation (status_presence_id, created_at, event_id, app_user_id) VALUES
-- Event 1 (users 2,4,...,30)
(3, now(), 1, 2), (3, now(), 1, 4), (3, now(), 1, 6), (3, now(), 1, 8), (3, now(), 1, 10),
(3, now(), 1, 12), (3, now(), 1, 14), (3, now(), 1, 16), (3, now(), 1, 18), (3, now(), 1, 20),
(3, now(), 1, 22), (3, now(), 1, 24), (3, now(), 1, 26), (3, now(), 1, 28), (3, now(), 1, 30),

-- Event 2 (users 1,3,...,29)
(1, now(), 2, 1), (2, now(), 2, 3), (1, now(), 2, 5), (2, now(), 2, 7), (1, now(), 2, 9),
(1, now(), 2, 11), (2, now(), 2, 13), (1, now(), 2, 15), (1, now(), 2, 17), (2, now(), 2, 19),
(1, now(), 2, 21), (2, now(), 2, 23), (1, now(), 2, 25), (1, now(), 2, 27), (1, now(), 2, 29),

-- Event 3
(1, now(), 3, 2), (2, now(), 3, 4), (1, now(), 3, 6), (1, now(), 3, 8), (1, now(), 3, 10),
(1, now(), 3, 12), (1, now(), 3, 14), (1, now(), 3, 16), (2, now(), 3, 18), (2, now(), 3, 20),
(1, now(), 3, 22), (2, now(), 3, 24), (2, now(), 3, 26), (1, now(), 3, 28), (1, now(), 3, 30),

-- Event 4
(1, now(), 4, 1), (1, now(), 4, 3), (2, now(), 4, 5), (1, now(), 4, 7), (1, now(), 4, 9),
(2, now(), 4, 11), (1, now(), 4, 13), (1, now(), 4, 15), (2, now(), 4, 17), (1, now(), 4, 19),
(1, now(), 4, 21), (1, now(), 4, 23), (1, now(), 4, 25), (1, now(), 4, 27), (1, now(), 4, 29),

-- Event 5
(2, now(), 5, 2), (1, now(), 5, 4), (1, now(), 5, 6), (1, now(), 5, 8), (2, now(), 5, 10),
(1, now(), 5, 12), (1, now(), 5, 14), (1, now(), 5, 16), (1, now(), 5, 18), (1, now(), 5, 20),
(1, now(), 5, 22), (2, now(), 5, 24), (1, now(), 5, 26), (2, now(), 5, 28), (2, now(), 5, 30),

-- Event 6
(1, now(), 6, 1), (1, now(), 6, 3), (2, now(), 6, 5), (1, now(), 6, 7), (1, now(), 6, 9),
(2, now(), 6, 11), (1, now(), 6, 13), (1, now(), 6, 15), (1, now(), 6, 17), (1, now(), 6, 19),
(1, now(), 6, 21), (1, now(), 6, 23), (1, now(), 6, 25), (1, now(), 6, 27), (2, now(), 6, 29),

-- Event 7
(3, now(), 7, 2), (3, now(), 7, 4), (3, now(), 7, 6), (3, now(), 7, 8), (3, now(), 7, 10),
(3, now(), 7, 12), (3, now(), 7, 14), (3, now(), 7, 16), (3, now(), 7, 18), (3, now(), 7, 20),
(3, now(), 7, 22), (3, now(), 7, 24), (3, now(), 7, 26), (3, now(), 7, 28), (3, now(), 7, 30),

-- Event 8
(3, now(), 8, 1), (3, now(), 8, 3), (3, now(), 8, 5), (3, now(), 8, 7), (3, now(), 8, 9),
(3, now(), 8, 11), (3, now(), 8, 13), (3, now(), 8, 15), (3, now(), 8, 17), (3, now(), 8, 19),
(3, now(), 8, 21), (3, now(), 8, 23), (3, now(), 8, 25), (3, now(), 8, 27), (3, now(), 8, 29),

-- Event 9
(3, now(), 9, 2), (3, now(), 9, 4), (3, now(), 9, 6), (3, now(), 9, 8), (3, now(), 9, 10),
(3, now(), 9, 12), (3, now(), 9, 14), (3, now(), 9, 16), (3, now(), 9, 18), (3, now(), 9, 20),
(3, now(), 9, 22), (3, now(), 9, 24), (3, now(), 9, 26), (3, now(), 9, 28), (3, now(), 9, 30),

-- Event 10
(3, now(), 10, 1), (3, now(), 10, 3), (3, now(), 10, 5), (3, now(), 10, 7), (3, now(), 10, 9),
(3, now(), 10, 11), (3, now(), 10, 13), (3, now(), 10, 15), (3, now(), 10, 17), (3, now(), 10, 19),
(3, now(), 10, 21), (3, now(), 10, 23), (3, now(), 10, 25), (3, now(), 10, 27), (3, now(), 10, 29),

-- Event 11
(3, now(), 11, 2), (3, now(), 11, 4), (3, now(), 11, 6), (3, now(), 11, 8), (3, now(), 11, 10),
(3, now(), 11, 12), (3, now(), 11, 14), (3, now(), 11, 16), (3, now(), 11, 18), (3, now(), 11, 20),
(3, now(), 11, 22), (3, now(), 11, 24), (3, now(), 11, 26), (3, now(), 11, 28), (3, now(), 11, 30),

-- Event 12
(3, now(), 12, 1), (3, now(), 12, 3), (3, now(), 12, 5), (3, now(), 12, 7), (3, now(), 12, 9),
(3, now(), 12, 11), (3, now(), 12, 13), (3, now(), 12, 15), (3, now(), 12, 17), (3, now(), 12, 19),
(3, now(), 12, 21), (3, now(), 12, 23), (3, now(), 12, 25), (3, now(), 12, 27), (3, now(), 12, 29),

-- Event 13
(3, now(), 13, 2), (3, now(), 13, 4), (3, now(), 13, 6), (3, now(), 13, 8), (3, now(), 13, 10),
(3, now(), 13, 12), (3, now(), 13, 14), (3, now(), 13, 16), (3, now(), 13, 18), (3, now(), 13, 20),
(3, now(), 13, 22), (3, now(), 13, 24), (3, now(), 13, 26), (3, now(), 13, 28), (3, now(), 13, 30),

-- Event 14
(3, now(), 14, 1), (3, now(), 14, 3), (3, now(), 14, 5), (3, now(), 14, 7), (3, now(), 14, 9),
(3, now(), 14, 11), (3, now(), 14, 13), (3, now(), 14, 15), (3, now(), 14, 17), (3, now(), 14, 19),
(3, now(), 14, 21), (3, now(), 14, 23), (3, now(), 14, 25), (3, now(), 14, 27), (3, now(), 14, 29),

-- Event 15
(3, now(), 15, 2), (3, now(), 15, 4), (3, now(), 15, 6), (3, now(), 15, 8), (3, now(), 15, 10),
(3, now(), 15, 12), (3, now(), 15, 14), (3, now(), 15, 16), (3, now(), 15, 18), (3, now(), 15, 20),
(3, now(), 15, 22), (3, now(), 15, 24), (3, now(), 15, 26), (3, now(), 15, 28), (3, now(), 15, 30),

-- Event 16
(3, now(), 16, 1), (3, now(), 16, 3), (3, now(), 16, 5), (3, now(), 16, 7), (3, now(), 16, 9),
(3, now(), 16, 11), (3, now(), 16, 13), (3, now(), 16, 15), (3, now(), 16, 17), (3, now(), 16, 19),
(3, now(), 16, 21), (3, now(), 16, 23), (3, now(), 16, 25), (3, now(), 16, 27), (3, now(), 16, 29),

-- Event 17
(3, now(), 17, 2), (3, now(), 17, 4), (3, now(), 17, 6), (3, now(), 17, 8), (3, now(), 17, 10),
(3, now(), 17, 12), (3, now(), 17, 14), (3, now(), 17, 16), (3, now(), 17, 18), (3, now(), 17, 20),
(3, now(), 17, 22), (3, now(), 17, 24), (3, now(), 17, 26), (3, now(), 17, 28), (3, now(), 17, 30),

-- Event 18
(3, now(), 18, 1), (3, now(), 18, 3), (3, now(), 18, 5), (3, now(), 18, 7), (3, now(), 18, 9),
(3, now(), 18, 11), (3, now(), 18, 13), (3, now(), 18, 15), (3, now(), 18, 17), (3, now(), 18, 19),
(3, now(), 18, 21), (3, now(), 18, 23), (3, now(), 18, 25), (3, now(), 18, 27), (3, now(), 18, 29),

-- Event 19
(3, now(), 19, 2), (3, now(), 19, 4), (3, now(), 19, 6), (3, now(), 19, 8), (3, now(), 19, 10),
(3, now(), 19, 12), (3, now(), 19, 14), (3, now(), 19, 16), (3, now(), 19, 18), (3, now(), 19, 20),
(3, now(), 19, 22), (3, now(), 19, 24), (3, now(), 19, 26), (3, now(), 19, 28), (3, now(), 19, 30),

-- Event 20
(3, now(), 20, 1), (3, now(), 20, 3), (3, now(), 20, 5), (3, now(), 20, 7), (3, now(), 20, 9),
(3, now(), 20, 11), (3, now(), 20, 13), (3, now(), 20, 15), (3, now(), 20, 17), (3, now(), 20, 19),
(3, now(), 20, 21), (3, now(), 20, 23), (3, now(), 20, 25), (3, now(), 20, 27), (3, now(), 20, 29);



INSERT INTO platform (platform_name) VALUES
            ('Nord'),
            ('Sud'),
            ('Est'),
            ('Ouest');

INSERT INTO Level (level_name,platform_id) VALUES
            ('Haut',1),
            ('Milieu',1),
            ('Bas',1),
            ('Haut',2),
            ('Milieu',2),
            ('Bas',2),
            ('Haut',3),
            ('Milieu',3),
            ('Bas',3),
            ('Haut',4),
            ('Milieu',4),
            ('Bas',4);

INSERT INTO seat (seat_number, level_id) VALUES
-- Niveau 1 : A1 à A20
('A1', 1), ('A2', 1), ('A3', 1), ('A4', 1), ('A5', 1),
('A6', 1), ('A7', 1), ('A8', 1), ('A9', 1), ('A10', 1),
('A11', 1), ('A12', 1), ('A13', 1), ('A14', 1), ('A15', 1),
('A16', 1), ('A17', 1), ('A18', 1), ('A19', 1), ('A20', 1),

-- Niveau 2 : B1 à B20
('B1', 2), ('B2', 2), ('B3', 2), ('B4', 2), ('B5', 2),
('B6', 2), ('B7', 2), ('B8', 2), ('B9', 2), ('B10', 2),
('B11', 2), ('B12', 2), ('B13', 2), ('B14', 2), ('B15', 2),
('B16', 2), ('B17', 2), ('B18', 2), ('B19', 2), ('B20', 2),

-- Niveau 3 : C1 à C20
('C1', 3), ('C2', 3), ('C3', 3), ('C4', 3), ('C5', 3),
('C6', 3), ('C7', 3), ('C8', 3), ('C9', 3), ('C10', 3),
('C11', 3), ('C12', 3), ('C13', 3), ('C14', 3), ('C15', 3),
('C16', 3), ('C17', 3), ('C18', 3), ('C19', 3), ('C20', 3),

-- Niveau 4 : D1 à D20
('D1', 4), ('D2', 4), ('D3', 4), ('D4', 4), ('D5', 4),
('D6', 4), ('D7', 4), ('D8', 4), ('D9', 4), ('D10', 4),
('D11', 4), ('D12', 4), ('D13', 4), ('D14', 4), ('D15', 4),
('D16', 4), ('D17', 4), ('D18', 4), ('D19', 4), ('D20', 4),

-- Niveau 5 : E1 à E20
('E1', 5), ('E2', 5), ('E3', 5), ('E4', 5), ('E5', 5),
('E6', 5), ('E7', 5), ('E8', 5), ('E9', 5), ('E10', 5),
('E11', 5), ('E12', 5), ('E13', 5), ('E14', 5), ('E15', 5),
('E16', 5), ('E17', 5), ('E18', 5), ('E19', 5), ('E20', 5),

-- Niveau 6 : F1 à F20
('F1', 6), ('F2', 6), ('F3', 6), ('F4', 6), ('F5', 6),
('F6', 6), ('F7', 6), ('F8', 6), ('F9', 6), ('F10', 6),
('F11', 6), ('F12', 6), ('F13', 6), ('F14', 6), ('F15', 6),
('F16', 6), ('F17', 6), ('F18', 6), ('F19', 6), ('F20', 6),

-- Niveau 7 : G1 à G20
('G1', 7), ('G2', 7), ('G3', 7), ('G4', 7), ('G5', 7),
('G6', 7), ('G7', 7), ('G8', 7), ('G9', 7), ('G10', 7),
('G11', 7), ('G12', 7), ('G13', 7), ('G14', 7), ('G15', 7),
('G16', 7), ('G17', 7), ('G18', 7), ('G19', 7), ('G20', 7),

-- Niveau 8 : H1 à H20
('H1', 8), ('H2', 8), ('H3', 8), ('H4', 8), ('H5', 8),
('H6', 8), ('H7', 8), ('H8', 8), ('H9', 8), ('H10', 8),
('H11', 8), ('H12', 8), ('H13', 8), ('H14', 8), ('H15', 8),
('H16', 8), ('H17', 8), ('H18', 8), ('H19', 8), ('H20', 8),

-- Niveau 9 : I1 à I20
('I1', 9), ('I2', 9), ('I3', 9), ('I4', 9), ('I5', 9),
('I6', 9), ('I7', 9), ('I8', 9), ('I9', 9), ('I10', 9),
('I11', 9), ('I12', 9), ('I13', 9), ('I14', 9), ('I15', 9),
('I16', 9), ('I17', 9), ('I18', 9), ('I19', 9), ('I20', 9),

-- Niveau 10 : J1 à J20
('J1', 10), ('J2', 10), ('J3', 10), ('J4', 10), ('J5', 10),
('J6', 10), ('J7', 10), ('J8', 10), ('J9', 10), ('J10', 10),
('J11', 10), ('J12', 10), ('J13', 10), ('J14', 10), ('J15', 10),
('J16', 10), ('J17', 10), ('J18', 10), ('J19', 10), ('J20', 10),

-- Niveau 11 : K1 à K20
('K1', 11), ('K2', 11), ('K3', 11), ('K4', 11), ('K5', 11),
('K6', 11), ('K7', 11), ('K8', 11), ('K9', 11), ('K10', 11),
('K11', 11), ('K12', 11), ('K13', 11), ('K14', 11), ('K15', 11),
('K16', 11), ('K17', 11), ('K18', 11), ('K19', 11), ('K20', 11),

-- Niveau 12 : L1 à L20
('L1', 12), ('L2', 12), ('L3', 12), ('L4', 12), ('L5', 12),
('L6', 12), ('L7', 12), ('L8', 12), ('L9', 12), ('L10', 12),
('L11', 12), ('L12', 12), ('L13', 12), ('L14', 12), ('L15', 12),
('L16', 12), ('L17', 12), ('L18', 12), ('L19', 12), ('L20', 12);


INSERT INTO reservation_seat (reservation_id, seat_id) VALUES
        --Event 1
    (1, 57), (1, 58), (2, 143),
    (3, 12), (3, 13), (4, 199),
    (5, 84), (5, 85), (6, 221),
    (7, 37), (7, 38), (8, 166),
    (9, 5), (9, 6), (10, 118),
    (11, 240), (11, 1), (12, 92),
    (13, 173), (13, 174),   (14, 33),
    (15, 109), (15, 110),

    --Event 2
    (16, 142), (16, 143), (17, 58),
    (18, 201), (18, 202), (19, 17),
    (20, 233), (20, 234), (21, 119),
    (22, 87), (22, 88),  (23, 12),
    (24, 178), (24, 179), (25, 95),
    (26, 221), (26, 222), (27, 44),
    (28, 153), (28, 154), (29, 7),
    (30, 64), (30, 65),

    --Event 3
    (31, 134), (31, 135), (32, 17),
    (33, 202), (33, 203), (34, 89),
    (35, 41), (35, 42), (36, 176),
    (37, 228), (37, 229), (38, 63),
    (39, 154), (39, 155), (40, 7),
    (41, 118), (41, 119), (42, 213),
    (43, 96), (43, 97), (44, 239),
    (45, 52), (45, 53),

    --Event 4
    (46, 131), (46, 132), (47, 24),
    (48, 207), (48, 208), (49, 73),
    (50, 159), (50, 160), (51, 11),
    (52, 182), (52, 183), (53, 56),
    (54, 98), (54, 99), (55, 219),
    (56, 145), (56, 146), (57, 34),
    (58, 237), (58, 238), (59, 121),
    (60, 68), (60, 69),

    --Event 5
    (61, 142), (61, 143), (62, 27),
    (63, 188), (63, 189), (64, 76),
    (65, 231), (65, 232), (66, 14),
    (67, 97), (67, 98), (68, 205),
    (69, 53), (69, 54), (70, 167),
    (71, 120), (71, 121), (72, 239),
    (73, 34), (73, 35), (74, 101),
    (75, 179), (75, 180),

    --Event 6
    (76, 141), (76, 142), (77, 33),
    (78, 214), (78, 215), (79, 87),
    (80, 12), (80, 13), (81, 173),
    (82, 59), (82, 60), (83, 238),
    (84, 104), (84, 105), (85, 191),
    (86, 47), (86, 48), (87, 226),
    (88, 162), (88, 163), (89, 8),
    (90, 116), (90, 117),

    --Event 7
    (91, 147), (91, 148), (92, 36),
    (93, 214), (93, 215), (94, 82),
    (95, 11), (95, 12), (96, 173),
    (97, 59), (97, 60), (98, 239),
    (99, 104), (99, 105), (100, 191),
    (101, 47), (101, 48), (102, 226),
    (103, 162), (103, 163), (104, 8),
    (105, 116), (105, 117),

    --Event 8
    (106, 138), (106, 139), (107, 42),
    (108, 217), (108, 218), (109, 91),
    (110, 14), (110, 15), (111, 184),
    (112, 63), (112, 64), (113, 236),
    (114, 107), (114, 108), (115, 199),
    (116, 28), (116, 29), (117, 152),
    (118, 171), (118, 172), (119, 6),
    (120, 122), (120, 123),

    --Event 9
    (121, 144), (121, 145), (122, 31),
    (123, 207), (123, 208), (124, 89),
    (125, 11), (125, 12), (126, 176),
    (127, 58), (127, 59), (128, 233),
    (129, 104), (129, 105), (130, 192),
    (131, 47), (131, 48), (132, 221),
    (133, 163), (133, 164), (134, 6),
    (135, 118), (135, 119),

    --Event 10
    (136, 157), (136, 158), (137, 44),
    (138, 211), (138, 212), (139, 93),
    (140, 19), (140, 20), (141, 184),
    (142, 71), (142, 72), (143, 237),
    (144, 129), (144, 130), (145, 203),
    (146, 52), (146, 53), (147, 168),
    (148, 115), (148, 116), (149, 7),
    (150, 141), (150, 142),

    --Event 11
    (151, 163), (151, 164), (152, 22),
    (153, 209), (153, 210), (154, 94),
    (155, 14), (155, 15), (156, 178),
    (157, 61), (157, 62), (158, 236),
    (159, 132), (159, 133), (160, 203),
    (161, 49), (161, 50), (162, 171),
    (163, 107), (163, 108), (164, 7),
    (165, 145), (165, 146),

    --Event 12
    (166, 154), (166, 155), (167, 41),
    (168, 219), (168, 220), (169, 88),
    (170, 16), (170, 17), (171, 182),
    (172, 67), (172, 68), (173, 238),
    (174, 129), (174, 130), (175, 204),
    (176, 52), (176, 53), (177, 171),
    (178, 106), (178, 107), (179, 9),
    (180, 143), (180, 144),

    --Event 13
    (181, 167), (181, 168), (182, 43),
    (183, 214), (183, 215), (184, 92),
    (185, 28), (185, 29), (186, 183),
    (187, 74), (187, 75), (188, 239),
    (189, 131), (189, 132), (190, 204),
    (191, 56), (191, 57), (192, 172),
    (193, 109), (193, 110), (194, 8),
    (195, 146), (195, 147),

    --Event 14
    (196, 158), (196, 159), (197, 23),
    (198, 213), (198, 214), (199, 91),
    (200, 17), (200, 18), (201, 186),
    (202, 66), (202, 67), (203, 239),
    (204, 128), (204, 129), (205, 204),
    (206, 51), (206, 52), (207, 169),
    (208, 105), (208, 106), (209, 7),
    (210, 142), (210, 143),

    --Event 15
    (211, 166), (211, 167), (212, 39),
    (213, 220), (213, 221), (214, 83),
    (215, 25), (215, 26), (216, 187),
    (217, 72), (217, 73), (218, 238),
    (219, 134), (219, 135), (220, 205),
    (221, 55), (221, 56), (222, 174),
    (223, 111), (223, 112), (224, 10),
    (225, 149), (225, 150),

    --Event 16
    (226, 172), (226, 173), (227, 38),
    (228, 216), (228, 217), (229, 84),
    (230, 13), (230, 14), (231, 193),
    (232, 75), (232, 76), (233, 237),
    (234, 126), (234, 127), (235, 203),
    (236, 48), (236, 49), (237, 165),
    (238, 102), (238, 103), (239, 9),
    (240, 151), (240, 152),

    --Event 17
   (241, 161), (241, 162), (242, 32),
   (243, 210), (243, 211), (244, 86),
   (245, 21), (245, 22), (246, 185),
   (247, 69), (247, 70), (248, 236),
   (249, 133), (249, 134), (250, 206),
   (251, 57), (251, 58), (252, 170),
   (253, 113), (253, 114), (254, 5),
   (255, 148), (255, 149),

    --Event 18
    (256, 159), (256, 160), (257, 35),
    (258, 212), (258, 213), (259, 95),
    (260, 18), (260, 19), (261, 181),
    (262, 64), (262, 65), (263, 238),
    (264, 130), (264, 131), (265, 207),
    (266, 54), (266, 55), (267, 175),
    (268, 108), (268, 109), (269, 6),
    (270, 147), (270, 148),

    --Event 19
    (271, 164), (271, 165), (272, 37),
    (273, 209), (273, 210), (274, 85),
    (275, 26), (275, 27), (276, 188),
    (277, 73), (277, 74), (278, 236),
    (279, 136), (279, 137), (280, 202),
    (281, 58), (281, 59), (282, 176),
    (283, 110), (283, 111), (284, 4),
    (285, 150), (285, 151),

    --Event 20
    (286, 158), (286, 159), (287, 40),
    (288, 218), (288, 219), (289, 87),
    (290, 24), (290, 25), (291, 190),
    (292, 70), (292, 71), (293, 237),
    (294, 128), (294, 129), (295, 203),
    (296, 53), (296, 54), (297, 169),
    (298, 112), (298, 113), (299, 5),
    (300, 144), (300, 145);
