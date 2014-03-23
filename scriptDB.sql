DROP TABLE COMMANDE;
DROP TABLE ARTICLE;
DROP TABLE CATEGORIE;
DROP TABLE CLIENT;

CREATE TABLE ECOMMERCE.CATEGORIE
(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOM VARCHAR(100) NOT NULL,
PRIMARY KEY (ID)) ;

CREATE TABLE ECOMMERCE.ARTICLE
(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
ARTISTE VARCHAR(100) NOT NULL,
ALBUM VARCHAR(100),
PRIX VARCHAR(100),
URL_IMAGE VARCHAR(100),
DATE_CREATION VARCHAR(100),
ID_CATEGORIE INTEGER NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY("ID_CATEGORIE") REFERENCES CATEGORIE ("ID"));

CREATE TABLE ECOMMERCE.CLIENT
(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOM VARCHAR(100) NOT NULL,
PRENOM VARCHAR(100) NOT NULL,
PASSWORD VARCHAR(100) NOT NULL,
TELEPHONE VARCHAR(100),
EMAIL VARCHAR(100) NOT NULL,
ADRESSE VARCHAR(100),
CODE_POSTAL VARCHAR(100),
VILLE VARCHAR(100),
DATE_CREATION VARCHAR(100),
PRIMARY KEY (ID),
UNIQUE (EMAIL)) ;

CREATE TABLE ECOMMERCE.COMMANDE
(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
ID_CLIENT INTEGER NOT NULL,
ID_ARTICLE INTEGER NOT NULL,
QUANTITE INTEGER NOT NULL,
DATE_CREATION VARCHAR(100) NOT NULL,
ID_COMMANDE INTEGER NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY("ID_CLIENT") REFERENCES CLIENT ("ID"),
FOREIGN KEY("ID_ARTICLE") REFERENCES ARTICLE ("ID")) ;