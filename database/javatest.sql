-- Stored in the main website, don't need another database just for one table

\c website;

--
-- Name: javatestseq; Type: SEQUENCE; Schema: public; Owner: javatest
--

CREATE SEQUENCE javatestseq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.javatestseq OWNER TO javatest;

--
-- Name: javatestseq; Type: SEQUENCE SET; Schema: public; Owner: javatest
--

SELECT pg_catalog.setval('javatestseq', 57, true);


--
-- Name: javatest; Type: TABLE; Schema: public; Owner: javatest; Tablespace: 
--

CREATE TABLE javatest (
    id integer DEFAULT nextval('javatestseq'::regclass) NOT NULL,
    name character varying,
    websiteurl character varying,
    sourceurl character varying,
    description character varying(255),
    licensetype character varying(255),
    sponsor character varying(255),
    swtype character varying(255),
    target character varying(255),
    softwaretype character varying(255)
);


ALTER TABLE public.javatest OWNER TO javatest;

