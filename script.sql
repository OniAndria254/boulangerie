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

CREATE TABLE categorie(
    Id_categorie SERIAL,
    nom VARCHAR(50) ,
    PRIMARY KEY(Id_categorie)
);

CREATE TABLE produit(
    Id_produit SERIAL,
    nom VARCHAR(50)  NOT NULL,
    prix_vente NUMERIC(15,2)   NOT NULL,
    Id_categorie INTEGER NOT NULL,
    PRIMARY KEY(Id_produit),
    UNIQUE(nom),
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

CREATE TABLE stock_produit_mere(
   Id_mere SERIAL,
   daty DATE,
   PRIMARY KEY(Id_mere)
);

CREATE TABLE stock_produit_fille(
   Id_fille SERIAL,
   entree INTEGER,
   sortie INTEGER ,
   Id_mere INTEGER NOT NULL,
   Id_produit INTEGER NOT NULL,
   PRIMARY KEY(Id_fille),
   FOREIGN KEY(Id_mere) REFERENCES stock_produit_mere(Id_mere),
   FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
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

CREATE TABLE recette(
   Id_ingredient INTEGER,
   Id_produit INTEGER,
   quantite NUMERIC(15,2)   NOT NULL,
   PRIMARY KEY(Id_ingredient, Id_produit),
   FOREIGN KEY(Id_ingredient) REFERENCES ingredient(Id_ingredient),
   FOREIGN KEY(Id_produit) REFERENCES produit(Id_produit)
);


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



-- Insérer des unités de mesure
INSERT INTO unite_mesure (libelle, description) VALUES 
('Kg', 'Kilogramme'),
('L', 'Litre'),
('pc', 'Pièce');

-- Insérer des catégories
INSERT INTO categorie (nom) VALUES 
('Pain'),
('Patisserie'),
('Viennoiserie');

-- Insérer des produits
INSERT INTO produit (nom, prix_vente, Id_categorie) VALUES 
('Baguette', 1000, 1),
('Croissant', 1200, 3),
('Eclair au chocolat', 2000, 2);

-- Insérer des ingrédients
INSERT INTO ingredient (nom, Id_unite_mesure) VALUES 
('Farine', 1),
('Eau', 2),
('Levure', 1),
('Chocolat', 1),
('Beurre', 1);

-- Insérer des stocks mère pour les ingrédients
INSERT INTO stock_ingredient_mere (daty) VALUES 
('2025-01-01'),
('2025-01-02');

-- Insérer des mouvements fille pour les ingrédients
INSERT INTO stock_ingredient_fille (entree, sortie, Id_ingredient, Id_mere) VALUES 
(50, 0, 1, 1),  -- 50 kg de farine ajoutés
(30, 0, 2, 1),  -- 30 litres d'eau ajoutés
(5, 0, 3, 1),   -- 5 kg de levure ajoutés
(10, 0, 4, 1),  -- 10 kg de chocolat ajoutés
(20, 0, 5, 1),  -- 20 kg de beurre ajoutés
(0, 10, 1, 2),  -- 10 kg de farine retirés
(0, 5, 2, 2);   -- 5 litres d'eau retirés

-- Insérer des stocks mère pour les produits
INSERT INTO stock_produit_mere (daty) VALUES 
('2025-01-01'),
('2025-01-02');

-- Insérer des mouvements fille pour les produits
INSERT INTO stock_produit_fille (entree, sortie, Id_mere, Id_produit) VALUES 
(100, 0, 1, 1),  -- 100 baguettes ajoutées
(50, 0, 1, 2),   -- 50 croissants ajoutés
(30, 0, 1, 3),   -- 30 éclairs au chocolat ajoutés
(0, 20, 2, 1),   -- 20 baguettes vendues
(0, 10, 2, 2);   -- 10 croissants vendus

-- Insérer des recettes
INSERT INTO recette (Id_ingredient, Id_produit, quantite) VALUES 
(1, 1, 0.2),  -- 0.2 kg de farine pour une baguette
(2, 1, 0.1),  -- 0.1 litre d'eau pour une baguette
(3, 1, 0.02), -- 0.02 kg de levure pour une baguette
(1, 2, 0.15), -- 0.15 kg de farine pour un croissant
(5, 2, 0.05), -- 0.05 kg de beurre pour un croissant
(1, 3, 0.1),  -- 0.1 kg de farine pour un éclair
(4, 3, 0.05), -- 0.05 kg de chocolat pour un éclair
(5, 3, 0.03); -- 0.03 kg de beurre pour un éclair

-- Insérer des productions
INSERT INTO production (quantite_produite, date_production, Id_produit) VALUES 
(100, '2025-01-01', 1), -- 100 baguettes produites
(50, '2025-01-01', 2),  -- 50 croissants produits
(30, '2025-01-01', 3);  -- 30 éclairs au chocolat produits
