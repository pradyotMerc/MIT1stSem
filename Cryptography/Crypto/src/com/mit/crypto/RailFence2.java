package com.mit.crypto;

import java.util.Scanner;

public class RailFence2 {
	public static void main(String[] args) throws Exception {
		args = new String[] { "3", "hihowareyou" };

		
		 Scanner scn = new Scanner(System.in);
//		 System.out.println("Enter plain text:"); args[1] = scn.nextLine();
//		 System.out.println("Enter key for Encryption:"); args[0] = scn.nextLine();
		

		int key = Integer.parseInt(args[0]);

		String ct = encode(key, args[1]);
		System.out.println("Cipher Text:");
		System.out.println(ct);

		System.out.println("\nAfter Decoding:");
		System.out.println(decode(key, ct));
		
		 scn.close();

	}

	public static String encode(int key, String text) {
		String ciphertext = "";
		String[] lines = new String[key];
		for (int i = 0; i < key; i++) {
			lines[i] = "";
		}
		int line = 0;
		int direction = 1; // moving positively or negatively
		for (int i = 0; i < text.length(); i++) {
			lines[line] = lines[line] + text.charAt(i);
			line = line + direction;
			if (line == 0 || line == key - 1) {
				direction = direction * (-1);
			}
		}
		for (String l : lines) {
			ciphertext = ciphertext + l;
		}
		return ciphertext;
	}

	public static String decode(int key, String text) {
		char[] plaintext = new char[text.length()];
		String[] lines = splitLines(key, text.length());

		for (int i = 0; i < key; i++) {
			// System.out.println("#" + i + " : " + lines[i]);
			int startbreak = 0;
			for (int j = 0; j < i; j++) {
				startbreak = startbreak + lines[j].length();
			}
			int endbreak = startbreak + lines[i].length();
			lines[i] = text.substring(startbreak, endbreak);
			// System.out.println(startbreak + " to " + endbreak);
			// System.out.println("#" + i + " : " + lines[i]);
		}

		int line = 0;
		int direction = 1; // moving positively or negatively
		int[] pos = new int[lines.length];
		for (int i = 0; i < pos.length; i++) {
			pos[i] = 0;
		}
		for (int i = 0; i < text.length(); i++) {
			plaintext[i] = lines[line].charAt(pos[line]);
			pos[line]++;
			line = line + direction;
			if (line == 0 || line == key - 1) {
				direction = direction * (-1);
			}
		}

		return new String(plaintext);
	}

	public static String[] splitLines(int key, int length) {
		String[] lines = new String[key];
		for (int i = 0; i < key; i++) {
			lines[i] = "";
		}
		int line = 0;
		int direction = 1; // moving positively or negatively
		for (int i = 0; i < length; i++) {
			lines[line] = lines[line] + "?";
			line = line + direction;
			if (line == 0 || line == key - 1) {
				direction = direction * (-1);
			}
		}
		return lines;
	}
	
}