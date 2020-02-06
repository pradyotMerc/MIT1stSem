package playfair;

import java.util.ArrayList;
import java.util.Iterator;

public class Encrypt {
	
	 public ArrayList<String> chunks;
	 public ArrayList<String> cipher;
	 
	 Encrypt(){
		 chunks=new ArrayList<>();
		 cipher=new ArrayList<>();
	 }
	 
	 void getchunks(String pt){
		 

	        for (int i = 0; i < pt.length();i=i+2) {

	            StringBuilder sb=new StringBuilder();

	            for (int j = i; j < i+2; j++) {

	                if (j==i+1&&j<pt.length()&&pt.charAt(j-1)==pt.charAt(j)) {
	                    sb.append('X');
	                    i--;
	                    break;

	                }
	                else if (j==pt.length()) {
	                    sb.append('X');
	                }
	                else {
	                    sb.append(pt.charAt(j));

	                }


	            }

	            chunks.add(sb.toString());
		 
	 }
	      
	 }
	 
	 void encrypt(char[][] matrix,String pt) {
		 getchunks(pt);
		 Iterator<String> chunksIterator=chunks.iterator();

	        while (chunksIterator.hasNext()){
	            String ch=chunksIterator.next();
	            char a=ch.charAt(0);
	            char b=ch.charAt(1);

	            
	            int arow=0,brow=0;
	            int acol=0,bcol=0;
	            for (int i = 0; i < 5; i++) {

	                for (int j = 0; j < 5; j++) {
	                    if (a==matrix[i][j]) {
	                        arow = i;
	                        acol = j;
	                        continue;
	                    }

	                    if (b==matrix[i][j]) {
	                        brow = i;
	                        bcol = j;
	                        break;

	                    }
	                   	                    
	                }


	            }
             if(arow==brow) {
                	System.out.print(new String(matrix[arow][(acol+1)%5]+""+matrix[brow][(bcol+1)%5]+" "));
                }
                else if(acol==bcol) {
                	System.out.print(new String(matrix[(arow+1)%5][acol]+""+matrix[(brow+1)%5][bcol]+" "));
                }else {
                	
                		System.out.print(new String(matrix[arow][bcol]+""+matrix[brow][acol])+" ");
                	
                		
                	}
                	
                	
                }

	            

	        }
	 }
