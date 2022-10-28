
package majid;

public class Tp1_algortihme_trivial {

//Algo trivial x^n calcule de complexité
//T(n) = n-1
   
public static int comp=0;

	public static int Puissance(int x,int n) {
		

                int resultat;
                
               
                int i = 1;

                resultat = x;
                while (i<n){

                resultat = resultat * x;
                i = i+1;
                comp++;
                }
		return resultat;
        }
		


	public static void main(String[] args) {

		System.out.println("Résultat: "+Puissance(7,9));
                System.out.println("Complexité: "+comp);
                
		
		
		
	}
    }


