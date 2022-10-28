package tp;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;




public class Serveur {
	public final static int port = 2899;//on initialise le port
	   
	   public static void main(String[] args) throws IOException{
		   
		    HashMap<String, String[]>att =new HashMap<String ,String[] >(); //les client  en attendant
		    HashMap<String, String[]>clientconnected =new HashMap<String ,String[] >();//les client connect�
		    HashMap<String, String[]>clientdisconnected =new HashMap<String ,String[] >();//les client d�connect�

		    DatagramSocket udp = new DatagramSocket(port); // on cree une socket udp
		    while(true) { 
		       byte[] buf = new byte[25]; // tableau de byte pour recevoir un message
	           DatagramPacket paquet = new DatagramPacket(buf, buf.length);//on cree un paquet pour pouvoir recevoir
	                            
	           udp.receive(paquet); // le flux pour recevoir les donnees
	           String[] str = new String(paquet.getData()).split(" ");// on separe les donnees on 2 pour avoir le pseudo sur str[1]

	           if(str[0].matches("1")) { // le if sert a differencier les traitement celui si sert pour le traitement du pseudo
	        	   
	        	   Thread t = new Thread(new Runnable(){ // on demarre un thread
	        	         public void run(){
		    try {
	                
	           
	           String[]p= {String.valueOf(paquet.getPort()),paquet.getAddress().toString()}; //on stock adr et le port on byte
	 
	        	   if(clientconnected.containsKey(str[1])==false){ //on teste si le pseudo existe deja
	        	   System.out.println("client "+str[1]);
	        	   clientconnected.put(str[1], p);// on l'ajoute au client connecter 
	        	   try {
	        	   clientdisconnected.remove(str[1]);// on le supprime des client deconnecter si c possible 
	        	   }catch (Exception e) {
					
				}
	        	   byte[] buf2 = new String(clientconnected.keySet() + " ").getBytes(); // on mais le pseudo de hashmap connecter dans le tableau on byte pour l'envoi
	        	   DatagramPacket paquet2 = new DatagramPacket(buf2,buf2.length,paquet.getAddress(),paquet.getPort()); //on cree un paquet pour l'envoi  
	               udp.send(paquet2);// le flux pour l'envoi  les donnees
	             
	           }else {// si le pseudo existe on ne l'ajoute pas
	        	   byte[] buf2 = new String("Est_deja_connect� ").getBytes();// en envoi un message comme quoi il existe deja (connecter)
	               DatagramPacket paquet2 = new DatagramPacket(buf2,buf2.length,paquet.getAddress(),paquet.getPort());
	               udp.send(paquet2);
	           }
	              
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	        	        
	           }
	        	   }); 
	        	   t.start();//on demarre le thread
	         }
		    
	         else if(str[0].matches("2")) {// on va traiter le tchat
	        
	      	   Thread t1 = new Thread(new Runnable(){
	    	         public void run(){
		    try {
		    	int port=paquet.getPort();
		    InetAddress ad= paquet.getAddress();


	           if(att.containsKey(str[1])) {// on voit si il existe sur le hashmap attente
	          	 String[] p1= att.get(str[1]);//on stock adr et le port dans un tableu 
	          	 att.remove(str[1]);// on le supprime de la liste des attente
	          	 String p=p1[0]+" "+p1[1]+" ";//on stock adr et le port separer d un espace pour les recuperer separement
	          	 byte[] buf4 = p.getBytes();//on les met on byte pour l'envoi 
	          	DatagramPacket paquet2 = new DatagramPacket(buf4,buf4.length,ad, port);
	               udp.send(paquet2);
	           }else {// si il n'existe pas on envoie la reponse si dessus 
	              	 byte[] buf4 = "Introuvable R�essayer ".getBytes();
	              	DatagramPacket	 paquet2 = new DatagramPacket(buf4,buf4.length,ad, port);
	                   udp.send(paquet2);
	                   }
	     } catch (IOException e) {
	        e.printStackTrace();
	     }
	    	        
	       }
	    	   }); 
	    	   t1.start();
	       }   else if(str[0].matches("choisir:")) {//on va traiter le choix de la personne avec qui il va tchater
	    	 
	      	   Thread t1 = new Thread(new Runnable(){
	  	         public void run(){
		    try {
		    	int port=paquet.getPort();
		    InetAddress ad= paquet.getAddress();

	        byte[] buf2 = new String(" "+att.keySet()).getBytes();// en envoie le hashmap attente separe de espace pour les recuperer
	        DatagramPacket paquet2 = new DatagramPacket(buf2,buf2.length,ad, port);
	        udp.send(paquet2);//en l'envoi a travers le flux

	   } catch (IOException e) {
	      e.printStackTrace();
	   }
	  	        
	     }
	  	   }); 
	  	   t1.start();
	     }         else if(str[0].matches("attende:")) {// en traite les personne en attente
	    
	          	   Thread t1 = new Thread(new Runnable(){
	        	         public void run(){
	 	     String[]p= {String.valueOf(paquet.getPort()),paquet.getAddress().toString()};// on stock adr est le port 
	          att.put(str[1], p);// on ajoute au hashmap attente
	        	        
	           }
	        	   }); 
	        	   t1.start();

	       }
	     else if(str[0].matches("sortie:")) {// on traite les sortie (deconnection )
	    	
	    	   Thread t1 = new Thread(new Runnable(){
	  	         public void run(){
	System.out.println(str[1]+" deconnecter");
	    String[]p= {String.valueOf(paquet.getPort()),paquet.getAddress().toString()};// on stock adr est le port 
	    clientconnected.remove(str[1]);// on supprime du hashmap connecter
	    clientdisconnected.put(str[1], p);// on ajoute au hashmap deconnecter
	  	        
	     }
	  	   }); 
	  	   t1.start();

	 }
	     


	         }

	   }
	}