package bean;

import java.util.Scanner;

public class RedBlackTreeTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of RedBlack Tree */
		RBTree rbt = new RBTree(Integer.MIN_VALUE);
		System.out.println("----------Red Black Tree----------");
		char ch;
		/* Perform tree operations */
		do // 10 20 3 5 1 40
		{
			System.out.println("-----Red Black Tree Operations-----");
			System.out.println("\n----Enter Your Choice----");
			System.out.println("1. Insert ");
			System.out.println("2. Search");
			System.out.println("3. Count nodes");
			System.out.println("4. Check empty");
			System.out.println("5. Clear tree");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert.. -99 to stop inserting");
				while (true) {

					int temp = scan.nextInt();
					if (temp == -99) {
						break;
					}
					rbt.insert(temp);
				}
				break;
			case 2:
				System.out.println("Enter integer element to search");
				System.out.println("Search result : " + rbt.search(scan.nextInt()));
				break;
			case 3:
				System.out.println("Nodes = " + rbt.countNodes());
				break;
			case 4:
				System.out.println("Empty status = " + rbt.isEmpty());
				break;
			case 5:
				System.out.println("\nTree Cleared");
				rbt.makeEmpty();
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display tree */
			System.out.print("\nPost order : ");
			rbt.postorder();
			System.out.print("\nPre order : ");
			rbt.preorder();
			System.out.print("\nIn order : ");
			rbt.inorder();

			System.out.println("\nDo you want to continue (Type y or n) ");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

}
