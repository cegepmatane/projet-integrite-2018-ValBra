--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: equipes; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE equipes WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE equipes OWNER TO postgres;

\connect equipes

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: compterEquipes(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "compterEquipes"() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreEquipes from equipes

$$;


ALTER FUNCTION public."compterEquipes"() OWNER TO postgres;

--
-- Name: compterequipes(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION compterequipes() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreEquipes from equipes

$$;


ALTER FUNCTION public.compterequipes() OWNER TO postgres;

--
-- Name: direbonjour(text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION direbonjour(nom text) RETURNS text
    LANGUAGE plpgsql
    AS $$
DECLARE
	message text;
BEGIN
	message := 'Bonjour';
	return 'Bonjour ' || nom;
END
$$;


ALTER FUNCTION public.direbonjour(nom text) OWNER TO postgres;

--
-- Name: estpluspetit(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION estpluspetit() RETURNS boolean
    LANGUAGE plpgsql
    AS $$
BEGIN

return true;

END
$$;


ALTER FUNCTION public.estpluspetit() OWNER TO postgres;

--
-- Name: estpluspetit(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION estpluspetit(nombre1 text, nombre2 text) RETURNS boolean
    LANGUAGE plpgsql
    AS $$
DECLARE
BEGIN
	return nombre1 < nombre2;
END
$$;


ALTER FUNCTION public.estpluspetit(nombre1 text, nombre2 text) OWNER TO postgres;

--
-- Name: insererNombre(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "insererNombre"() RETURNS void
    LANGUAGE sql
    AS $$
insert into memoire(nombre) VALUES (3)
$$;


ALTER FUNCTION public."insererNombre"() OWNER TO postgres;

--
-- Name: inserernombre(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION inserernombre() RETURNS void
    LANGUAGE sql
    AS $$

insert into memoire(nombre) VALUES (3)

$$;


ALTER FUNCTION public.inserernombre() OWNER TO postgres;

--
-- Name: journaliserequipe(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION journaliserequipe() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
	message TEXT;
	descrip TEXT;
	BEGIN
		message := NEW.nom;
		descrip := 'Ajout equipe' || NEW.nom;
		insert into journal(operation,description) values(message,descrip);
	return OLD;
END
$$;


ALTER FUNCTION public.journaliserequipe() OWNER TO postgres;

--
-- Name: repetermessage(text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION repetermessage(message text) RETURNS text
    LANGUAGE plpgsql
    AS $$
DECLARE
	messageRepete text;
BEGIN
	messageRepete := '';
	--FOR repetition IN 1..3 LOOP

	--END LOOP;
	return messageRepete;
END
$$;


ALTER FUNCTION public.repetermessage(message text) OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: equipes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE equipes (
    id integer NOT NULL,
    nom text,
    pays text,
    annee text,
    stade text,
    entraineur text
);


ALTER TABLE equipes OWNER TO postgres;

--
-- Name: equipes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE equipes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE equipes_id_seq OWNER TO postgres;

--
-- Name: equipes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipes_id_seq OWNED BY equipes.id;


--
-- Name: joueurs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE joueurs (
    id integer NOT NULL,
    nom text,
    age text,
    poste text,
    equipe integer
);


ALTER TABLE joueurs OWNER TO postgres;

--
-- Name: joueurs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE joueurs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE joueurs_id_seq OWNER TO postgres;

--
-- Name: joueurs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE joueurs_id_seq OWNED BY joueurs.id;


--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE journal (
    id integer NOT NULL,
    moment text,
    operation text,
    description text
);


ALTER TABLE journal OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE journal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE journal_id_seq OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE journal_id_seq OWNED BY journal.id;


--
-- Name: memoire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE memoire (
    id integer NOT NULL,
    nombre integer
);


ALTER TABLE memoire OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE memoire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE memoire_id_seq OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE memoire_id_seq OWNED BY memoire.id;


--
-- Name: equipes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipes ALTER COLUMN id SET DEFAULT nextval('equipes_id_seq'::regclass);


--
-- Name: joueurs id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joueurs ALTER COLUMN id SET DEFAULT nextval('joueurs_id_seq'::regclass);


--
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal ALTER COLUMN id SET DEFAULT nextval('journal_id_seq'::regclass);


--
-- Name: memoire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY memoire ALTER COLUMN id SET DEFAULT nextval('memoire_id_seq'::regclass);


--
-- Data for Name: equipes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO equipes VALUES (0, 'Nancy', 'France', '1967', 'Marcel Picot', 'Didier Tholot');
INSERT INTO equipes VALUES (1, 'Whitecaps', 'Canada', '1974', 'BC Place', 'Carl Robinson');
INSERT INTO equipes VALUES (2, 'Amicale de Chanteheux', 'France', '1966', 'Municipal', 'Patrice Furet');


--
-- Name: equipes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('equipes_id_seq', 19, true);


--
-- Data for Name: joueurs; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO joueurs VALUES (1, 'Diagne', '22', 'défenseur', 0);
INSERT INTO joueurs VALUES (0, 'Chernik', '31', 'gardien', 0);
INSERT INTO joueurs VALUES (2, 'Bassi', '20', 'milieu', 0);
INSERT INTO joueurs VALUES (3, 'Dalé', '31', 'attaquant', 0);
INSERT INTO joueurs VALUES (4, 'Kamara', '31', 'attaquant', 1);
INSERT INTO joueurs VALUES (5, 'Marinovic', '30', 'gardien', 1);


--
-- Name: joueurs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('joueurs_id_seq', 1, false);


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO journal VALUES (1, NULL, 'Tromso', NULL);
INSERT INTO journal VALUES (2, NULL, 'Tromso', 'Ajout equipeTromso');
INSERT INTO journal VALUES (3, NULL, 'Tromso', 'Ajout equipeTromso');
INSERT INTO journal VALUES (4, NULL, 'Tromso', 'Ajout equipeTromso');
INSERT INTO journal VALUES (5, NULL, '', 'Ajout equipe');
INSERT INTO journal VALUES (6, NULL, '', 'Ajout equipe');


--
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_id_seq', 6, true);


--
-- Data for Name: memoire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO memoire VALUES (1, 3);


--
-- Name: memoire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('memoire_id_seq', 1, true);


--
-- Name: equipes equipes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipes
    ADD CONSTRAINT equipes_pkey PRIMARY KEY (id);


--
-- Name: joueurs joueurs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joueurs
    ADD CONSTRAINT joueurs_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: memoire memoire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY memoire
    ADD CONSTRAINT memoire_pkey PRIMARY KEY (id);


--
-- Name: fki_one_equipe_to_many_joueurs; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_equipe_to_many_joueurs ON joueurs USING btree (equipe);


--
-- Name: equipes suiviequipe; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER suiviequipe BEFORE INSERT OR UPDATE ON equipes FOR EACH ROW EXECUTE PROCEDURE journaliserequipe();


--
-- Name: equipes suiviequipes; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER suiviequipes BEFORE INSERT OR UPDATE ON equipes FOR EACH ROW EXECUTE PROCEDURE journaliserequipe();


--
-- Name: joueurs one_equipe_to_many_joueurs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joueurs
    ADD CONSTRAINT one_equipe_to_many_joueurs FOREIGN KEY (equipe) REFERENCES equipes(id);


--
-- PostgreSQL database dump complete
--

