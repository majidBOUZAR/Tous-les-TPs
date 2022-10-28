package majid;

public class Tp7_Multiplication_Matrice {
    
    //Multiplication de deux matrice carrée 
    //T(n) = O(n^3)
    
   public static int comp = 0;
    public static void main(String[] args){
   
    int[][] matrice1 = {
        {5,6,9},
        {8,7,4},
        {8,5,2},};
    int[][] matrice2 = {
        {8,2,1},
        {4,6,3},
        {2,9,9},};
    int[][] matrice3 = new int[3][3];
    
    for (int i = 0; i < matrice1.length; i++)
    {
        for (int j = 0; j < matrice1[i].length; j++) {
             matrice3[i][j]=0;
            for (int k = 0; k <matrice1[j].length;k++){
                 matrice3[i][j] += matrice1[i][k] * matrice2[k][j]; 
                 comp++;
            }
        }
    }
    
        System.out.println("Matrice 1:");
        System.out.println(matrice1[0][0]+" "+matrice1[0][1]+" "+matrice1[0][2]);
        System.out.println(matrice1[1][0]+" "+matrice1[1][1]+" "+matrice1[1][2]);
        System.out.println(matrice1[2][0]+" "+matrice1[2][1]+" "+matrice1[2][2]);
        
        System.out.println("\nMatrice 2:");
        System.out.println(matrice2[0][0]+" "+matrice2[0][1]+" "+matrice2[0][2]);
        System.out.println(matrice2[1][0]+" "+matrice2[1][1]+" "+matrice2[1][2]);
        System.out.println(matrice2[2][0]+" "+matrice2[2][1]+" "+matrice2[2][2]);

        System.out.println("\nMatrice 3:");
        System.out.println(matrice3[0][0]+" "+matrice3[0][1]+" "+matrice3[0][2]);
        System.out.println(matrice3[1][0]+" "+matrice3[1][1]+" "+matrice3[1][2]);
        System.out.println(matrice3[2][0]+" "+matrice3[2][1]+" "+matrice3[2][2]);
        
        System.out.println("\nComplexité pratique --> "+comp);
        System.out.println("Complexité théorique --> "+Math.pow(matrice3.length, 3));
}
}