
package majid;

public class Tp_11_Programmation_Dynamique {
    
     static int comp=0, comp2=0, comp3=0;
     static int [][] Resultat;
//*****************************Chaine de matrice recursif**********************     
    public static int chaineDeMatrice_Recursif(int p [],int i,int j){  

             int [][] m = new int [7][7];
             int q;
             if (i==j){return 0;}
   
             m[i][j]=17000;
            for( int k=i;k<=(j-1);k++){
                comp++;
             q=chaineDeMatrice_Recursif(p,i,k )
                     +chaineDeMatrice_Recursif(p,k+1,j )
                     +(p[i-1]*p[k]*p[j]);
              if(q<m[i][j]){
              m[i][j]=q;
              
            }
           System.out.println("M["+i+"]["+j+"] egale :"+m[i][j]);
            }
    
    return   m[i][j];
    }
    
 //*****************************Ordonner chaine de matrice**********************    
    
    public static int Ordonner_ChaineDeMatrice(int []p){
        
        int [] [] m = new int [7][7] ;
        int [] [] s = new int [7][7] ;
        
        int n=p.length-1;
              
          int j=0;
          int i=0;
          
          for( i=1;i<=n;i++){
           m[i][i]=0;
           
         for( int l=2;l<=n;l++){    
          for(i=1;i<=n-l+1;i++){
             j=i+l-1; 
             m[i][j]=150000;
        for( int k=i;k<=(j-1);k++){
       
         comp2++;
           int q  = m[i][k]
                 + m[k+1][j]
                 +p[i-1]*p[k]*p[j];
   
           if(q<m[i][j]){
      
           m[i][j]=q; 
           
           s[i][j]=k;
      
           System.out.println("m="+m[i][j]+", s="+s[i][j]); 
           
  }
       }
       
       }
   
      }
      return s[i][j];   
}       
       return s[i][j];
}
    

//*****************************Multiplier chaine de matrice********************** 
    
    public static int[][] Multiplier_ChaineDeMatrice(int A[][], int s[][],int i, int j) {
         
        if(j>i){
             int M1[][] = Multiplier_ChaineDeMatrice(A, s, i, s[i][j]);
             int M2[][] = Multiplier_ChaineDeMatrice(A, s,s[i][j]+1, j);
             Resultat = Multiplier_Matrice(M1, M2);
             System.out.println("Résultat = "+Resultat);
         }
    
         return Resultat;
    }
    

//*****************************Multiplier matrice**********************    
    public static int[][] Multiplier_Matrice(int M1[][], int M2[][]) {
         int i, j, k;
         int n = 4;
         int [] [] M = new int [n][n] ;
          
         for (i = 0; i <n  ; i++) {
            
            for (j = 0; j < n; j++) {
               
                M[i][j] = 0;
                for (k = 0; k < n; k++) {
                    M[i][j]= M[i][j] 
                            +M1[i][k] * M2[k][j];
                    comp3++;
                }
  
                System.out.print(M[i][j]+"  ");
            }  
              System.out.println("");
        }

        return M;
    }
    
    
public static void main(String[] args) {
    System.out.println("************Chaine de Matrice Récursif**************");    
         int p[]={30,35,15,5,10,20,25};
         chaineDeMatrice_Recursif(p,1,6);
         System.out.println("Complexité = "+comp+"\n");
         
    System.out.println("************Ordonner Chaine de Matrice**************");     
         int p2[]={30,35,15,5,10,20,25};
         Ordonner_ChaineDeMatrice(p2);
         System.out.println("Complexité = "+comp2+"\n");
    
    System.out.println("************Multiplier Chaine De Matrice**************");     
         int M1[][] ={{4, 6, 6, 5, 9},{6, 3, 2, 5, 4},{2, 3, 9, 5, 7},{2, 7, 5, 5, 4}};
         int M2[][] = {{8, 4, 6, 5, 2}, {2, 2, 1, 3, 7},{5, 4, 2, 2, 1},{1, 2, 1, 6, 2}};
       
       //Multiplier_ChaineDeMatrice(p3,S,1,6);  
       // Multiplier_Matrice(M1, M2);
       // System.out.println("Complexité = " +comp3+"\n");

}
}