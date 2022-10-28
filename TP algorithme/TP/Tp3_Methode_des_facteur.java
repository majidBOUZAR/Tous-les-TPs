package majid;

public class Tp3_Methode_des_facteur {
   
    public static int comp=0,p,n2;
    
    public static boolean premier(int n){
	
        if(n<=1)   return false;
               
        for(int i=2;i*i<=n;i++)
            if (n%i==0){ return false; }
       
        return true;
	}
    
    public static int plus_petit_diviseur_premier(int n){ 

            for(p=2;p<=n;p++){
                if (n%p==0 && premier(p))
                {
                    n2 = n/p;
                    return p;
                }
            }
            
            return n;
	}
    
    
    public static int MethodeFacteur(int x, int n){
        if (n==1) {  
            return x;
        }    
        else if (premier(n)){ 
            comp++;  
            return MethodeFacteur(x, n-1) * x ;   
        }        
        else if (plus_petit_diviseur_premier(n)==p){ 
              
            return MethodeFacteur(MethodeFacteur(x,p),n2);  
        }
	
          return 0;  
       }
    
    
    public static void main(String[] args){
       int x = 2;
       int n = 23;
       System.out.println("X--> "+x+", n--> "+n);
        
       System.out.println("Resultat--> "+MethodeFacteur(x, n));
 
       System.out.println("Complexité--> "+comp);
        
     
    }
    
}
