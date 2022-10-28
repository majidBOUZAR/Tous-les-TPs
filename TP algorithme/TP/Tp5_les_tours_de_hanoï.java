package majid;

import java.util.Scanner;

public class Tp5_les_tours_de_hanoï {

    // Tours de hanoï 
    // T(n) = 2^n-1 + 2^n-2 ..... + 2^2 + 2^1 + 2^0
    
    public static int comp=0;

    public static void main(String[] args){
        System.out.println("Entrer le nombre de disques");
        Scanner scanner = new Scanner(System.in);
        int disques = scanner.nextInt();
        System.out.println("Le nombre de disque = "+disques);
        Hanoï(disques, "1", "2", "3");
        System.out.println("Complexité pratique --> "+comp);
        System.out.println("Complexité théorique --> "+complexité_théorique(disques));
        
    }

// Methode des tours de hanoï
    public static void Hanoï(int n,String départ,String intermédiaire,String destination){
        if (n == 0){
            System.out.println("Le nombre de disque est zero");
        } 
        if (n == 1){ 
            comp++;
            System.out.println(départ+" --> "+destination);
        }
        
        else{ 
            Hanoï(n-1, départ, intermédiaire, destination);
            System.out.println(départ+" --> "+intermédiaire);
            Hanoï(n-1, intermédiaire, départ, destination);
            comp++;
        }
    }
    
// Calcule de compléxité Théorique
    public static double complexité_théorique(int n){
        double resultat = 0;
        double i = 0;
        while (i<n){
            resultat = resultat + Math.pow(2, i);
            i++;
        }
        return resultat;
    }


    
    
}
