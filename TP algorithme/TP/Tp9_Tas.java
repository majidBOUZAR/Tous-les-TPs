
package majid;

import java.util.Arrays;

public class Tp9_Tas {
    public static int taille;
    public static int comp= 0;
   public static void main(String[] args){
       int[] Tableau = {0,4,3,6,2,1,5,7};
       System.out.println("Avant tri : "+Arrays.toString(Tableau));
       Trier_Tas(Tableau);
       System.out.println("Après tri : "+Arrays.toString(Tableau));
       System.out.println("Complexité : "+comp);
       System.out.println("nLog(n) = "+(Tableau.length-1) * Math.log(Tableau.length-1)/Math.log(2));
   }
    
    public static int pere(int i){ return i/2; }
    public static int Fils_Gauche(int i){ return i*2; }
    public static int Fils_Droite(int i){ return (i*2)+1; }
    
    public static void Entasser(int[] A,int i){
        comp++;
        int g = Fils_Gauche(i);
        int d = Fils_Droite(i);
        int max = i;
        
        if( (g <= taille) && (A[g] > A[max]) ){ max = g; }
        if( (d <= taille) && (A[d] > A[max]) ){ max = d; }
        if(max != i){
            int echange = A[i];
            int echange2 = A[max];
            A[i] = echange2;
            A[max] = echange;
            Entasser(A, max);
        }
        
        
    }
    
    public static void Construire_Tas(int[] A){
        taille = A.length-1;
        for(int i=A.length/2; i>=1; i--){
            Entasser(A, i);
        }
    }
    
    public static void Trier_Tas(int[] A){
        
        Construire_Tas(A);
        
        for(int i=A.length-1; i>=2; i--){           
           int Y = A[1];
            A[1] = A[i]; 
            A[i] = Y;
            taille--;
            Entasser(A, 1);
        }
    }
}
