package xtea;
import java.util.List;
import static xtea.XTEA.char2int;
import static xtea.XTEA.decipher;
import static xtea.XTEA.encipher;
import static xtea.XTEA.int2char;
import static xtea.XTEA.key_treatment;
import static xtea.XTEA.split;



public class ECB {
    
        ECB (char[] k, String t)
    {
    List<String> txtClr = split(t);
        String textChif="";
        int textClair=txtClr.get(txtClr.size()-1).length();
        for(int i=0;i<txtClr.size();i++)
        {
            String s=txtClr.get(i);
            while (s.length()<8)
            {
               s+=" ";
            }
            int[] a1= char2int(s.toCharArray());
            int[] chiffrer= encipher(a1,key_treatment(k));
            String textChiffrer=new String(int2char(chiffrer));
            textChif+=textChiffrer;
        }
        System.out.println("Le text chiffré: \n"+textChif);
//decripte
        List<String> txtChfr = split(textChif);
        String textDechif="";
        for(int i=0;i<txtChfr.size();i++)
        {
            int[] a2= char2int(txtChfr.get(i).toCharArray());
            int[] dechiffrer= decipher(a2,key_treatment(k));
            String p=new String(int2char(dechiffrer));
            if ((i==txtChfr.size()-1)&&(textClair!=8))
                p=p.substring(0, Math.min(p.length(), textClair));
            textDechif+=p;
        }
           System.out.println("Le text dechiffré: \n"+textDechif);
       
    }
        
}