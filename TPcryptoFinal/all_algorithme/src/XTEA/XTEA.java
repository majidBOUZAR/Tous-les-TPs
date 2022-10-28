package xtea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XTEA  {
    
    private static final int NUM_ROUNDS = 32;
    
        
           
    
        static String read(String filename)
        {
            File f = new File(filename);
            try
            {
                byte[] bytes = Files.readAllBytes(f.toPath());
                return new String(bytes,"UTF-8");
            } 
            catch (FileNotFoundException e)
            {
            }
            catch (IOException e)
            {
            }
            return "";
        }

	static int[] char2int(char[] c)
        {
            int[] res= new int[2];
		res[0] = (int) ((((int) c[0] & 0xff) << 24)
				| (((int) c[1] & 0xff) << 16)
				| (((int) c[2] & 0xff) << 8) | ((int) c[3] & 0xff));
		res[1] = (int) ((((int) c[4] & 0xff) << 24)
				| (((int) c[5] & 0xff) << 16)
				| (((int) c[6] & 0xff) << 8) | ((int) c[7] & 0xff));
            return res;
	}

        static char[] int2char(int[] i)
        {
            char[] res= new char[8];
	    res[0] = (char) ((i[0] & 0xff000000) >>> 24);
	    res[1] = (char) ((i[0] & 0x00ff0000) >>> 16);
	    res[2] = (char) ((i[0] & 0x0000ff00) >>> 8);
	    res[3] = (char) (i[0] & 0x000000ff);
            res[4] = (char) ((i[1] & 0xff000000) >>> 24);
	    res[5] = (char) ((i[1] & 0x00ff0000) >>> 16);
            res[6] = (char) ((i[1] & 0x0000ff00) >>> 8);
            res[7] = (char) (i[1] & 0x000000ff);
            return res;
	}

        static int[] key_treatment(char[] c)
        {
            int[] res= new int[4];
            res[0] = (int) ((((int) c[0] & 0xff) << 24)
			| (((int) c[1] & 0xff) << 16)
			| (((int) c[2] & 0xff) << 8)
                        | ((int) c[3] & 0xff));
	    res[1] = (int) ((((int) c[4] & 0xff) << 24)
			| (((int) c[5] & 0xff) << 16)
			| (((int) c[6] & 0xff) << 8)
                        | ((int) c[7] & 0xff));
            res[2] = (int) ((((int) c[8] & 0xff) << 24)
			| (((int) c[9] & 0xff) << 16)
			| (((int) c[10] & 0xff) << 8)
                        | ((int) c[11] & 0xff));
	    res[3] = (int) ((((int) c[12] & 0xff) << 24)
			| (((int) c[13] & 0xff) << 16)
			| (((int) c[14] & 0xff) << 8)
                        | ((int) c[15] & 0xff));
            return res;
	}
    
        static int[] encipher(int[] block, int[] key)
        { 
            int sum = 0; 
            int delta = 0x9E3779B9;
            for (int i = 0; i < NUM_ROUNDS; i++)
                {
                    block[0] += (((block[1] << 4) ^ (block[1]>> 5)) + block[1]) ^ (sum + key[sum & 3]);
                    sum += delta;
                    block[1] += (((block[0] << 4) ^ (block[0] >> 5)) + block[0]) ^ (sum + key[(sum>>11) & 3]);
                }
            return block;
        }
 
        static int[] decipher(int[] block, int[] key)
        { 
            int delta=0x9E3779B9;
            int sum=delta*NUM_ROUNDS; 
            for (int i = 0; i < NUM_ROUNDS; i++)
                { 
                    block[1] -= ((block[0] << 4 ^ block[0] >> 5) + block[0]) ^ (sum + key[(sum>>11) & 3]);
                    sum -= delta;
                    block[0] -= ((block[1] << 4 ^ block[1] >> 5) + block[1]) ^ (sum + key[sum & 3]);
                }
            return block;
        }

        static List<String> split(String t)
        {
            List<String> blocks = new ArrayList<>();
            int i = 0;
            while (i < t.length()) 
            {
                blocks.add(t.substring(i, Math.min(i + 8,t.length())));
                i += 8;
            }
            return blocks;
        }
   
        public static void main(String[] args)
        {
            String k="";
            char[] iv="llllllll".toCharArray();
            do
            { 
             System.out.println("entrée votre clé:");
               Scanner sc = new Scanner(System.in);
               k=sc.nextLine();
            }
            while(k.length()<16);
            String kk=k.substring(0, Math.min(k.length(), 16));
            char[] k1=kk.toCharArray();
            String t=read("src/XTEA/text.txt");
              System.out.println("le mode ECB\n");
            ECB ecb = new ECB (k1, t);
              System.out.println("le mode CBC\n" );
            CBC cbc = new CBC (k1, t, iv);
              System.out.println("le mode CTR\n" );
            CTR ctr = new CTR (k1, t, "mnlk22");
          
        }}