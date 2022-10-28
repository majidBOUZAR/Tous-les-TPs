package xtea;

import static xtea.XTEA.char2int;
import static xtea.XTEA.decipher;
import static xtea.XTEA.encipher;
import static xtea.XTEA.int2char;
import static xtea.XTEA.key_treatment;
import static xtea.XTEA.split;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CBC {
    
    
    CBC (char[] k, String plaintext, char[] iv)
    {
        List<String> ptext = split(plaintext);
        String textchif="";
        char[] x=new char[8];
        for (int j=0;j<iv.length;j++)
                x[j]=(char) (ptext.get(0).toCharArray()[j] ^ iv[j]);
        int[] char2 = null;
        int[] c= char2int(x);
        int[] d= encipher(c,key_treatment(k));
        char[] e=int2char(d);
        String www=new String(e);
        textchif+=www;
        int z=ptext.get(ptext.size()-1).length();
        for(int i=1;i<ptext.size();i++)
        {
            String s=ptext.get(i);
            while (s.length()<8)
            {
               s+=" ";
            }
            for (int j=0;j<s.toCharArray().length;j++)
                x[j]=(char) (s.toCharArray()[j] ^ e[j]);
            c= char2int(x);
            d= encipher(c,key_treatment(k));
            e=int2char(d);
            www=new String(e);
            textchif+=www;
        }
       //decripter
        System.out.println(textchif);
        List<String> bb = split(textchif);
        String ch="";
        int[] cc= char2int(bb.get(0).toCharArray());
        int[] dd= decipher(cc,key_treatment(k));
        char[] ee=int2char(dd);
        char[] xx=new char[8];
        for (int j=0;j<iv.length;j++)
                xx[j]=(char) (ee[j] ^ iv[j]);
        String p=new String(xx);
        ch+=p;
        for(int i=1;i<bb.size();i++)
        {
            cc= char2int(bb.get(i).toCharArray());
            dd= decipher(cc,key_treatment(k));
            ee=int2char(dd);
            for (int j=0;j<ptext.get(i).toCharArray().length;j++)
                xx[j]=(char) (ee[j] ^ bb.get(i-1).toCharArray()[j]);
            p=new String(xx);
            if ((i==(ptext.size()-1))&&(z!=8))
                p=p.substring(0, Math.min(p.length(), z));
            ch+=p;
        }
        System.out.println(ch);
    }
}
 
