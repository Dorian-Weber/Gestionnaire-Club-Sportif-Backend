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

INSERT INTO athlete (athlete_name, athlete_first_name, athlete_birth_date) VALUES
          ('Dupont', 'Jean', '1990-05-15'),
          ('Müller', 'Anna', '1988-11-22'),
          ('Garcia', 'Carlos', '1995-03-10'),
          ('Rossi', 'Luca', '1992-07-30'),
          ('Smith', 'Emily', '1993-12-05');

INSERT INTO event_athletes (event_id, athlete_id) VALUES
          (1, 1),
          (1, 2),
          (2, 3),
          (3, 4),
          (4, 5);

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
          (3, 4),
          (4, 5);
