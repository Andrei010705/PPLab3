Problema 1

Pentru prima problema, solutia consta in preluarea datelor dintr-un fisier de tip XML disponibil online. Am utilizat biblioteca Jsoup pentru a realiza conexiunea la adresa specificata si pentru a extrage informatiile necesare. Pentru a respecta cerinta legata de crearea unor tipuri de date abstracte, am definit doua clase. Prima clasa stocheaza informatiile individuale pentru fiecare articol in parte, iar a doua reprezinta intregul canal, incluzand titlul principal si lista cu toate articolele. La final, programul parcurge lista de articole si afiseaza pe ecran doar titlul si adresa web aferenta fiecarui element.

Problema 2

In cazul acestei probleme, scopul este procesarea unui text brut care contine spatii si randuri libere in exces, precum si numere de pagina nedorite. Solutia se bazeaza pe o functie care aplica o serie de expresii regulate pentru a filtra textul. O prima expresie elimina spatiile consecutive inutile, in timp ce o alta reduce randurile goale la o singura trecere la rand nou. De asemenea, a fost adaugata o regula specifica pentru a identifica si sterge numerele de pagina izolate intre spatii. Suplimentar, am inclus o operatiune de inlocuire la final pentru a corecta literele scrise cu formate vechi.

Problema 3

Rezolvarea acestei probleme implica realizarea unui program care exploreaza pagini web pentru a extrage legaturi. Am implementat o structura de tip arbore, definind o clasa care retine adresa curenta si o lista cu adresele derivate. Functia principala este recursiva. Aceasta acceseaza pagina, identifica toate legaturile folosind Jsoup si continua cautarea doar pentru adresele care apartin aceluiasi domeniu. Pentru a preveni o executie infinita, cautarea se opreste strict la nivelul al doilea de adancime. In incheiere, o functie de serializare parcurge arborele format si il afiseaza pe ecran, adaugand un marcaj vizual simplu pentru a evidentia clar ierarhia adreselor.