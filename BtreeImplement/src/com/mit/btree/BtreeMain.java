package com.mit.btree;


import java.util.InputMismatchException;
import java.util.Scanner;


public class BtreeMain { 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Btree bTree = new Btree();
        try {
            while (true) {
                System.out.print("Welcome to the B Tree implementation\n"
                        + "1) to insert a number to the B Tree.\n"
                        + "2) to delete a number from the B Tree.\n"
                        + "3) to search the B Tree.\n"
                        + "4) to print the B Tree.\n"
                        + "Enter any other number to exit.\n"
                        + "Choose:\n");
                int choose, key;
                choose = in.nextInt();
                System.out.println("-------\n");
                switch (choose) {
                    case 1:
                        System.out.print("Enter the number to insert in the B tree: ");
                        bTree.insert(in.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter the number to delete from the B tree: ");
                        bTree.delete(in.nextInt());
                        break;
                    case 3:
                        System.out.print("Enter the number to search the B tree for: ");
                        key = in.nextInt();
                        if (bTree.search(key)) {
                            System.out.println(key + " is founded");
                        } else {
                            System.out.println(key + " is NOT founded");
                        }
                        break;
                    case 4:
                        System.out.println("Printing The B Tree\n");
                        bTree.print();
                        break;
                    default:
                        System.exit(0);
                }
                System.out.println("-----------------------");
            }
        } catch (InputMismatchException e) {
            System.out.println("Accept only numbers... \n Exiting....");
        }
        in.close();
    }
}


/*Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 10
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 20
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose: 
4
-------
Printing The B Tree

 
	20
	10
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 30
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	30
	20
	10
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 40
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.               
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	 
		10
	20
	 
		40
		30
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
3
Enter the number to search the B tree for: 30
30 is founded
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 50
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	 
		10
	20
	 
		50
		40
		30
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
1
Enter the number to insert in the B tree: 60
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	 
		30
	40
	 
		10
	20
	 
		60
		50
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
3
Enter the number to search the B tree for: 60
60 is founded
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
3
Enter the number to search the B tree for: 90
90 is NOT founded
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	 
		30
	40
	 
		10
	20
	 
		60
		50
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
2
Enter the number to delete from the B tree: 10
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
4
-------
Printing The B Tree

 
	 
		30
	40
	 
	20
	 
		60
		50
-----------------------
Welcome to the B Tree implementation
1) to insert a number to the B Tree.
2) to delete a number from the B Tree.
3) to search the B Tree.
4) to print the B Tree.
Note: 0 (zero) will be assumed NullEnter any other number to exit.
Choose:
*/