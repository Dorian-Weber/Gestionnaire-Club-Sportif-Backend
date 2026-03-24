INSERT INTO discipline (nom_discipline, record_evenement,record_monde) VALUES
              ('Saut en hauteur', '2.45 m', '2.45 m'),
              ('Saut en longueur', '8.95 m', '8.95 m'),
              ('Lancer de poids', '23.37 m', '23.37 m'),
              ('Lancer de javelot', '98.48 m', '98.48 m'),
              ('Nage libre', '20.91 s', '20.91 s'),
              ('Papillon', '49.45 s', '49.45 s');

INSERT INTO type_compte (type_compte) VALUES
           ('admin'),
           ('super_admin'),
           ('public'),
           ('private'),
           ('closed');

INSERT INTO Pays (nom_pays) VALUES
           ('France'),
           ('Allemagne'),
           ('Espagne'),
           ('Italie'),
           ('Royaume-Uni');

INSERT INTO Sport (nom_sport) VALUES
           ('Football'),
           ('Basketball'),
           ('Tennis'),
           ('Natation'),
           ('Athlétisme');

INSERT INTO Type_evenement (nom_type_evenement) VALUES
           ('Match'),
           ('Tournoi'),
           ('Compétition'),
           ('Entraînement'),
           ('Exhibition');