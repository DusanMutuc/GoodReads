insert into zanr (naziv) values('Drama');
insert into zanr(naziv) values('Thriller');
INSERT INTO zanr (naziv) VALUES ('Romance');
INSERT INTO zanr (naziv) VALUES ('Science Fiction');
INSERT INTO zanr (naziv) VALUES ('Fantasy');
INSERT INTO zanr (naziv) VALUES ('Mystery');
INSERT INTO zanr (naziv) VALUES ('Biography');
INSERT INTO zanr (naziv) VALUES ('Historyical Fiction');
INSERT INTO zanr (naziv) VALUES ('Science');
INSERT INTO zanr (naziv) VALUES ('Horror');
insert into korisnik(datum_rodjenja,ime,korisnicko_ime,lozinka,email,opis,prezime,profilna_slika,uloga) values('1999-1-1','Dusan','DusanM','pass1234','email@gmail.com','pisac','mutuc','foto','ADMINISTRATOR');
insert into polica (naziv, primarna,korisnikID) values('Want to Read',true,1);
insert into polica(naziv, primarna,korisnikID) values('Currently Reading',true,1);
insert into polica(naziv, primarna,korisnikID) values('Read',true,1);
insert into korisnik(datum_rodjenja,ime,korisnicko_ime,lozinka,email,opis,prezime,profilna_slika,uloga) values('2012-12-12','Kraj','Svetic','Gotovo','finalniDan@gmail.com','ende','sveta','foto','AUTOR');
insert into Autor(aktivan,id) values(true,1);
insert into Autor(aktivan,id) values(true,2);
insert into polica (naziv,primarna,korisnikID) values('Want to Read',true,2);
insert into polica(naziv, primarna,korisnikID) values('Currently Reading',true,2);
insert into polica(naziv, primarna,korisnikID) values('Read',true,2);
insert into polica(naziv, primarna,korisnikID) values('za mracne dane',false,1);
-- Book 1: Drama
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (320, '2018-04-15', '978-0316438962', 'The Great Gatsby', 'great_gatsby.jpg', 4.5, 'A classic novel by F. Scott Fitzgerald depicting the Jazz Age.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (1, 1);

-- Book 2: Thriller
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (432, '2015-06-23', '978-0062429657', 'Gone Girl', 'gone_girl.jpg', 3.8, 'A gripping psychological thriller by Gillian Flynn.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (2, 2);

-- Book 3: Romance
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (384, '2010-09-14', '978-0141036137', 'Pride and Prejudice', 'pride_prejudice.jpg', 4.2, 'Jane Austen''s classic love story of Elizabeth Bennet and Mr. Darcy.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (3, 3);

-- Book 4: Science Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (512, '2003-04-29', '978-0385504201', 'Dune', 'dune.jpg', 4.1, 'A science fiction masterpiece by Frank Herbert set in a distant future.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (4, 4);

-- Book 5: Fantasy
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (336, '2017-05-02', '978-0735211209', 'Harry Potter and the Sorcerer''s Stone', 'harry_potter.jpg', 4.6, 'The first book in the beloved Harry Potter series by J.K. Rowling.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (5, 5);

-- Book 6: Mystery
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (448, '2019-02-26', '978-1250182296', 'The Girl with the Dragon Tattoo', 'girl_dragon_tattoo.jpg', 4.3, 'A gripping mystery novel by Stieg Larsson.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (6, 6);

-- Book 7: Biography
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (400, '2014-11-18', '978-0062225679', 'The Diary of a Young Girl', 'diary_young_girl.jpg', 4.7, 'The personal diary of Anne Frank, a Jewish girl hiding during the Holocaust.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (7, 7);

-- Book 8: Historical Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (689, '2009-02-10', '978-0345505340', 'The Help', 'the_help.jpg', 4.5, 'A story set in 1960s Mississippi, highlighting the lives of African American maids.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (8, 8);

-- Book 9: Science
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (464, '2011-09-13', '978-1451695731', 'The Immortal Life of Henrietta Lacks', 'henrietta_lacks.jpg', 4.6, 'An exploration of the impact of Henrietta Lacks''s cells on medical science and ethics.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (9, 9);

-- Book 10: Horror
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (512, '2005-10-17', '978-0743287728', 'The Shining', 'the_shining.jpg', 4.5, 'A chilling horror novel by Stephen King about a haunted hotel.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (10, 10);
-- Book 11: Drama
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (368, '2016-07-12', '978-1501145246', 'The Fault in Our Stars', 'fault_in_our_stars.jpg', 4.3, 'A heart-wrenching story of two teenagers with cancer who fall in love.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (11, 1);

-- Book 12: Thriller
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (416, '2012-05-22', '978-0385535501', 'The Girl on the Train', 'girl_on_train.jpg', 3.9, 'A gripping psychological thriller by Paula Hawkins.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (12, 2);

-- Book 13: Romance
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (432, '2004-09-01', '978-0743496710', 'Outlander', 'outlander.jpg', 4.5, 'A time-traveling historical romance by Diana Gabaldon.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (13, 3);

-- Book 14: Science Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (384, '1985-06-01', '978-0441013593', 'Neuromancer', 'neuromancer.jpg', 4.1, 'A groundbreaking cyberpunk novel by William Gibson.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (14, 4);

-- Book 15: Fantasy
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (688, '1990-09-18', '978-0812521396', 'Assassin''s Apprentice', 'assassins_apprentice.jpg', 4.4, 'The first book in Robin Hobb''s epic fantasy series, The Farseer Trilogy.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (15, 5);

-- Book 16: Mystery
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (352, '2007-06-26', '978-0307353148', 'The Thirteenth Tale', 'thirteenth_tale.jpg', 4.1, 'A gothic mystery novel by Diane Setterfield.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (16, 6);

-- Book 17: Biography
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (576, '2008-10-28', '978-0061357901', 'Steve Jobs', 'steve_jobs.jpg', 4.2, 'A biography of Steve Jobs, the co-founder of Apple Inc., by Walter Isaacson.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (17, 7);

-- Book 18: Historical Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (480, '2014-05-06', '978-0062356260', 'All the Light We Cannot See', 'all_the_light_we_cannot_see.jpg', 4.3, 'A captivating historical fiction set during World War II, written by Anthony Doerr.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (18, 8);


-- Book 19: Science
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (464, '2011-09-27', '978-1451627297', 'Sapiens: A Brief History of Humankind', 'sapiens.jpg', 4.6, 'A thought-provoking exploration of human history and civilization by Yuval Noah Harari.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (19, 9);

-- Book 20: Horror
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (384, '1986-09-15', '978-0451169518', 'It', 'it.jpg', 4.4, 'A chilling horror novel by Stephen King.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (20, 10);

-- Book 21: Drama
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (352, '2004-08-01', '978-0552771055', 'The Kite Runner', 'the_kite_runner.jpg', 4.5, 'A gripping tale of friendship and redemption set in Afghanistan, written by Khaled Hosseini.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (21, 1);

-- Book 22: Thriller
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (432, '2018-01-09', '978-0735219090', 'The Woman in the Window', 'the_woman_in_the_window.jpg', 4.0, 'A gripping psychological thriller by A.J. Finn.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (22, 2);

-- Book 23: Romance
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (352, '2003-05-01', '978-0060096195', 'The Notebook', 'the_notebook.jpg', 4.2, 'A heartwarming love story by Nicholas Sparks.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (23, 3);

-- Book 24: Science Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (400, '1961-06-01', '978-0441413593', 'Stranger in a Strange Land', 'stranger_in_a_strange_land.jpg', 4.0, 'A science fiction novel by Robert A. Heinlein.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (24, 4);

-- Book 25: Fantasy
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (896, '1996-07-01', '978-0345402886', 'A Game of Thrones', 'game_of_thrones.jpg', 4.4, 'The first book in the epic fantasy series "A Song of Ice and Fire" by George R.R. Martin.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (25, 5);

-- Book 26: Mystery
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (416, '2012-01-03', '978-0143123624', 'Gone Girl', 'gone_girl.jpg', 4.0, 'A gripping psychological thriller by Gillian Flynn.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (26, 6);

-- Book 27: Biography
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (528, '1999-02-01', '978-0671037137', 'Tuesdays with Morrie', 'tuesdays_with_morrie.jpg', 4.5, 'A memoir by Mitch Albom about his conversations with his former college professor, Morrie Schwartz.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (27, 7);

-- Book 28: Historical Fiction
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (528, '2003-01-28', '978-0670888620', 'The Book Thief', 'the_book_thief.jpg', 4.4, 'A historical fiction novel set in Nazi Germany, written by Markus Zusak.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (28, 8);

-- Book 29: Science
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (352, '2017-09-05', '978-1250144284', 'Astrophysics for People in a Hurry', 'astrophysics_for_people_in_a_hurry.jpg', 4.5, 'A popular science book by Neil deGrasse Tyson that explores the fundamental concepts of astrophysics in a concise and accessible manner.', 1);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (29, 9);

-- Book 30: Horror
-- Book 30: Horror
INSERT INTO knjiga(broj_strana, datum_objavljivanja, isbn, naslov, naslovna_fotografija, ocena, opis, autorid)
VALUES (432, '2014-04-15', '978-1476714813', 'Bird Box', 'bird_box.jpg', 4.2, 'A gripping horror novel by Josh Malerman, where unseen entities drive people to deadly violence if they catch a glimpse of them.', 2);
INSERT INTO knjiga_zanr(knjiga_id, zanr_id) VALUES (30, 10);





insert into zahtev_za_aktivaciju_naloga(email,telefon,datum,poruka,status,autor_ID) values('peraPetric@gmail.com','0641234567','2023-2-2','pls aktivirajte','NACEKANJU',1);
insert into recenzija(datum_recenzije,ocena,tekst,korisnik_id) values('2023-2-10',8,'vrlo dobra',1);
insert into recenzija(datum_recenzije,ocena,tekst,korisnik_ID) values('2023-1-3',9,'odlicna knjiga',2);
insert into stavka(knjiga_id,recenzija_id,polica_id) values(1,1,7);
insert into stavka(knjiga_id,recenzija_id,polica_id) values(1,2,7);


