insert into polica (naziv,is_Primary) values('not read',true);
insert into polica(naziv, is_primary) values('read',true);
insert into zahtev_za_aktivaciju_naloga(email,telefon,datum,poruka,status) values('peraPetric@gmail.com','0641234567','2.2.2023','pls aktivirajte',2);
insert into zanr (naziv) values('drama');
insert into knjiga(broj_strana,datum_objavljivanja,isbn,naslov,naslovna_fotografija,ocena,opis) values(100,'1.2.1996',1234,'mars na drini','foto',10,'marsovci');
insert into korisnik(datum_rodjenja,ime,korisnicko_ime,lozinka,mail_adresa,opis,prezime,profilna_slika) values('1.1.1999','Dusan','DusanM','pass1234','email@gmail.com','pisac','mutuc','foto');
insert into recenzija(datum_recenzije,ocena,tekst,knjiga_ID,korisnik_id) values('10.2.2023',8,'vrlo dobra',1,1);
insert into knjiga(broj_strana,datum_objavljivanja,isbn,naslov,naslovna_fotografija,ocena,opis) values(90,'3.3.1954',1235,'drina na marsu','fotovideo',9,'drinovci');
insert into recenzija(datum_recenzije,ocena,tekst,knjiga_ID,korisnik_ID) values('1.3.2023',9,'odlicna knjiga',2,1);
insert into zanr(naziv) values('triler');
insert into knjiga_zanr(knjiga_id, zanr_id) values(1,1);
insert into knjiga_zanr(knjiga_id,zanr_id) values(2,2);
insert into recenzija_polica(recenzija_ID,polica_ID) values(1,1);
insert into recenzija_polica(recenzija_ID,polica_ID) values(2,2);

