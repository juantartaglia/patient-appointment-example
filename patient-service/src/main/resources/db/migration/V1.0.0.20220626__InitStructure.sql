CREATE TABLE public.patient (
  id VARCHAR(255) NOT NULL,
  active BOOLEAN NOT NULL,
  contact_email VARCHAR(255),
  contact_name VARCHAR(255),
  contact_phone VARCHAR(255),
  created_at TIMESTAMP WITHOUT TIME ZONE,
  last_updated_at TIMESTAMP WITHOUT TIME ZONE,
  name VARCHAR(255),
  CONSTRAINT patient_pkey PRIMARY KEY(id)
) ;

ALTER TABLE public.patient
  OWNER TO demo;