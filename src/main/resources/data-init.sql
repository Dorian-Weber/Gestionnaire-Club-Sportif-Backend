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

INSERT INTO Sport (nom_sport, record_evenement,record_monde) VALUES
           ('Football', null,null),
           ('Basketball', null, null),
           ('Tennis', null, null),
           ('Natation','10.05', '9.58' ),
           ('Athlétisme', '12.91', '9.40');

INSERT INTO Type_evenement (nom_type_evenement) VALUES
           ('Match'),
           ('Tournoi'),
           ('Compétition'),
           ('Entraînement'),
           ('Exhibition');