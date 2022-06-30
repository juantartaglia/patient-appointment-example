/* Data for the 'public.patient' table  (Records 1 - 3) */

INSERT INTO public.patient ("id", "active", "contact_email", "contact_name", "contact_phone", "created_at", "last_updated_at", "name")
VALUES
  (E'33b75520-7c28-49b3-bb47-74573ad01527', True, E'patient.one@example.com', E'Patient Name One', E'+5422351111111', E'2022-06-26 15:12:10.078993', NULL, E'PatientNameOne'),
  (E'9ec3e368-8752-46ac-aba8-7d62639d2d75', True, E'patient.three@example.com', E'Patient Name Three', E'+542235333333', E'2022-06-26 15:12:57.038196', NULL, E'PatientNameThree'),
  (E'a4e6ece4-663c-4fac-a760-3db0411cef1e', True, E'patient.two@example.com', E'Patient Name Two', E'+5422352222222', E'2022-06-26 15:11:46.960625', NULL, E'PatientNameTwo');
