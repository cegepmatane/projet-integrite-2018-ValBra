--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
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
SELECT pg_catalog.set_config('search_path', '', false);
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


--
-- Name: compterEquipes(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."compterEquipes"() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreEquipes from equipes

$$;


ALTER FUNCTION public."compterEquipes"() OWNER TO postgres;

--
-- Name: compterequipes(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.compterequipes() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreEquipes from equipes

$$;


ALTER FUNCTION public.compterequipes() OWNER TO postgres;

--
-- Name: direbonjour(text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.direbonjour(nom text) RETURNS text
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

CREATE FUNCTION public.estpluspetit() RETURNS boolean
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

CREATE FUNCTION public.estpluspetit(nombre1 text, nombre2 text) RETURNS boolean
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

CREATE FUNCTION public."insererNombre"() RETURNS void
    LANGUAGE sql
    AS $$
insert into memoire(nombre) VALUES (3)
$$;


ALTER FUNCTION public."insererNombre"() OWNER TO postgres;

--
-- Name: inserernombre(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.inserernombre() RETURNS void
    LANGUAGE sql
    AS $$

insert into memoire(nombre) VALUES (3)

$$;


ALTER FUNCTION public.inserernombre() OWNER TO postgres;

--
-- Name: journaliserequipe(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.journaliserequipe() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
	message TEXT;
	BEGIN
		message := NEW.nom || " " || NEW.description;
		insert into journal(message) values(message);
	return OLD;
END
$$;


ALTER FUNCTION public.journaliserequipe() OWNER TO postgres;

--
-- Name: repetermessage(text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.repetermessage(message text) RETURNS text
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

CREATE TABLE public.equipes (
    id integer NOT NULL,
    nom text,
    pays text,
    annee text,
    stade text,
    entraineur text
);


ALTER TABLE public.equipes OWNER TO postgres;

--
-- Name: equipes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipes_id_seq OWNER TO postgres;

--
-- Name: equipes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipes_id_seq OWNED BY public.equipes.id;


--
-- Name: joueurs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.joueurs (
    id integer NOT NULL,
    nom text,
    age text,
    poste text,
    equipe integer
);


ALTER TABLE public.joueurs OWNER TO postgres;

--
-- Name: joueurs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.joueurs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.joueurs_id_seq OWNER TO postgres;

--
-- Name: joueurs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.joueurs_id_seq OWNED BY public.joueurs.id;


--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.journal (
    id integer NOT NULL,
    moment text,
    operation text,
    description text
);


ALTER TABLE public.journal OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.journal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.journal_id_seq OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.journal_id_seq OWNED BY public.journal.id;


--
-- Name: memoire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.memoire (
    id integer NOT NULL,
    nombre integer
);


ALTER TABLE public.memoire OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.memoire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.memoire_id_seq OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.memoire_id_seq OWNED BY public.memoire.id;


--
-- Name: equipes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipes ALTER COLUMN id SET DEFAULT nextval('public.equipes_id_seq'::regclass);


--
-- Name: joueurs id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.joueurs ALTER COLUMN id SET DEFAULT nextval('public.joueurs_id_seq'::regclass);


--
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal ALTER COLUMN id SET DEFAULT nextval('public.journal_id_seq'::regclass);


--
-- Name: memoire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memoire ALTER COLUMN id SET DEFAULT nextval('public.memoire_id_seq'::regclass);


--
-- Data for Name: equipes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.equipes VALUES (0, 'Nancy', 'France', '1967', 'Marcel Picot', 'Didier Tholot');
INSERT INTO public.equipes VALUES (1, 'Whitecaps', 'Canada', '1974', 'BC Place', 'Carl Robinson');
INSERT INTO public.equipes VALUES (2, 'Amicale de Chanteheux', 'France', '1966', 'Municipal', 'Patrice Furet');
INSERT INTO public.equipes VALUES (3, '', '', '', '', '');
INSERT INTO public.equipes VALUES (4, '', '', '', '', '');
INSERT INTO public.equipes VALUES (5, '', '', '', '', '');
INSERT INTO public.equipes VALUES (6, '', '', '', '', '');


--
-- Data for Name: joueurs; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.joueurs VALUES (1, 'Diagne', '22', 'défenseur', 0);
INSERT INTO public.joueurs VALUES (0, 'Chernik', '31', 'gardien', 0);
INSERT INTO public.joueurs VALUES (2, 'Bassi', '20', 'milieu', 0);
INSERT INTO public.joueurs VALUES (3, 'Dalé', '31', 'attaquant', 0);
INSERT INTO public.joueurs VALUES (4, 'Kamara', '31', 'attaquant', 1);
INSERT INTO public.joueurs VALUES (5, 'Marinovic', '30', 'gardien', 1);


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: memoire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.memoire VALUES (1, 3);


--
-- Name: equipes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipes_id_seq', 9, true);


--
-- Name: joueurs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.joueurs_id_seq', 1, false);


--
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.journal_id_seq', 1, false);


--
-- Name: memoire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.memoire_id_seq', 1, true);


--
-- Name: equipes equipes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipes
    ADD CONSTRAINT equipes_pkey PRIMARY KEY (id);


--
-- Name: joueurs joueurs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.joueurs
    ADD CONSTRAINT joueurs_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: memoire memoire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.memoire
    ADD CONSTRAINT memoire_pkey PRIMARY KEY (id);


--
-- Name: fki_one_equipe_to_many_joueurs; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_equipe_to_many_joueurs ON public.joueurs USING btree (equipe);


--
-- Name: equipes suiviequipe; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER suiviequipe BEFORE INSERT OR UPDATE ON public.equipes FOR EACH ROW EXECUTE PROCEDURE public.journaliserequipe();


--
-- Name: equipes suiviequipes; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER suiviequipes BEFORE INSERT OR UPDATE ON public.equipes FOR EACH ROW EXECUTE PROCEDURE public.journaliserequipe();


--
-- Name: joueurs one_equipe_to_many_joueurs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.joueurs
    ADD CONSTRAINT one_equipe_to_many_joueurs FOREIGN KEY (equipe) REFERENCES public.equipes(id);


--
-- PostgreSQL database dump complete
--

