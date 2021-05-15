--
-- PostgreSQL database dump
--

-- Dumped from database version 11.10
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: akillicihaz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.akillicihaz (
    sicaklik double precision NOT NULL,
    sogutucuacikmi boolean NOT NULL,
    akillicihazid character varying NOT NULL,
    islemtarihi date NOT NULL
);


ALTER TABLE public.akillicihaz OWNER TO postgres;

--
-- Name: kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanicilar (
    kullaniciadi character varying NOT NULL,
    parola character varying NOT NULL,
    akillicihazid character varying NOT NULL
);


ALTER TABLE public.kullanicilar OWNER TO postgres;

--
-- Data for Name: akillicihaz; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.akillicihaz VALUES (37.8999999999999986, true, '1231231', '2021-05-15');


--
-- Data for Name: kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanicilar VALUES ('fatihaytar', '123456', '1231231');
INSERT INTO public.kullanicilar VALUES ('muratkeremkara', '123456', '2323112');


--
-- Name: kullanicilar kullanicilar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_pkey PRIMARY KEY (kullaniciadi);


--
-- Name: kullanicilar unique_kullanicilar_kullaniciadi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT unique_kullanicilar_kullaniciadi UNIQUE (kullaniciadi);


--
-- Name: kullanicilar unique_kullanicilar_sogutucuId; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT "unique_kullanicilar_sogutucuId" UNIQUE (akillicihazid);


--
-- Name: akillicihaz kullaniciCihaz; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.akillicihaz
    ADD CONSTRAINT "kullaniciCihaz" FOREIGN KEY (akillicihazid) REFERENCES public.kullanicilar(akillicihazid) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

