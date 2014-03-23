TRUNCATE TABLE COMMANDE;
TRUNCATE TABLE ARTICLE;
TRUNCATE TABLE CATEGORIE;
TRUNCATE TABLE CLIENT;

INSERT INTO ECOMMERCE.CATEGORIE(NOM) VALUES('Indie-Pop');
INSERT INTO ECOMMERCE.CATEGORIE(NOM) VALUES('Alternatif');
INSERT INTO ECOMMERCE.CATEGORIE(NOM) VALUES('Pop-Rock');
INSERT INTO ECOMMERCE.CATEGORIE(NOM) VALUES('Punk-Rock');

INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Magic Man','You are here','10','img/magicman.jpg','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('The Colourist','Lido','10','img/lido.png','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Hunter Hunted','Hunter Hunted','10','img/hunterhunted.png','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('The Mowglis','Waiting For The Dawn','10','img/mowglis.jpg','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Animal Kingdom','Signs and Wonders','10','img/signs.jpg','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('A Silent Film','Sand & Snow','10','img/asilentfilm.jpg','20 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Youngblood Hawke','Youngblood Hawke','20','img/yh.jpg','20 Mars 2014', 2);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Sum 41','Screaming Bloody Murder','20','img/sum41.jpg','20 Mars 2014', 4);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Thirty Seconds to Mars','This Is War','20','img/30stm.jpg','30 Mars 2014', 2);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Good Charlotte','The Young and the Hopeless','20','img/goodcharlotte.jpg','30 Mars 2014', 2);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Neon Trees','Picture Show','20','img/neontrees.jpg','14 Mars 2014', 2);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Twenty One Pilots','Vessel','20','img/vessel.jpg','10 Mars 2014', 1);
INSERT INTO ECOMMERCE.ARTICLE(ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE) VALUES ('Indochine','Black City Parade','20','img/indochine.jpg','10 Mars 2014', 3);
