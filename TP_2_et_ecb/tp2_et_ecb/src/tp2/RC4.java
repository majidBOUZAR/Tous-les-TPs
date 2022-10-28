package rc4;
public class RC4 {

    private int[] S;
    private int i = 0;
    private int j = 0;
    
    public byte[] gener_Stream(byte[] clé, int size) {
        byte[] result = new byte[size];
        
        return result;
    }
    
    // L'algorithme de key schedule
    
    public RC4(byte[] clé, int _256) {
        S = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }
	int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + clé[i % clé.length] + 256) % 256; // Longueur de clé exprimée en octet
            échanger(i, j, S);
        }
    }

    // La génération du flot pseudo-aléatoire
    
    public byte[] déchiffré(final byte[] octet_message) { 
        return chiffré(octet_message);
    }
    
    public byte[] chiffré(final byte[] octet_message) {
        byte[] result_chiffré = new byte[octet_message.length];
        for (int n = 0; n < octet_message.length; n++) {
            i = (i + 1) % 256;
            j = (j + S[i]) % 256;
            échanger(i, j, S);
            int octet_chiffrement = S[(S[i] + S[j]) % 256];
            result_chiffré[n] = (byte) (octet_chiffrement ^ (int) octet_message[n]);
        }
        return result_chiffré;
    }

    private void échanger(int i, int j, int[] S) {
        int temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }
}