CREATE TABLE BRAND (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    naziv_brand VARCHAR
);

CREATE TABLE NACIN_PLACANJA (
    id_nacin_plac INTEGER PRIMARY KEY AUTO_INCREMENT,
    naz_nacin_plac VARCHAR
);

CREATE TABLE POPUST_KODOVI (
    id_popust_kod INTEGER PRIMARY KEY AUTO_INCREMENT,
    popust_kod VARCHAR UNIQUE,
    popust DECIMAL(3, 2),
    iskoristen BOOLEAN
);

CREATE TABLE PROIZVOD (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    naziv_pro VARCHAR,
    opis_pro VARCHAR,
    cijena_pro DECIMAL(7, 2),
	kolicina_pro INTEGER,
    id_brand INTEGER
);

ALTER TABLE PROIZVOD ADD FOREIGN KEY (id_brand) REFERENCES BRAND(id);


CREATE TABLE NARUDZBA (
    id_nar INTEGER PRIMARY KEY AUTO_INCREMENT,
    datum_nar TIMESTAMP,
    uk_cijena_bez_p INTEGER,
    uk_cijena_s_p INTEGER,
    id_popust_kod INTEGER  REFERENCES POPUST_KODOVI(id_popust_kod),
    id_nacin_plac INTEGER  REFERENCES NACIN_PLACANJA(id_nacin_plac),
    br_kartice VARCHAR,
    email VARCHAR,
    br_mob INTEGER,
    adr_dostave VARCHAR,
    napomena VARCHAR
);

CREATE TABLE NARUDZBA_PROIZVODI (
    id_nar_pro INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_nar INTEGER  REFERENCES NARUDZBA(id_nar),
    id_pro INTEGER  REFERENCES PROIZVOD(id)
);


INSERT INTO BRAND VALUES 
(1, 'PIK'),
(2, 'Mlinar'),
(3, 'Podravka'),
(4, 'Gavrilović');

INSERT INTO PROIZVOD VALUES 
(1, 'Salama', 'Domaća PIK salama', 29.99, 25, 1),
(2, 'Sir', 'Domaći sir Pik', 27.99, 25, 1),
(3, 'Kruh', 'Domaći kruh Mlinar', 12.99, 25, 2),
(4, 'Salata', 'Domaća salata Podravka', 7.99, 50, 3),
(5, 'Krastavci', 'Domaći Podraka krastavci', 12.99, 25, 3),
(6, 'Čajna', 'Domaća Čajna kobasic Gavrilović', 49.99, 25, 4);

INSERT INTO NACIN_PLACANJA VALUES
(1, 'Gotovinsko'),
(2, 'Kartično');

INSERT INTO POPUST_KODOVI VALUES
(1, 'kod20', 0.2, false),
(2, 'kod40', 0.4, false),
(3, 'kod60', 0.6, false);

CREATE TRIGGER proizvodKupljen
    BEFORE INSERT ON NARUDZBA_PROIZVODI
    FOR EACH ROW
    CALL "com.example.mini_web_shop.trigger.SmanjiKolicinu";

CREATE TRIGGER kuponIskoristen
    BEFORE INSERT ON NARUDZBA
    FOR EACH ROW
--     WHEN(id_popust_kod IS NOT NULL AND id_popust_kod != '')
    CALL "com.example.mini_web_shop.trigger.DeaktivirajKupon";


-- CREATE OR REPLACE FUNCTION smanjiKolicinu() RETURNS TRIGGER AS $$
--
-- BEGIN
--
-- BEGIN
-- UPDATE PROIZVOD
-- SET kolicina_pro = PROIZVOD.kolicina_pro - 1
-- WHERE id = NEW.id_pro;
-- RETURN NEW; -- obavezno!
-- END;
-- $$ LANGUAGE plpgsql;
--
-- CREATE TRIGGER proizvodKupljen
--     AFTER INSERT ON NARUDZBA_PROIZVODI
--     FOR EACH ROW
--     WHEN (id_pro IS NOT NULL)
-- EXECUTE FUNCTION smanjiKolicinu();


