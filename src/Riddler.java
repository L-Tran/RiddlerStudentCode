/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 * Completed by: Logan Tran
 */
public class Riddler {

    // Static Variables for Shifts
    public static int CAESAR_SHIFT = 9;
    public static int DINGBAT_CAESAR_SHIFT = 9919;

    // Caesar shift +9
    public String decryptOne(String encrypted) {
        String decrypted = "";
        // Loop through encrypted message
        for(int i = 0; i < encrypted.length(); i++){
            char c = encrypted.charAt(i);
            // Find case of letter to get to proper ascii
            if (Character.isUpperCase(c)) {
                // Shift letter 9 then convert back to ascii
                c = (char)((c + CAESAR_SHIFT - 'A') % 26 + 'A');
            }
            else if (Character.isLowerCase(c)){
                // Shift letter 9 then convert back to ascii
                c = (char)((c + CAESAR_SHIFT - 'a') % 26 + 'a');
            }
            decrypted += c;
        }
        return decrypted;
    }

    // Ascii conversion
    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Split string into array of strings of ascii numbers
        String[] ascii = encrypted.split(" ");
        // Loop through strings
        for(String s: ascii){
            // Convert to Int then Char
            char c = (char)Integer.parseInt(s);
            decrypted += c;
        }
        return decrypted;
    }

    // Binary conversion
    public String decryptThree(String encrypted) {
        String decrypted = "";
        // Loop through in group of 8
        for(int i = 0; i < encrypted.length(); i+=8){
            String numString = "";
            // Loop through each group
            for(int j = 0; j < 8; j++){
                // Add each 1 or 0 to binary string
                numString += encrypted.charAt(i+j);
            }
            // Convert binary string to int
            int num = Integer.parseInt(numString);
            int asciiNum = 0;
            int counter = 0;
            // Until binary int is 0
            while(num > 0){
                // Multiple and add number depending on position
                asciiNum += (int) ((num % 10) * Math.pow(2,counter));
                // Shorten number and addd to counter
                num /= 10;
                counter++;
            }
            decrypted += (char)asciiNum;
        }

        return decrypted;
    }

    // Caesar Shift -9919 from Dingbat
    public String decryptFour(String encrypted) {
        String decrypted = "";
        // Loop through encrypted message
        for(int i = 0; i < encrypted.length(); i++){
            // Shift every digit down
            char c = encrypted.charAt(i);
            c = (char)(c - DINGBAT_CAESAR_SHIFT);
            decrypted += c;
        }
        return decrypted;
    }
}
