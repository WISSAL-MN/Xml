import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StaXWritterContact writer = new StaXWritterContact();
        writer.setFile("mescontacts.xml");



        System.out.print("Combien de contact voulez-vous ajouter ? ==> ");
        String nombre = sc.nextLine();

            try {
                writer.saveContacts(Integer.parseInt(nombre));
                System.out.println("les " + nombre + " ont été bien sauvgardé");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }

