package com.mit.dsr_5;

import java.util.ArrayList;
import java.util.Arrays;

public class DsrMain {
	
	
	public static void reply(Packet packet)
	{
		System.out.println(packet);
		
		
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Enter Adjacency matrix:");

		int adjMatrix[][] = new int[][] { { 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 } };

		ArrayList<String> path = new ArrayList<String>();

		// System.out.println(Arrays.deepToString(adjMatrix));

		for (int[] a : adjMatrix)
			System.out.println(Arrays.toString(a));

		// path.add("A");
		Packet packet = new Packet("RREQ", "0", 1101, "3", "0");
		Packet p[]= new Packet[5];

		System.out.println(packet);

		int[] adj = new int[5]; // the adj matrix
		
		int flag=0;

		
		adj = adjMatrix[0]; // initialize the adj array
		int count=0;
		for (int counter = 0; counter < 5; counter++) {

			if (adj[counter] == 1) {
				
				p[counter]= new Packet(packet);
				//route add
				
				System.out.print("\nWhen Node ="+counter+" then : ");
				int cmp=packet.getDestIP().compareTo(Integer.toString(counter));
				if(cmp==0)
				{
					System.out.println("Reply.");
					flag=1;
					//p[counter].setPacketType("RREP");
					
					count=counter;
				}
				else
				{
					System.out.println("Forward.");
					
				}
				p[counter].addRoute(Integer.toString(counter));
				System.out.println(p[counter]);
			}

		}
		if(flag==0)
		{
			System.out.println("Packet did not reach to destination");
		}
		else
		{
			System.out.println("Packet reached destination now replying back to Source\n");
			p[count].setPacketType("RREP");
			DsrMain.reply(p[count]);
		}
	} 
}
