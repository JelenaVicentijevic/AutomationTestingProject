Testira se sajt https://sandbox.2checkout.com/sandbox.

Za rad sa elementima koji se nalaze na web stranici koristiti Selenium, a za pisanje testova TestNG. Primeniti Page Object Model.

Potrebno je da se svi korišćeni lokatori čuvaju u jednom tekstualnom fajlu, tako da ukoliko se neki (na primer xpath) promeni čitav kod nije potrebno kompajlirati.

Odraditi sledeće zahteve:

➔	Testirati da li je moguće ulogovati se ukoliko je preskočen korak registracije korisnika (da li se može prijaviti koristeći podatke koji nikada nisu sačuvani u bazi korisnika).

➔	Testirati da li radi forma za registraciju unosom podataka za jednog korisnika.

➔	Detaljno proveriti da li je moguće registrovati se bez unosa svih polja.

➔	Pronaći kako da se automatski izgeneriše set podataka, i kreirati xlsx ili xls fajl koji je popunjen podacima potrebnim za registraciju 30 korisnika.

➔	Registrovati 30 osoba, pri čemu se podaci o svakoj osobi čitaju iz xlsx ili xls fajla. Za svaku osobu proveriti da li je registracija bila uspešna.

➔	Testirati logovanje korisnika ukoliko to nije urađeno prethodnim koracima.

➔	Testirati dodavanje 5 proizvoda - potrebno je popuniti samo osnovne podatke. (Potrebne podatke učitati iz xlsx ili xls fajla, kreirati proizvode i proveriti da li je njihovo kreiranje uspešno).

➔	Povećati cenu prethodno kreiranih proizvoda za 100 i proveriti uspešnost izmena.

➔	Napisati Bug Report i popuniti ga koristeći informacije pronadjene automatskim i manuelnim testiranjem.

➔	Bonus:
◆	Napraviti jedan test suite pomoću koga će se pokrenuti testovi iz svih TestNG klasa.
◆	Umesto Java projekta, napraviti Maven projekat.
