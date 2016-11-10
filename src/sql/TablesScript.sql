-- Table: registro

-- DROP TABLE registro;

CREATE TABLE registro
(

  idPC integer,
  Detalle character varying,
  Observacion character varying,
  Fecha timestamp,
  Tecnico character varying,
  Cliente character varying,
 	
)
WITH (
  OIDS=FALSE
);
ALTER TABLE registro
  OWNER TO postgres;
  

  
 
 