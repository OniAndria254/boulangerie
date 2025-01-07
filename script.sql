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
