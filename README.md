# Proiect_3
<h2 align="center">Biblioteca</h2>
<p align="center">Proiectul reprezinta gestiunea unuei 
biblioteci unde poti imprumuta returna si interoga carti.
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Continut</summary>
  <ol>
    <li><a href="#about-the-project">Despre proiect</a>
    <li><a href="#descriere-detaliata">Descriere detaliata</a>
    <li><a href="#pachet-biblioteca">Pachet biblioteca</a>
    <li><a href="#fisiere-text">Fisiere text</a>
  </ol>
</details>

<!-- DESPRE PROIECT -->
## Despre proiect
Diagrama UML:

(https://lucid.app/lucidchart/a89fd03f-f7ef-4d9f-831d-9a779cd09aa1/edit?page=0_0&invitationId=inv_2f0211b3-86dd-4947-9a46-94bc53d770f0#)
 
 La inceputul programului, esti intampinat cu un mesaj "BINE
ATI VENIT LA BIBLIOTECA". Dupa apasarea butonului start, veti 
fi intrebat daca sunteti sau nu un utilizator nou. Daca sunteti
veti fi nevoit sa va introduceti datele personale mai intai. 
Dupa ce v-ati identificat, veti avea mai multe obtiuni, mai 
precis de a imprumuta, returna, interoga carti si de a iesi
din program. Pentru a imprumuta/returna trebuie sa introduceti
numarul de carti si id-ul carti/cartilor.Daca alegeti sa 
interogati cartile, veti putea vedea daca aveti sau nu carti
imprumutate, respectiv ce carti aveti imprumutate.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- DESCRIERE DETALIATA-->
## Descriere detaliata
La inceperea programului, este afisata o caseta de dialog cu
numele "BIBLIOTECA", in aceasta caseta este afisat textul
"BINE ATI VENIT LA BIBLIOTECA" si butonul "START".

Dupa apasarea butonului "START" apare o noua caseta de dialog
unde este adresata urmatoarea intrebare "SUNTETI UTILIZATOR
NOU?" si aveti 2 butoane de raspuns YES/NO.

Daca butonul apasat este "YES" atunci se va afisa o noua caseta,
unde utilizatorul va fi nevoit sa introduca datele personale
(ID, nume, initiala tatalui, prenume,universitate si judetul in
care se afla universitatea). In partea de jos a casetei sunt 2
butoane, unul pt "INREGISTRARE" si altul pt "INFO"(O caseta 
de dialog ce afiseaza un mesaj in care explica ce inseamna
ID-ului acesta reprezentand numarul matricol al studentului).

Daca butonul apasat este "NO" atunci se va afisa o noua caseta
de dialog in care utilizatorul va fi nevoid sa introduca ID-ul.

Atat pentru utilizatori noi cat si pentru utilizatori vechi,
odata ce s-au identificat, va aparea o noua caseta de dialog
unde vor avea diverse optiuni ("Imprumut", "Returnare",
"Interogare carti","Iesire"), acestea find reprezentate de 
niste butoane.

Atat pentru butonul "Imprumut" cat si pentru butonul 
"Returnare", va aparea o caseta de dialog unde li se va cere
introducerea numarului de carti si codul acestora. In functie 
de butonul apasat, acele carti vor fi imprumutate (se va cauta
cartea respectiva in lista de carti si va fi introdusa in alta
lista unde se afla cartile imprumutate de persoana respectiva).
sau returnate (se va cauta in lista de carti imprumutate ale
persoanei respective si odata ce va fi gasita aceasta se va 
sterge).

Daca butonul ales este "INTEROGARE CARTI" atunci se va afisa 
cartile pe care cititorul le are imprumutate, intr-o caseta de 
dialog.

Daca butonul ales este cel de iesire atunci utilizatorul
va fi scos din program.

<h4 align="center">Pachetul biblioteca</h4>
<h5 align="left">Clasa Carti</h5>

Clasa are 3 campuri cod(reprezentand codul unic al
carti), titlu si cnt(acesta este un contor).Aceasta clasa are 
metodele get/set si metoda toSting implementate.

<h5 align="left">Clasa Cititor</h5>

Clasa are 4 campuri numele si prenumele persoanei si
codInreg(codul de inregistrare) si un camp i care reprezinta
numarul de carti imprumutate.In aceasta clasa se afla 2 
constructori, o lista de carti, metodele get/set, o metoda 
toString, o metoda pentru imprumut, pentru returnare, pentru 
interogarea cartilor, o metoda care verifica sa nu ai mai 
mult de 2 carti imprumutate si o metoda care sterge lista 
de carti imprumutate.

<h5 align="left">Clasa StudentReader</h5>

Clasa extinde clasa cititor si are in plus campurile 
initiala tatalui, facultate si judetF(Reprezinta judetul in 
care se afla facultatea respectiva).Aceasta clasa are metodele
get/set si mosteneste metodele clasei Cititor si are
suprascrisa metoda toString.

<h5 align="left">Clasa Singleton</h5>

Aceasta clasa are urmatoarele campri Singleton(instanta),
dataFormat(formatul pe care il va avea data),ultima accesare
(aici se va inregistra data curenta). Aceasta are metodele
getInstanta, getUltimaAccesare si dataCurenta care afiseaza 
data si ora curenta.

<h4 align="center">Fisiere text</h4>
<h5 align="left">Carti.txt</h5>

In acest fisier se afla o lista de carti si datele despre
acestea (id-ul carti si numele).

<h5 align="left">Datacurenta.txt</h5>

In acest fiser se vor afisa datele curente efectuarii unui 
imprumut.





