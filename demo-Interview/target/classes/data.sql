INSERT INTO country (id_country, lib_country) VALUES ('TN', 'TUNISIA');
INSERT INTO country (id_country, lib_country) VALUES ('FR', 'FRANCE');
INSERT INTO country (id_country, lib_country) VALUES ('DE', 'Germany');


INSERT INTO PATIENT (id_patient,first_Name,last_Name,date_of_birth,adress,id_country)
values (0011223344,'Zouaoui','Ameni',parsedatetime('06-08-1996', 'dd-MM-yyyy'),'TUNIS','TN');

INSERT INTO PATIENT (id_patient,first_Name,last_Name,date_of_birth,adress,id_country)
values (0011223345,'Zouaoui','Manel',parsedatetime('01-08-1993', 'dd-MM-yyyy'),'Berlin','DE');

INSERT INTO PATIENT (id_patient,first_Name,last_Name,date_of_birth,adress,id_country)
values (0011223343,'Zouaoui','Manel1',parsedatetime('01-08-1993', 'dd-MM-yyyy'),'Berlin','DE');

INSERT INTO PATIENT (id_patient,first_Name,last_Name,date_of_birth,adress,id_country)
values (0011223346,'Zouaoui','Emna',parsedatetime('22-01-2002', 'dd-MM-yyyy'),'Toulouse','FR');


INSERT INTO COVID_VACCIN values (1,parsedatetime('08-12-2021', 'dd-MM-yyyy'),parsedatetime('08-01-2022', 'dd-MM-yyyy'),0011223344);
INSERT INTO COVID_VACCIN values (2,parsedatetime('10-11-2021', 'dd-MM-yyyy'),parsedatetime('20-12-2022', 'dd-MM-yyyy'),0011223345);
INSERT INTO COVID_VACCIN values (3,parsedatetime('15-08-2021', 'dd-MM-yyyy'),parsedatetime('15-10-2021', 'dd-MM-yyyy'),0011223346);


INSERT INTO COVID_CASE values (1,parsedatetime('08-12-2021', 'dd-MM-yyyy'),true,0011223344);
INSERT INTO COVID_CASE values (2,parsedatetime('10-11-2021', 'dd-MM-yyyy'),true,0011223345);
INSERT INTO COVID_CASE values (3,parsedatetime('20-11-2021', 'dd-MM-yyyy'),false,0011223345);
INSERT INTO COVID_CASE values (5,parsedatetime('20-11-2021', 'dd-MM-yyyy'),false,0011223343);
INSERT INTO COVID_CASE values (4,parsedatetime('15-08-2021', 'dd-MM-yyyy'),false,0011223345);