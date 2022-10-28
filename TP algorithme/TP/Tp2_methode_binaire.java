package majid;

// Methode binaire x^n calcule de complexité
// T(n) = log2(n)+v(n)-1

public class Tp2_methode_binaire {


public static int comp=0;
  static double log,log2;
  static int i = 1, v = 1;
    public static String ToBinaire (int n){
		
         String s = Integer.toBinaryString(n);  
         return s;
    }
  
  
    public static int MethodeBinaire (int x, int n){
  
       
        if (n==0){
            return 1;
        }
        else{
            char [] bin = ToBinaire(n).toCharArray();
           
            int resultat = x;
            
            while (i<bin.length){
                if (bin[i]=='0'){ 
                    resultat=resultat*resultat;
                    comp++;
                }
                else if (bin[i]=='1'){
                    resultat = resultat*resultat*x;
                    comp = comp + 2;
                    v++;
                }
                    i++;
                  
         
           
                }
            return resultat;
            }
        }
       
 // Calcule de compléxité Théorique   
    public static double Log(int n){
        
          log =  Math.log(n);
          log2 = Math.log(2.0);
        
          double  log3=(log/log2);
        
	  double Log_Fin=log3+v-1;
          
          return Log_Fin;
    }
       
   
         
    
        
    
    
    public static void main(String[] args){
        
        
        System.out.println("Résultat: "+MethodeBinaire(2, 23));
        
        System.out.println("Complexité "+comp);
  
        System.out.println("log(n)+v(n)-1 = "+Log(23));
    }


    
}
