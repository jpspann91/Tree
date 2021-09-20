import java.io.PrintStream;
import java.util.Scanner;
//Binary Tree Test method to test all methods
public class BinaryTree_Test
{
    //Main method to run the program
    public static void main(String[] args)
    {
        //Instantiate a new Scanner object
        Scanner scan = new Scanner(System.in);
        /* Creating object of BT */
        BinaryTree bt = new BinaryTree();
        /*  Perform tree operations  */
        System.out.println("Binary Tree Test");
        //Set a new char vairable to Y
        char keepInMenu = 'Y';

        //Prompt the user to enter in the first element of the binary tree
        System.out.println("First, lets build a tree");
        System.out.println("How many elements would you like to add to this tree to start with?");
        int startingTreeSize = scan.nextInt();
        System.out.println("Now lets add " + startingTreeSize + " elements to the tree");
        //For loop to add the Nodes to the tree and the current values
        for(int i = 0; i < startingTreeSize; i++ )
        {
            System.out.println("Add in element # " + (i +1));
            bt.add(scan.nextInt());
        }
        //Menu to keep student choosing to add, delete or print to the binary tree
        do
        {
            System.out.println("\nBinary Tree Menu:");
            System.out.println("1. Add Node ");
            System.out.println("2. Delete Node");
            System.out.println("3. Print Tree");
            System.out.println("4. Quit");

            //int variable to hold the users choice
            int choice = scan.nextInt();
            //Switch statements for each menu choice
            switch (choice)
            {
                //If choice is equal to 1
                case 1 :
                    //Prompt the user to enter an integer
                    System.out.println("Enter an integer element to insert");
                    //pass in the next Int in to the add() method
                    bt.add( scan.nextInt() );
                    break;
                //If choice is equal to 2
                case 2 :
                    //Prompt the user to enter an integer
                    System.out.println("Enter an integer element to delete");
                    //pass in the next Int in to the add() method
                    bt.delete(scan.nextInt());
                    break;
                //If choice is equal to 3
                case 3 :
                    //Prompt the user about the Binary Tree
                    System.out.println("This Binary Tree Consists of: ");
                    //Call traversePreOrder() method and pass in the root node of the Binary Tree object created
                    bt.traversePreOrder(bt.root);
                    //Declare a string and set it to the string returns from the traversePreOrder() method
                    String binaryTree = bt.traversePreOrder(bt.root);
                    //String out the binary tree string declared earlier
                    System.out.print(binaryTree + "\n");
                    //Print out the tree in traverse pre order
                    System.out.println("In Traverse Pre Order: ");
                    // call the traversePreOrder2() method and pass in the root node on the binary tree object
                    bt.traversePreOrder2(bt.root);
                    break;
                case 4:
                    //Set keepInMenu to n to exit the do while loop
                    keepInMenu = 'n';
                    //Prompt the user that the program has ended
                    System.out.println("The Program has ended.");
                    break;
                //default statement if the user does not choose 1-4
                default :
                    //Prompt the user that they put in a wrong entry
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            //keeps user in the loop while keepInMenu is set to Y or y
        } while (keepInMenu == 'Y'|| keepInMenu == 'y');
    }
}
