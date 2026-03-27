INSERT INTO Sport (nom_sport) VALUES
              ('Football'),
              ('Basketball'),
              ('Tennis'),
              ('Natation'),
              ('Athlétisme');

INSERT INTO discipline (nom_discipline, record_evenement,record_monde, sport_id) VALUES
              ('Saut en hauteur', '2.45 m', '2.45 m',5),
              ('Saut en longueur', '8.95 m', '8.95 m',5),
              ('Lancer de poids', '23.37 m', '23.37 m',5),
              ('Lancer de javelot', '98.48 m', '98.48 m', 5),
              ('Nage libre', '20.91 s', '20.91 s',4),
              ('Papillon', '49.45 s', '49.45 s',4);

INSERT INTO Type_evenement (nom_type_evenement) VALUES
            ('Match'),
            ('Tournoi'),
            ('Compétition'),
            ('Entraînement'),
            ('Exhibition');

INSERT INTO evenement (nom_evenement, description_evenement, date_evenement) VALUES
          ('Match de Football', 'Rencontre amicale entre deux équipes locales', '2026-04-15 18:00:00'),
          ('Tournoi de Basketball', 'Compétition régionale de basket', '2026-05-10 14:30:00'),
          ('Course d’Athlétisme', 'Épreuve de sprint 100 mètres', '2026-06-02 09:00:00'),
          ('Championnat de Tennis', 'Match de qualification pour le championnat national', '2026-07-08 16:00:00'),
          ('Compétition de Natation', 'Finale départementale de nage libre', '2026-08-21 10:30:00');



INSERT INTO Pays (nom_pays) VALUES
           ('France'),
           ('Allemagne'),
           ('Espagne'),
           ('Italie'),
           ('Royaume-Uni');

INSERT INTO type_compte (type_compte) VALUES
                                          ('admin'),
                                          ('super_admin'),
                                          ('public'),
                                          ('private'),
                                          ('closed');
