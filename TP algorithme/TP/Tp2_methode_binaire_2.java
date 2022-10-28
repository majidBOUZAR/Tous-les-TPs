package majid;

import sun.security.util.Length;

// Methode binaire x^n calcule de complexité
// T(n) = log2(n)+v(n)-1

public class Tp2_methode_binaire_2 {
  
    public static int b=0, i=0, v=0, resultat, comp=0 ;
    
    public static int MethodeBinaire (int x , int n){
        System.out.println("X: "+x+" n: "+n);
        String s = Integer.toBinaryString(n);
        
        char [] t= s.toCharArray();
        // Calculer v(n)
        while(b<t.length){ if(t[b]=='1')  {v++;}   b++; }
        
        System.out.println("n en binaire: "+s);
        
        // Remplacer les 1 par SX et les 0 par X
        
        String j = s.replaceAll("1", "SX").replaceAll("0", "S");
        System.out.println(j);
        
        // Supprimer le premier SX
        
        String f =j.substring(1).substring(1);
        System.out.println(f);
        resultat = x;
        char [] tab = f.toCharArray();
        while (i<tab.length){
            
                if (tab[i]=='S'){ 
                    resultat=resultat*resultat;
                    comp++;
                   
                }
                else if (tab[i]=='X'){
                    resultat = resultat*x;
                    comp++;
                                
                }
                    i++;  }
        return resultat;
    }

    // Calcule de compléxité Théorique
    // Fonction Log    
    public static double Log(int n){
        
          double log =  Math.log(n);         
          double log2 = Math.log(2.0);
          double  log3=(log/log2);
	  double Log_Fin=log3+v-1;
          return Log_Fin;
          
    }
     
    public static void main(String[] args) {
        int k = 4;
        System.out.println("Resultat: "+MethodeBinaire(2,k));
        System.out.println("Complexité: "+comp);
        System.out.println("log(n)+v(n)-1 = "+Log(k));
     
}}
    
