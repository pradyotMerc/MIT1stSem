package com.mit.crypto;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class DES {
//Variables required 
	byte[] skey = new byte[1000];
	String skeyString;
	static byte[] raw;
	String inputMessage, encryptedData, decryptedMessage;
	Scanner sc= new Scanner(System.in);
	
//Function to perform DES Algorithm
	public DES() {
		try {
//Generate key
			generateSymmetricKey();
//Read the Input message
			System.out.println("Enter message to Encrypt");
			inputMessage=sc.nextLine();
//Convert String to byte
			byte[] ibyte = inputMessage.getBytes();
//Encrypt The Input message
			System.out.println(Arrays.toString(ibyte));
			byte[] ebyte = encrypt(raw, ibyte);

			String encryptedData = new String(ebyte);
//print on 
			System.out.println("Encrypted message:" + encryptedData);
//Decrypt the Encrypted message
			byte[] dbyte = decrypt(raw, ebyte);
			String decryptedMessage = new String(dbyte);
			System.out.println("Decrypted message:" + decryptedMessage);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//Generate Key
	void generateSymmetricKey() {
		try {
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(num);
			byte[] knumb = knum.getBytes();
			skey = getRawKey(knumb);
			skeyString = new String(skey);
			System.out.println("DES Symmetric key =" + skeyString.toString());
			System.out.println("DES Symmetric key =" + skeyString);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("DES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(56, sr);
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}

//Encryption Code
	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

//Decryption Code
	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

//Driver Code
	public static void main(String args[]) {
		DES des = new DES();
	}
}


/*
DES Symmetric key =T�����
DES Symmetric key =T�����
Enter message to Encrypt
pradyot
[112, 114, 97, 100, 121, 111, 116]
Encrypted message:��w��
Decrypted message:pradyot

*/