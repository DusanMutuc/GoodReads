insert into zanr (naziv) values('drama');
insert into korisnik(datum_rodjenja,ime,korisnicko_ime,lozinka,email,opis,prezime,profilna_slika,uloga) values('1999-1-1','Dusan','DusanM','pass1234','email@gmail.com','pisac','mutuc','foto','ADMINISTRATOR');
insert into polica (naziv, primarna,korisnikID) values('Want to Read',true,1);
insert into polica(naziv, primarna,korisnikID) values('Currently Reading',true,1);
insert into polica(naziv, primarna,korisnikID) values('Read',true,1);
insert into Autor(aktivan,id) values(true,1);
insert into korisnik(datum_rodjenja,ime,korisnicko_ime,lozinka,email,opis,prezime,profilna_slika) values('2012-12-12','Kraj','Svetic','Gotovo','finalniDan@gmail.com','ende','sveta','foto');
insert into polica (naziv,primarna,korisnikID) values('Want to Read',true,1);
insert into polica(naziv, primarna,korisnikID) values('Currently Reading',true,1);
insert into polica(naziv, primarna,korisnikID) values('Read',true,1);
insert into polica(naziv, primarna,korisnikID) values('za mracne dane',false,1);
insert into zahtev_za_aktivaciju_naloga(email,telefon,datum,poruka,status,autor_ID) values('peraPetric@gmail.com','0641234567','2023-2-2','pls aktivirajte',2,1);
insert into knjiga(broj_strana,datum_objavljivanja,isbn,naslov,naslovna_fotografija,ocena,opis,autorid) values(100,'1996-1-2',1234,'mars na drini','foto',10,'marsovci',1);
insert into recenzija(datum_recenzije,ocena,tekst,korisnik_id) values('2023-2-10',8,'vrlo dobra',1);
insert into knjiga(broj_strana,datum_objavljivanja,isbn,naslov,naslovna_fotografija,ocena,opis,autorid) values(90,'1954-3-3',1235,'drina na marsu','fotovideo',9,'drinovci',1);
insert into recenzija(datum_recenzije,ocena,tekst,korisnik_ID) values('2023-1-3',9,'odlicna knjiga',2);
insert into zanr(naziv) values('triler');
insert into knjiga_zanr(knjiga_id, zanr_id) values(1,1);
insert into knjiga_zanr(knjiga_id,zanr_id) values(2,2);
insert into stavka(knjiga_id,recenzija_id,polica_id) values(1,1,1);
insert into stavka(knjiga_id,recenzija_id,polica_id) values(1,2,2);
insert into zanr (naziv) values('testBrisanje');



