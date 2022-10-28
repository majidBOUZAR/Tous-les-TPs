package majid;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tp4_Tri_par_insertion {
public static int comp;
public static int[] listEntier  = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
public static int[] listEntier2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
public static int[] listEntier3 = { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 };

static String iff = Arrays.toString(listEntier);
static String iff2 = Arrays.toString(listEntier2);
static String iff3 = Arrays.toString(listEntier3);


public static String TriInsertion(int[] list){
    int j,i,clé;
    comp = 0;
    for(j=1;j<list.length;j++){
      clé = list[j];
      i = j-1;
      
     while(i>=0 && list[i]>clé){
         int l2 = list[i+1]  ;
         int l1 = list[i];
         list[i+1] = l1 ;
         list[i] = l2  ;
         i = i - 1;
         comp++;
         }
    clé = list[i+1];  
    comp++;
    }
    
    String fin = Arrays.toString(list);
    
    return fin;
   }
public static void main(String[] args){
    System.out.println("Meilleur cas:");
    System.out.println("Liste--> "+iff);
    System.out.println("Trie de la liste: "+TriInsertion(listEntier));
    
    System.out.println("Complexité--> "+comp);
    System.out.println("\nPire cas ");
    System.out.println("Liste--> "+iff2);
    System.out.println("Trie de la liste: "+TriInsertion(listEntier2));
    System.out.println("Complexité--> "+comp);
    System.out.println("\n");
    System.out.println("Cas moyen--> "+iff3);
    System.out.println("Trie de la liste--> "+TriInsertion(listEntier3));
    System.out.println("Complexité--> "+comp);
    System.out.println("\n");

}
    
}
