select * from waybill;

CREATE SEQUENCE waybill_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS public.waybill
(
    id integer NOT NULL DEFAULT nextval('waybill_id_seq'::regclass),
    waybill_number character varying(255) COLLATE pg_catalog."default",
    shipment_id character varying(255) COLLATE pg_catalog."default",
    shipper_party_name character varying(255) COLLATE pg_catalog."default",
    shipper_party_address character varying(255) COLLATE pg_catalog."default",
    shipper_party_city character varying(255) COLLATE pg_catalog."default",
    shipper_party_state_code character varying(50) COLLATE pg_catalog."default",
    shipper_party_zip_code character varying(20) COLLATE pg_catalog."default",
    shipper_party_country character varying(50) COLLATE pg_catalog."default",
    shipper_party_phone_number character varying(50) COLLATE pg_catalog."default",
    shipper_party_email character varying(100) COLLATE pg_catalog."default",
    shipper_party_tax_id character varying(50) COLLATE pg_catalog."default",
    shipper_party_contact_person character varying(255) COLLATE pg_catalog."default",
    consignee_party_name character varying(255) COLLATE pg_catalog."default",
    consignee_party_address character varying(255) COLLATE pg_catalog."default",
    consignee_party_city character varying(255) COLLATE pg_catalog."default",
    consignee_party_state_code character varying(50) COLLATE pg_catalog."default",
    consignee_party_zip_code character varying(20) COLLATE pg_catalog."default",
    consignee_party_country character varying(50) COLLATE pg_catalog."default",
    consignee_party_phone_number character varying(50) COLLATE pg_catalog."default",
    consignee_party_email character varying(100) COLLATE pg_catalog."default",
    consignee_party_tax_id character varying(50) COLLATE pg_catalog."default",
    consignee_party_contact_person character varying(255) COLLATE pg_catalog."default",
    containers text COLLATE pg_catalog."default",
    trailers text COLLATE pg_catalog."default",
    intermodal boolean,
    interchange_point character varying(255) COLLATE pg_catalog."default",
    origin character varying(255) COLLATE pg_catalog."default",
    destination character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT waybill_pkey PRIMARY KEY (id)
)