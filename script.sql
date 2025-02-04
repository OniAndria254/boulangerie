CREATE DATABASE boulangerie;

\c boulangerie;

CREATE TABLE unite_mesure(
                             Id_unite_mesure SERIAL,
                             libelle VARCHAR(50)  NOT NULL,
                             description VARCHAR(100) ,
                             PRIMARY KEY(Id_unite_mesure),
                             UNIQUE(libelle)
);

CREATE TABLE stock_ingredient_mere(
                                      Id_mere SERIAL,
                                      daty DATE,
                                      PRIMARY KEY(Id_mere)
);

CREATE TABLE stock_produit_mere(
                                   Id_mere SERIAL,
                                   daty DATE,
                                   PRIMARY KEY(Id_mere)
);

CREATE TABLE categorie(
                          Id_categorie SERIAL,
                          nom VARCHAR(50) ,
                          PRIMARY KEY(Id_categorie)
);

CREATE TABLE parfum(
                       Id_parfum SERIAL,
                       nom VARCHAR(50)  NOT NULL,
                       PRIMARY KEY(Id_parfum)
);

CREATE TABLE ingredient(
                           Id_ingredient SERIAL,
                           nom VARCHAR(50)  NOT NULL,
                           Id_unite_mesure INTEGER NOT NULL,
                           PRIMARY KEY(Id_ingredient),
                           UNIQUE(nom),
                           FOREIGN KEY(Id_unite_mesure) REFERENCES unite_mesure(Id_unite_mesure)
);

CREATE TABLE stock_ingredient_fille(
                                       Id_fille SERIAL,
                                       entree NUMERIC(15,2)  ,
                                       sortie NUMERIC(15,2)  ,
                                       Id_ingredient INTEGER NOT NULL,
                                       Id_mere INTEGER NOT NULL,
                                       PRIMARY KEY(Id_fille),
                                       FOREIGN KEY(Id_ingredient) REFERENCES ingredient(Id_ingredient),
                                       FOREIGN KEY(Id_mere) REFERENCES stock_ingredient_mere(Id_mere)
);

CREATE TABLE produit(
                        Id_produit SERIAL,
                        nom VARCHAR(50)  NOT NULL,
                        prix_vente NUMERIC(15,2)   NOT NULL,
                        Id_parfum INTEGER NOT NULL,
                        Id_categorie INTEGER NOT NULL,
                        PRIMARY KEY(Id_produit),
                        UNIQUE(nom),
                        FOREIGN KEY(Id_parfum) REFERENCES parfum(Id_parfum),
                        FOREIGN KEY(Id_categorie) REFERENCES categorie(Id_categorie)
);

CREATE TABLE production(
                           Id_production SERIAL,
                           quantite_produite INTEGER NOT NULL,
                           date_production DATE,
                           Id_produit INTEGER NOT NULL,
                           PRIMARY KEY(Id_production),
                           FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);

CREATE TABLE stock_produit_fille(
                                    Id_fille SERIAL,
                                    entree INTEGER,
                                    sortie INTEGER,
                                    Id_produit INTEGER NOT NULL,
                                    Id_mere INTEGER NOT NULL,
                                    PRIMARY KEY(Id_fille),
                                    FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit),
                                    FOREIGN KEY(Id_mere) REFERENCES stock_produit_mere(id_mere)
);

CREATE TABLE client(
                       Id_client SERIAL,
                       nom VARCHAR(50) ,
                       prenom VARCHAR(50) ,
                       date_naissance DATE,
                       PRIMARY KEY(Id_client)
);


CREATE TABLE genre(
                      Id_genre SERIAL,
                      nom VARCHAR(50) ,
                      PRIMARY KEY(Id_genre)
);


CREATE TABLE vendeur(
                        Id_vendeur SERIAL,
                        nom VARCHAR(50) ,
                        prenom VARCHAR(50) ,
                        salaire NUMERIC(15,2)  ,
                        Id_genre INTEGER NOT NULL,
                        PRIMARY KEY(Id_vendeur),
                        FOREIGN KEY(Id_genre) REFERENCES genre(Id_genre)
);

CREATE TABLE commission_config (
                                   Id_commission_config SERIAL,
                                   taux_commission NUMERIC(5,2) NOT NULL,  -- Taux de commission (ex: 0.05 pour 5%)
                                   montant_min_commission NUMERIC(15,2) NOT NULL,  -- Montant minimum de commission (ex: 200000)
                                   date_config DATE NOT NULL,  -- Date à partir de laquelle cette configuration est effective
                                   PRIMARY KEY(Id_commission_config),
                                   UNIQUE(date_config)  -- Assure qu'il n'y a qu'une seule configuration par date
);

CREATE TABLE historique_prix(
                                Id_historique_prix SERIAL,
                                daty DATE,
                                prix NUMERIC(15,2)  ,
                                Id_produit INTEGER NOT NULL,
                                PRIMARY KEY(Id_historique_prix),
                                FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);


CREATE TABLE vente(
                      Id_vente SERIAL,
                      quantite INTEGER NOT NULL,
                      date_vente DATE,
                      Id_vendeur INTEGER NOT NULL,
                      Id_client INTEGER NOT NULL,
                      Id_produit INTEGER NOT NULL,
                      commission NUMERIC(15, 2) NOT NULL DEFAULT 0, -- Nouvelle colonne
                      Id_commission_config INTEGER,
                      PRIMARY KEY(Id_vente),
                      FOREIGN KEY(Id_commission_config) REFERENCES commission_config(Id_commission_config),
                      FOREIGN KEY(Id_vendeur) REFERENCES vendeur(Id_vendeur),
                      FOREIGN KEY(Id_client) REFERENCES client(Id_client),
                      FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);


CREATE TABLE produit_conseille(
                          Id_produit_conseille SERIAL,
                          daty DATE NOT NULL,
                          Id_produit INTEGER NOT NULL,
                          PRIMARY KEY(Id_produit_conseille),
                          FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);


CREATE TABLE recette(
                        Id_ingredient INTEGER,
                        Id_produit INTEGER,
                        quantite NUMERIC(15,2)   NOT NULL,
                        PRIMARY KEY(Id_ingredient, Id_produit),
                        FOREIGN KEY(Id_ingredient) REFERENCES ingredient(Id_ingredient),
                        FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);


INSERT INTO commission_config (taux_commission, montant_min_commission, date_config)
VALUES (0.05, 200000, '2025-01-01');


CREATE OR REPLACE VIEW etat_stock_ingredient AS
SELECT
    i.nom AS ingredient,
    um.libelle AS unite_mesure,
    COALESCE(SUM(sif.entree), 0) - COALESCE(SUM(sif.sortie), 0) AS stock_disponible
FROM
    ingredient i
LEFT JOIN
    stock_ingredient_fille sif ON i.Id_ingredient = sif.Id_ingredient
LEFT JOIN
    unite_mesure um ON i.Id_unite_mesure = um.Id_unite_mesure
GROUP BY
    i.nom, um.libelle
ORDER BY
    i.nom;


CREATE OR REPLACE VIEW etat_stock_produit AS
SELECT 
    p.nom AS produit,
    COALESCE(SUM(spf.entree), 0) - COALESCE(SUM(spf.sortie), 0) AS stock_disponible
FROM 
    produit p
LEFT JOIN 
    stock_produit_fille spf ON p.Id_produit = spf.Id_produit
GROUP BY 
    p.nom
ORDER BY 
    p.nom;

-- Ajout des unités de mesure
INSERT INTO unite_mesure (libelle, description) VALUES 
('kg', 'kilogramme'),
('L', 'litre'),
('pc', 'piece');

-- Ajout de catégories
INSERT INTO categorie (nom) VALUES 
('Viennoiserie'),
('Patisserie'),
('Sandwich');

-- Ajout de parfums de produit
INSERT INTO parfum (nom) VALUES
('Nature'),
('Chocolat'),
('Jambon');

-- Ajout d'ingrédients
INSERT INTO ingredient (nom, Id_unite_mesure) VALUES 
('Farine', 1), -- Id_unite_mesure = kilogramme
('Beurre', 1),
('Chocolat', 1),
('Jambon', 1),
('Sel', 1),
('Sucre', 1);

-- Ajout des produits
INSERT INTO produit (nom, prix_vente, Id_parfum, Id_categorie) VALUES
('Croissant nature', 1500, 1, 1), -- Nature
('Croissant au chocolat', 2000, 2, 1), -- Au chocolat
('Croissant au jambon', 3000, 3, 1); -- Au jambon

-- Ajout des recettes pour les produits
-- Recette pour croissant nature
INSERT INTO recette (Id_ingredient, Id_produit, quantite) VALUES 
(1, 1, 0.10), -- Farine
(2, 1, 0.05), -- Beurre
(5, 1, 0.002); -- Sel

-- Recette pour croissant au chocolat
INSERT INTO recette (Id_ingredient, Id_produit, quantite) VALUES 
(1, 2, 0.10), -- Farine
(2, 2, 0.05), -- Beurre
(5, 2, 0.002), -- Sel
(3, 2, 0.03); -- Chocolat

-- Recette pour croissant au jambon
INSERT INTO recette (Id_ingredient, Id_produit, quantite) VALUES 
(1, 3, 0.10), -- Farine
(2, 3, 0.05), -- Beurre
(5, 3, 0.002), -- Sel
(4, 3, 0.03); -- Jambon

-- Ajout des stocks d'ingrédients (fille)
INSERT INTO stock_ingredient_mere (daty) VALUES 
('2025-01-01');

INSERT INTO stock_ingredient_fille (entree, sortie, Id_ingredient, Id_mere) VALUES 
(100, 0, 1, 1), -- Farine
(50, 0, 2, 1),  -- Beurre
(30, 0, 3, 1),  -- Chocolat
(20, 0, 4, 1),  -- Jambon
(10, 0, 5, 1);  -- Sel

-- Ajout des stocks de produits (fille)
INSERT INTO stock_produit_mere (daty) VALUES 
('2025-01-02');

INSERT INTO stock_produit_fille (entree, sortie, Id_produit, Id_mere) VALUES 
(20, 0, 1, 1), -- Croissant nature
(15, 0, 2, 1), -- Croissant au chocolat
(10, 0, 3, 1); -- Croissant au jambon


-- Insertion 1
INSERT INTO vendeur (nom, prenom, salaire) VALUES ('Dupont', 'Jean', 200000.00);

-- Insertion 2
INSERT INTO vendeur (nom, prenom, salaire) VALUES ('Martin', 'Alice', 250000.00);

-- Insertion 3
INSERT INTO vendeur (nom, prenom, salaire) VALUES ('Leroy', 'Paul', 250000.00);

-- Insertion 4
INSERT INTO vendeur (nom, prenom, salaire) VALUES ('Bernard', 'Sophie', 250000.00);

-- Insertion 5
INSERT INTO vendeur (nom, prenom, salaire) VALUES ('Petit', 'Luc', 250000.00);

