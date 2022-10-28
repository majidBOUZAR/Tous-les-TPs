package tp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;




public class Client 
{ 
	static Thread t1;
	static Thread t;
	static String pseudo="";
    @SuppressWarnings("deprecation")
	public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); //on initialise un scanner
  
 
        DatagramSocket clients = new DatagramSocket();  // on cree une socket udp
        byte buf[] = null; 
        InetAddress a = InetAddress.getByName("localhost");// on met l adresse local 127.0.0.1
        System.out.println("Entrez un pseudo ");
        String client = sc.nextLine();//on scanne la valeur
      
        buf = ("1 "+client+" ").getBytes();  // on stock la valeur en byte dans le tableau (pour l "1"et l'espace voir cote serveur)
        pseudo=new String(client);//on mais la valeur dans une chaine 
        DatagramPacket envoyer =new DatagramPacket(buf, buf.length,a, 2899); 
        clients.send(envoyer); //on envoie par le flux
        byte[] rec = new byte[10000]; 
        DatagramPacket  recu = new DatagramPacket(rec, rec.length);  
        clients.receive(recu);// on recois la cle hashmap connecter
        

        	String Liste=new String(rec);// on le stock la cle dans une chaine
        System.out.println("Serveur:"+" \n clients connecter\n" + Liste+"\n");  
        while(true) {
        System.out.println("1 ou 2 ou toute autre touche pour quitter:\n "
        		+"1-attentdre \n "        	
        		+"2-liste client \n"
        	);
        	
        client = sc.nextLine(); 
   
        if(client.equals("1")) {//mettre en attente 
        	   buf = ("attende: "+pseudo+" ").getBytes();    // envoyer pseudo pour le mettre en attetnte  (voir cote serveur  )
               envoyer =new DatagramPacket(buf, buf.length,a, 2899); 
              clients.send(envoyer); // envoie du flux
             rec = new byte[1000]; // tableau pour recevoir les message tchat d un autre client
            recu = new DatagramPacket(rec, rec.length); 
            clients.receive(recu);
            String[] nom = new String(recu.getData()).split(" ");// on split pour recuperer le pseudo dans nom[0]
            for (int i = 0; i < nom.length; i++) {
            	System.out.print(nom[i]); // boucle pour afficher le message
			}
           
           t = new Thread(new Runnable(){
                public void run(){
                   try {
               
                	   while(true) {
                	   byte[] rec = new byte[1001];
                	   DatagramPacket recu = new DatagramPacket(rec, rec.length); // tableau pour les prochain message  recevoir les message tchat d un autre client

                     clients.receive(recu);
              
                     String rec1 = new String(recu.getData()); //recu contient le message sans le pseudo
                   System.out.println(nom[0]+rec1);//on affiche le nom a cot� du message
                   String rec2= rec1.replaceAll("[^A-Za-z]+", "");// on nettoie rec1 pour tester rec2
                   if(rec2.equals("Adieu")) {// on teste si il contient Adieu
                       

                  	 t.stop();// on arrete le tchat
                   }
             
                   }
                   }catch (Exception e) {
    				// TODO: handle exception
    			}
                }
            });
            t.start();
            
            System.out.println("\n si tu veux quitter le chat �cris 'Adieu'\n"); 
            boolean cond=true;
        	while (cond) // boucle si le message est Adieu cond deviens faux
            {   
        	 
    
        	
            
                 client = sc.nextLine(); //on scanne le message 
                buf = client.getBytes();// on le met dans un tableau de byte 
            
                String[] sadrs=recu.getAddress().toString().split("/");//on split pour recuperer adr
                InetAddress adrs=InetAddress.getByName(sadrs[0]);//on initialise inet avec adr du client du tchat 
                DatagramPacket	 envoyer1 =new DatagramPacket(buf, buf.length,adrs, recu.getPort()); // on envoie le message 
             clients.send(envoyer1);  
                
             if (client.equals("Adieu")) {
        		 cond=false;	
        		 t.stop();
        }
            } 
  
            
        	
        }else if(client.equals("2")) {
        	 buf = ("choisir: "+" ").getBytes();    // le client va choisir avec qui tchater  
             envoyer =new DatagramPacket(buf, buf.length,a, 2899); //on envoie au serveur 
            clients.send(envoyer); 
            rec = new byte[30];
            recu = new DatagramPacket(rec, rec.length); 
          clients.receive(recu);//on recois la cle du hasmap attente 
          Liste=new String(rec);
        System.out.println("ecriver le pseudo  \n"+
          "Clients en attente\n"+ 
        		Liste+ 
        "\n");
         
        client = sc.nextLine(); //on scanne
        String nom =new String(client);
        buf = ("2 "+client+" "+pseudo+" ").getBytes();   //en envoi au serveur pour le tchat    
envoyer =new DatagramPacket(buf, buf.length,a, 2899); 
        clients.send(envoyer); 
        rec = new byte[50];
          recu = new DatagramPacket(rec, rec.length); 
        clients.receive(recu);
        String[] receives1 = new String(recu.getData()).split(" ");// on recois adr et le port du pseudo choisie

if(receives1[0].equals("Introuvable R�essayer")) {// condition si le pseudo choisie  n'existe pas
	
	System.err.println("Introuvable R�essayer");
}else {
      int port= Integer.valueOf(receives1[0]);//initialise le port
      String[] receives2=receives1[1].split("/");//initialise  adr 
        InetAddress adrs=InetAddress.getByName(receives2[0]);
        System.out.println("vous etes connecter avec  "+ client);
        boolean cond=true;
        while(cond) {
        client = sc.nextLine(); 
       
        buf = (pseudo+": "+client+" ").getBytes();  // on ajoute le pseudo en premier pour le recuperer voir plus haut
       
envoyer =new DatagramPacket(buf, buf.length,adrs, port); 
        clients.send(envoyer); // on envois le message au pseudo choisie
        cond=false;
        }
        t1 = new Thread(new Runnable(){
            public void run(){// comme vu precedemment on ouvre thread qui gere l envoie et un auter pour la reception avec adieu pour quittet
               try {
            	   while(true) {
            	   byte[] rec = new byte[1001];
            	   DatagramPacket recu = new DatagramPacket(rec, rec.length); 
                 clients.receive(recu);
                 String rec1 = new String(recu.getData());
                 System.out.println(nom+":"+rec1);
                 String rec2= rec1.replaceAll("[^A-Za-z]+", "");
                 if(rec2.equals("Adieu")) {
                    

                	 t1.stop();
                 }
              
       
               }
               }catch (Exception e) {
				// TODO: handle exception
			}
            }
        });
        t1.start();
        boolean cond1=true;
        while (cond1) 
        { 
        	
             client = sc.nextLine(); 
            buf = client.getBytes();  
           
    envoyer =new DatagramPacket(buf, buf.length,adrs, port); 
            clients.send(envoyer); 
            if (client.equals("Adieu"))  {
            	 cond1=false;
            	  t1.stop();
            }
             
        }

        }

    }else {
    	
    	System.out.println("voulez-vous vous d�connecter? (�crivez �oui� pour d�connect�)");// si le client veux ce deconncter (apres adieu)
    	client = sc.nextLine();
    
    	if(client.matches("oui")) {
    		   buf = ("sortie: "+pseudo+" ").getBytes();     // en envoie au serveur pour le mettre dans le hashmap deconnecter 
               envoyer =new DatagramPacket(buf, buf.length,a, 2899); 
              clients.send(envoyer); 
              clients.close();
    		break;
    	}
    }
    
        }
    }
    }
 