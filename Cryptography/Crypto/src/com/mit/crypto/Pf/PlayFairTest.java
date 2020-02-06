package playfair;

import java.util.*;

public class PlayFairTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter key");
        String key=scanner.nextLine();
        System.out.println("Enter plaintext");
        String pt=scanner.nextLine();
        pt=pt.replaceAll("\\s+","");
        pt=pt.toUpperCase();
        key=key.replaceAll("\\s+","");
        key=key.toUpperCase();
        
        Matrix matObj=new Matrix(key);
        System.out.println("Matrix is:");

        
        Encrypt enc=new Encrypt();
        
        char[][] matrix=matObj.createMatrix();
        for (int l = 0; l < 5; l++) {
            for (int m = 0; m <5; m++) {
                System.out.print(matrix[l][m]);
            }
            System.out.println();
        }
        
        System.out.println("Cipher text is");
        enc.encrypt(matrix,pt);
        


        




    }

	


	
}
