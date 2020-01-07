/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

/**
 *
 * @author Tyler
 */
public class AffineCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String s = "DURORMNSG";
        String d = "";
        int x,y;
        int aPrime = 0;
        int b = 0;
        for(aPrime = 0; aPrime <=26; aPrime++){
            for(b = 0; b <=26; b++){
                for(int i = 0; i < s.length(); i++){
                    y = ((int) s.charAt(i)) - 65;
                    x = (aPrime * (y + b)) % 26;
                    x += 65;
                    d += Character.toString((char) x);
                }
                System.out.println("A' is " + aPrime + ", B is "+ b+ " " + d);
                d = "";
            }
        }
        
        
    }
    
}
