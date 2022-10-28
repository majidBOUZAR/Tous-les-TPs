
package rc4;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class rc4_128_256 {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            
            boolean saisie = false;
            
            System.out.println("RC4 - Tapez: ");
            System.out.println(" 1. Chifré un fichier;");
            System.out.println(" 2. Test Chiffrement 16 octets(128 bits);");
            System.out.println(" 3. Test Chiffrement 32 octets(256 bits).");
            System.out.println();

            System.out.print("Choix: ");
            int choix = sc.nextInt();

            byte[] texte_claire = "ZITOUNI Bel Abbès Mokhtar".getBytes();
            byte[] texte_chifré, texte_déchiffré;
            int longueur = 128;

            if (choix == 1) {

                System.out.print("Emplacement (ex: C:\\Users\\omar\\Desktop\\test.txt): ");
                String fichier = "C:\\Users\\omar\\Desktop\\test.txt";
                fichier = sc.next();

                texte_claire = Files.readAllBytes(FileSystems.getDefault().getPath(fichier));

                System.out.print("Clé [16/32 octets(128/256 bits)]: ");
                byte[] clé_ = sc.next().getBytes();

                System.out.println("Texte claire: " + new String(texte_claire));
                RC4 rc4_ = new RC4(clé_, longueur);
                texte_chifré = rc4_.chiffré(texte_claire);
                System.out.println("Texte chiffré: " + new String(texte_chifré));

                RC4 _rc4_ = new RC4(clé_, longueur);
                texte_déchiffré = _rc4_.déchiffré(texte_chifré);
                System.out.println("Texte déchiffré: " + new String(texte_déchiffré));
                System.out.println("Déchiffrement avec succés: " + ((Arrays.equals(texte_claire, texte_déchiffré)) ? "vrai" : "faux"));

            } else if (choix == 2) {

                byte[] clé = "0123456789ABCDEF".getBytes();
                
                if (saisie == true) {
                    System.out.print("Clé [16 octets(128 bits)]: ");
                    clé = sc.next().getBytes();
                } else {
                    System.out.println("Clé [16 octets(128 bits)]: " + new String(clé));
                }

                System.out.println("Texte claire: " + new String(texte_claire));
                RC4 rc4 = new RC4(clé, longueur);
                texte_chifré = rc4.chiffré(texte_claire);
                System.out.println("Texte chiffré: " + texte_chifré.toString());

                RC4 _rc4 = new RC4(clé, longueur);
                texte_déchiffré = _rc4.déchiffré(texte_chifré);
                System.out.println("Texte déchiffré: " + new String(texte_déchiffré));
                System.out.println("Déchiffrement avec succés: " + ((Arrays.equals(texte_claire, texte_déchiffré)) ? "vrai" : "faux"));

            } else if (choix == 3) {

                byte[] _clé = "0123456789ABCDEF0123456789ABCDEF".getBytes();
                
                if (saisie == true) {
                    System.out.print("Clé [32 octets(256 bits)]: ");
                _clé = sc.next().getBytes();
                } else {
                    System.out.println("Clé [32 octets(256 bits)]: " + new String(_clé));
                }

                System.out.println("Texte claire: " + new String(texte_claire));
                RC4 rc4_ = new RC4(_clé, longueur);
                texte_chifré = rc4_.chiffré(texte_claire);
                System.out.println("Texte chiffré: " + texte_chifré.toString());

                RC4 _rc4_ = new RC4(_clé, longueur);
                texte_déchiffré = _rc4_.déchiffré(texte_chifré);
                System.out.println("Texte déchiffré: " + new String(texte_déchiffré));
                System.out.println("Déchiffrement avec succés: " + ((Arrays.equals(texte_claire, texte_déchiffré)) ? "vrai" : "faux"));

            }
            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println();
        }
        
    }
    
}