INSERT INTO sport (sport_name) VALUES
              ('Football'),
              ('Basketball'),
              ('Tennis'),
              ('Natation'),
              ('Athlétisme');

INSERT INTO discipline (discipline_name, event_record,world_record, sport_id) VALUES
              ('Saut en hauteur', '2.45 m', '2.45 m',5),
              ('Saut en longueur', '8.95 m', '8.95 m',5),
              ('Lancer de poids', '23.37 m', '23.37 m',5),
              ('Lancer de javelot', '98.48 m', '98.48 m', 5),
              ('Nage libre', '20.91 s', '20.91 s',4),
              ('Papillon', '49.45 s', '49.45 s',4);

INSERT INTO event_type (event_type_name) VALUES
            ('Match'),
            ('Tournoi'),
            ('Compétition'),
            ('Entraînement'),
            ('Exhibition');

INSERT INTO event (event_name, event_description, event_date,event_type_id, sport_id) VALUES
          ('Match de Football', 'Rencontre amicale entre deux équipes locales', '2026-04-15 18:00:00', 1, 1),
          ('Tournoi de Basketball', 'Compétition régionale de basket', '2026-05-10 14:30:00',2, 2),
          ('Course d’Athlétisme', 'Épreuve de sprint 100 mètres', '2026-06-02 09:00:00',3, 5),
          ('Championnat de Tennis', 'Match de qualification pour le championnat national', '2026-07-08 16:00:00',3, 3),
          ('Compétition de Natation', 'Finale départementale de nage libre', '2026-08-21 10:30:00',3, 4);

INSERT INTO country (country_name) VALUES
           ('France'),
           ('Allemagne'),
           ('Espagne'),
           ('Italie'),
           ('États-Unis');

INSERT INTO athlete (athlete_name, athlete_first_name, athlete_birth_date, country_id) VALUES
          ('Dupont', 'Jean', '1990-05-15', 1),
          ('Müller', 'Anna', '1988-11-22', 2),
          ('Garcia', 'Carlos', '1995-03-10', 3),
          ('Rossi', 'Luca', '1992-07-30',4),
          ('Smith', 'Emily', '1993-12-05',5),
          ('Johnson', 'Michael', '1985-09-18',5),
          ('Brown', 'Sarah', '1991-02-25',5),
          ('Davis', 'David', '1987-06-12',5),
          ('Wilson', 'Laura', '1994-10-03',5),
          ('Martinez', 'Sofia', '1996-01-20',5);

INSERT INTO event_athletes (event_id, athlete_id) VALUES
          (4, 2),
          (4, 3),
          (3, 4),
          (5, 5),
          (3, 6),
          (4, 7),
          (5, 8),
          (3, 9);

INSERT INTO team (team_name) VALUES
          ('Les Lions'),
          ('Les Aigles'),
          ('Les Tigres'),
          ('Les Dauphins'),
          ('Les Cheetahs');

INSERT INTO event_teams (event_id, team_id) VALUES
          (1, 1),
          (1, 2),
          (2, 3),
          (2, 4),
          (2, 5);

INSERT INTO team_athletes (team_id, athlete_id) VALUES
          (1, 1),
          (1, 2),
          (2, 3),
          (3, 4),
          (4, 5),
          (5, 6),
          (1, 7),
          (2, 8),
          (3, 9),
          (4, 10);

INSERT INTO athlete_disciplines (athlete_id, discipline_id) VALUES
          (1, 1),
          (1, 2),
          (2, 3),
          (3, 4),
          (4, 5),
          (5, 6);

INSERT INTO account_type (account_type_name) VALUES
                         ('Admin'),
                         ('User public'),
                         ('Super Admin'),
                         ('User private'),
                         ('user closed');

INSERT INTO app_user (app_user_name,app_user_first_name, app_user_pseudo, app_user_email, app_user_password,app_user_phone, created_date, last_modified_date, account_type_id) VALUES
            ('Dupont', 'Jean', 'jdupont', 'cbnezu@dnh.com', 'password', '0601020304', now(), now(), 1),
            ('Müller', 'Anna', 'amuller', 'chzaxo@nio.com', 'password', '0605060708', now(), now(), 2),
            ('Garcia', 'Carlos', 'cgarcia', 'killqi@ncu.com', 'password', '0608091011', now(), now(), 3),
            ('Rossi', 'Luca', 'lrossi', 'caasse@ni.com', 'password', '0611121314', now(), now(), 4),
            ('Smith', 'Emily', 'esmith', 'nceiz@aa.com', 'password', '0615161718', now(), now(), 5),
            ('Johnson', 'Michael', 'mjohnson', 'cziu@aa.com', 'password', '0619202122', now(), now(), 2);



