package com.mit.heap;
import java.util.Scanner;


/* Class BinomialHeapTest */
public class BinomialHeapTest
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Binomial Heap Test\n\n");
		/* Make object of BinomialHeap */
		BinomialHeap bh = new BinomialHeap();
		char ch;
		/* Perform BinomialHeap operations */
		do
		{
			System.out.println("\nBinomialHeap Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. delete ");
			System.out.println("3. size");
			System.out.println("4. check empty");
			System.out.println("5. clear");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter integer element to insert");
				bh.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter element to delete ");
				bh.delete(scan.nextInt());
				break;
			case 3:
				System.out.println("Size = " + bh.getSize());
				break;
			case 4:
				System.out.println("Empty status = " + bh.isEmpty());
				break;
			case 5:
				bh.makeEmpty();
				System.out.println("Heap Cleared\n");
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display heap */
			bh.displayHeap();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scan.close();
	}
}




/*

Binomial Heap Test



BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
1
Enter integer element to insert
10

Heap : 10 


Do you want to continue (Type y or n) 

y

BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
1
Enter integer element to insert
20

Heap : 20 10 


Do you want to continue (Type y or n) 

y

BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
1
Enter integer element to insert
30

Heap : 30 20 10 


Do you want to continue (Type y or n) 

y

BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
1
Enter integer element to insert
4

Heap : 20 10 30 4 


Do you want to continue (Type y or n) 

y

BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
2
Enter element to delete 
30

Heap : 4 20 10 


Do you want to continue (Type y or n) 

y

BinomialHeap Operations

1. insert 
2. delete 
3. size
4. check empty
5. clear
3
Size = 3

Heap : 4 20 10 


Do you want to continue (Type y or n) 

4
*/