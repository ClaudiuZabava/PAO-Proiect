# PAO-Proiect - Etapa 1

## Implementarea unui Catalog virtual.

### Tema aleasa se ocupa cu implementarea unui sistem de tip catalog virtual avand 2 tipuri de utilizatori ( student si profesor), si in care se retin liste de studenti asociate unor liste de profesori ce ii predau studentului diferite materii. Fiecare utilizator are date de contact si adresa retinute. Se retin si informatii despre materie, sala si notele obtinute de un anumit student.

#### Tipuri de obiecte (8):
- Utilizator
- Student
- Profesor
- Adresa
- Contact
- Materie
- Sala
- Catalog

#### Interogari:
- Pentru fiecare fila din catalog stim detaliile studentului
- Pentru fiecare fila din catalog stim detaliile profesorilor
- Pentru fiecare Student din catalog stim detaliile profesorilor sai de curs
- Pentru fiecare Fila de catalog vom stii GPA-ul total al Studentului asociat.
- Pentru fiecare Student cunoastem informatiile de contact
- Pentru fiecare Student cunoastem adresa
- Pentru fiecare Profesor cunoastem informatii de ocntact
- Pentru fiecare Profesor cunoastem adresa
- Pentru fiecare Profesor cunoastem materia predata
- Pentru orice student vom stii nota obtinuta separat la fiecare materie.
- Din fila de catalog putem gasi si informatii cu privire la sala fiecarei materii ale Studentului asociat.


Filele de catalog sunt sortate dupa ID folosind Comparable.

# PAO-Proiect - Etapa 2

#### Serviciile singleton:
Am folosit servicii singleton inca din prima etapa, sub forma:
```
    private static AppService instance;

    private Scanner scanner = new Scanner(System.in);

    private AppService(){}

    public static AppService get_Instance(){
        if(instance == null){
            instance = new AppService();
        }
        return instance;
    }
```
#### Fisiere CSV + Serviciu Read/Write:
Serviciile de citire si scriere din fisiere CSV pe care le-am adaugat sunt: WriteService, ReadService.
Fisierele CSV se afla in src/com/company/date.
Fisierele CSV au un header generat automat de serviciul de scriere.
Datele din fisier respecta headerul.

#### Colectiile: 
Collections -> List si HashSet  (am folosit List in clasele principale, in cadrul clasei catalog am folosit HashSet, dar si ArrayList in anumite Servicii).

#### tratare Erori:
Am tratat mare parte din exceptii ( si in etapa anterioara + exceptii ce pot aparea la citire sau scriere din fisier).

#### Incarcare si persistare date :
Daca fisierele CSV nu sunt goale, datele sunt incarcate automat la startul aplicatiei.
Datele adaugate in CSV persista si sunt reincarcate de fiecare data cand aplicatia porneste.




# PAO-Proiect - Etapa 3:

### Implementat Conexiune la DB.
### Functie care creaza automat baza de date in MySQL;
### Instalat Maven si Dependintele MySQL in MAVEN
### Se genereaza tabelele necesare bazei de date la pornirea aplicatiei ( pt prima oara).
### Acum Datele sunt salvate si in CSV dar se stocheaza dupa cheie si in baza de date
De mentionat, acum cand avem in tabela Student campul adresa, acolo se va retine un id_adresa de la oa adresa existenta in baza de date.
### Acum Datele sunt incarcate in aplicatie la start exclusiv din Baza de Date.
### Toate metodele de management a bazei de date si ale tabelelor corespunzatoare fiecarei clase se afla in DatabaseManager class.
### Avem metode de insertie ( INSERT) in baza de date, de selectie ( SELECT) si de delete (DELETE & ON DELETE CASCADE)

