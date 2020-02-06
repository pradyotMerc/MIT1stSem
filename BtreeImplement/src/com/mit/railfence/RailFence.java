package com.mit.railfence;


public class RailFence {
	char[][] matrix;
//	void encrypt(String pt, int key) {
//		matrix=new char[key][pt.length()];
//		int j=0;
//		for(int i=0;i<pt.length();i++) {
//			matrix[j%key][i]=pt.charAt(i);
//			j++;
//		}
//		
//	}
	
	void encrypt2(String pt, int key) {
		matrix=new char[key][pt.length()];
		int flag=0,j=0;
		for(int i=0;i<pt.length();i++) {
			if(flag==0) {
				matrix[j%key][i]=pt.charAt(i);
				j++;
				if(j==key) {
					flag=1;
					j=j-2;
					continue;
				}
				
			}
			if(flag==1) {
				matrix[j%key][i]=pt.charAt(i);
				j--;
				if(j==-1) {
					flag=0;
					j=j+2;
					continue;
				}
			}
			
		}
	}
	
	void printMatrix() {
		System.out.println("encrypted text is ");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]!='\u0000') {
				System.out.print(matrix[i][j]+" ");
				
				}
				
			}
	
		}
		
	}

	public void decrypt(int key) {
		
		System.out.println("Decrypted text is ");
		int j=0;
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[j%key][i]!='\u0000')
			System.out.print(matrix[j%key][i]);
			
			j++;
		}
		
	}
	
	public void decrypt2(int key) {
		System.out.println();
		System.out.println("Decrypted text is ");
		int flag=0,j=0;
		for(int i=0;i<matrix[0].length;i++) {
			if(flag==0) {
				System.out.print(matrix[j%key][i]);
				j++;
				if(j==key) {
					flag=1;
					j=j-2;
					continue;
				}
				
			}
			if(flag==1) {
				System.out.print(matrix[j%key][i]);
				j--;
				if(j==-1) {
					flag=0;
					j=j+2;
					continue;
				}
			}
			
		}
	}

}