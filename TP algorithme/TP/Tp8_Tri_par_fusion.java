package majid;

import java.util.Arrays;

public class Tp8_Tri_par_fusion {

    //Tri par fusion
    //T(n) = nlogn
    
   public static int comp=0;
    public static void main(String[] args){        
        int[] Tableau = { 10, 9, 8, 7 , 6 , 5 ,4 ,3 ,2 ,1 };
        System.out.println("Avant tri : "+Arrays.toString(Tableau));
        Tri(Tableau);
        System.out.println("Après tri : "+Arrays.toString(Tableau));
        System.out.println("Complexité : "+comp);
        System.out.println("nLog(n) = "+Tableau.length * Math.log(Tableau.length));
        
    }

        public static void Tri(int[] values) {
                int number;
                number = values.length;   
                Tri_Fusion(values,0, number -1);
        }

        public static void Tri_Fusion(int[] A,int p, int r) {
                
                if (p < r){
                    int q = (r + p) / 2;
                    Tri_Fusion(A, p, q);
                    Tri_Fusion(A, q+1, r);
                    Fusion(A, p, q, r);
                }
        }

        public static void Fusion(int[] A,int p, int q, int r) {

            int[] C = new int[A.length];
            
                int i = p;
                int j = q + 1;
                int k = p;
                
                while (i <= q && j <= r) {
                       comp++; 
                    if (A[i] <= A[j]) {
                                C[k] = A[i];
                                i++;
                                
                        } else {
                                C[k] = A[j];
                                j++;
                                                               
                        }    
                                           
                        k++;
                }
                
                while (i <= q) {
                        C[k] = A[i];
                        i++;
                        k++;
                        comp++;
                }
                
                while (j <= r) {
                        C[k] = A[j];
                        j++;
                        k++;
                        comp++;
                }
                
                for(k=p;k<=r;k++){
                    A[k]=C[k];
            
                }

        }

}
