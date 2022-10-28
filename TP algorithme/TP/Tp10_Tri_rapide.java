
package majid;

import java.util.Arrays;

public class Tp_10_Tri_rapide {
         public static int Comp = 0;
         
     public static void main(String[] args){
       int[] Tableau = {0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
       System.out.println("Avant tri : "+Arrays.toString(Tableau)); 
       Tri(Tableau);
       System.out.println("Après tri : "+Arrays.toString(Tableau));
       System.out.println("Complexité : "+Comp);  
       System.out.println("nLog(n) = "+(Tableau.length-1) * Math.log10(Tableau.length-1)/ Math.log(2));
   }
     
     public static void Tri(int[] Tab){
        int longeur = Tab.length;
        if(longeur>0){
            Tri_Rapide(Tab, 1, longeur-1);           
        }
    }
     public static void Tri_Rapide(int[] A,int p,int r){
         
         if(p<r){ 
              int q = Partitionnement(A,p,r);
              Tri_Rapide(A, p, q);
              Tri_Rapide(A, q+1, r);
         }
     }
     
     public static int Partitionnement(int[] A,int p,int r){
         
         int x = A[p];
         int i = p-1;
         int j = r+1;
         while(true){
             Comp++;
                do{
                    j--;
                }while(A[j]>x);

               
                do{
                    i++;
                }while(A[i]<x);   

                if(i<j){
                    int Echange = A[i];
                    A[i] = A[j];
                    A[j] = Echange;
                }
                else{
                    return j;
                }
         }
         
     }
}
