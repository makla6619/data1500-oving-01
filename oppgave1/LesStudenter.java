// LesStudenter.java
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// 1. Definere en klasse for data fra en datafil om studenter basert på strukturen i data (se oppgavetekst i README.md)
// Velg egnede typer for felt i filen med studentinfo, f.eks. første felt kan være en int, siden den representerer id
// eller studentnummer. Andre felt, som representerer navn til studenten, kan være en String, for eksempel, osv.
class Student {
    // Skriv kode her ...
    int id;
    String navn;
    String program;

    public Student(int id, String navn, String program) {
        this.id = id;
        this.navn = navn;
        this.program = program;
    }

    // Metoden erstatter en eksisterende metode toString()  
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", navn=\'" + navn + "\', program=\'" + program + "\'}";
    }

}

// 2. Bruk try-with-resources for sikker filbehandling og les inn data fra fil i en Java datastruktur 
// ved bruk av Scanner, linje for linje, og til slutt skriv ut datafeltene til 
// stdout(System.out i Java)
public class LesStudenter {
    public static void main(String[] args) {
        File fil = new File(args[0]);

        try (Scanner leser = new Scanner(fil)) {
            while (leser.hasNextLine()) {
                // Tips: bruk leser.nextLine().split(",") for å splitte opp linje (post) i felt (leses inn i en String[])
                // Tips: sjekk at lengden til post er 3 (du trenger ikke å implementer else) 
                // Tips: ta inn det første feltet som int (forutsatt at datafeltet i klassen Student er int)
                // Skriv kode her ...
                // Tips: alloker Student-objekt for hver linje i filen med studentinfo (fullfør initialisering av objektet Student)
                String linje = leser.nextLine();
                String[] felt = linje.split(",");

                if (felt.length == 3) {
                    int id = Integer.parseInt(felt[0].trim());
                    String navn = felt[1].trim();
                    String program = felt[2].trim();
                    // Tips: alloker Student-objekt for hver linje i filen med studentinfo (fullfør initialisering av objektet Student)
                    Student s = new Student(id, navn, program);
                    // Tips: Skriv ut dataene med den overskrevede toString() metoden i klassen Student.
                    System.out.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Feil: Kunne ikke finne filen " + fil.getPath());
            e.printStackTrace();
        }
    }
}

/** Output skal være: 
{id=1Student01, navn='Mickey', program='CS'}
Student{id=102, navn='Daffy', program='EE'}
Student{id=103, navn='Donald', program='CS'}
Student{id=104, navn='Minnie', program='PSY'}
*/
