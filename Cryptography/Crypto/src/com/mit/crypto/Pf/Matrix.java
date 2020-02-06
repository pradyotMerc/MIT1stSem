package playfair;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Matrix {
	String key;
	char[][] matrix;
	Set<Character> noDup;
	Matrix(String key){
		this.key=key;
		this.matrix=new char[5][5];
		
		noDup=new LinkedHashSet<>();
        for (char c :
            key.toCharArray()) {
            noDup.add(c);
        }
	}
	
	char[][] createMatrix(){
		char[] ndpt=new char[noDup.size()];
        Iterator<Character> it=noDup.iterator();
        int k=0;
        while (it.hasNext()){
            ndpt[k++]=it.next();
        }
		k=0;

        int ascii=65;

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (k<noDup.size())
                    matrix[i][j] = ndpt[k++];
                else{
                	if(isKeywordCotainsIorJ(ndpt)) {
                		if((char)ascii=='I')
                			ascii=ascii+2;
                		if((char)ascii=='J')
                			ascii=ascii+1;
                	}
                		
                    if ((char)ascii=='J')
                        ascii++;
                    
                    int newascii=nextAsciiValue(ascii,ndpt);
                    ascii=newascii;
                    
                    matrix[i][j]=(char)ascii++;
                }

            }
        }
        return matrix;
	}
	
	private boolean isKeywordCotainsIorJ(char[] ndpt) {
		// TODO Auto-generated method stub
		char i='I',j='J';
		for(int k=0;k<ndpt.length;k++) {
			if(ndpt[k]==i||ndpt[k]==j)
				return true;
		}
		return false;
	}
	
	private static int nextAsciiValue(int ascii,char[] ndpt) {
		// TODO Auto-generated method stub
		if(keywordContainsAscii(ascii,ndpt))
			return nextAsciiValue(++ascii, ndpt);
		else
			return ascii;
		
	}
	

	private static boolean keywordContainsAscii(int ascii,char[] ndpt) {
		// TODO Auto-generated method stub
		for (int l = 0; l < ndpt.length; l++) {
            if ((char)ascii==ndpt[l]) {
                return true;

            }
        }
		return false;
	}
	
}
