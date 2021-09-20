//Imported Java Utilities
import java.*;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

//Binary Tree Class
public class BinaryTree
{
    //Instance variable to hold the root Node of the tree
    Node root;

    //addRecursive method, takes a node and an integer and returns a Node
    private Node addRecursive(Node current, int inputValue)
    {
        //If the node passed in is null
        if(current == null)
        {
            //Instantiate a new node pass in the inputValue integer
            return new Node(inputValue);
        }
        //If the input value passed in is less then the passed in Node value
        if(inputValue < current.value)
        {
            //Recursively call the addRecursive method and pass in left node
            current.left = addRecursive(current.left, inputValue);
        }
        //if the inputValue is greater than the current Node value
        else if (inputValue > current.value)
        {
            //Recursively call the addRecursive method and pass in the right node
            current.right = addRecursive(current.right, inputValue);
        }
        //For all other situations
        else
        {
            //return the current node passed into the method
            return current;
        }
        //return the current Node passed in
        return current;
    }
    //Add method, takes an integer returns nothing
    public void add(int inputValue)
    {
        //set the instance variable root to the Node returned from the addRecursive method.
        root = addRecursive(root, inputValue);
    }
    //Delete recursive method takes a node and an integer returns a node
    private Node deleteRecursive(Node current, int inputValue)
    {
        //If the current node passed in is null
        if (current == null)
        {
            //return null
            return null;
        }
        //if the integer passed in is equal to the value of the node passed in
        if (inputValue == current.value)
        {
            //if the left node is null and the right node is null
            if (current.left == null && current.right == null)
            {
                //return null
                return null;
            }
            //if the right node is null and the right node is null
            if (current.right == null)
            {
                //return the left node of the node passed in
                return current.left;
            }
            //if the left node of the node that is passed in is null
            if (current.left == null)
            {
                //then return the right node of the node passed in
                return current.right;
            }
            //Declare an integer variable to hold the smallest value and set to the value returned from the findSmallestValue method
            int smallestValue = findSmallestValue(current.right);
            //set the value of the node passed in to the integer variable declared above
            current.value = smallestValue;
            //Set the right node of the node passed into the method to the recursive call of this method
            current.right = deleteRecursive(current.right, smallestValue);

            //return the current node passed in
            return current;

        }
        //if integer passed in is less then the value of the current node
        if (inputValue < current.value)
        {
            //Call the method recursively and set it to the left node of the current node passed in
            current.left = deleteRecursive(current.left, inputValue);
            //return the current node passed in
            return current;
        }
        //set the right node of the node passed in to the node to the node returned from the recursive call of this method
        current.right = deleteRecursive(current.right, inputValue);

        //return the current node passed into the method
        return current;

    }
    //delete method takes in an integer returns nothing
    public void delete(int inputValue)
    {
        //set the root node to the node return from the deleteRecursive method
        root = deleteRecursive(root, inputValue);
    }
    //findSmallestValue method takes in a node and returns an integer
    private int findSmallestValue(Node root)
    {
        //return the left node of the root node using a recursive call
        return root.left == null ? root.value:findSmallestValue(root.left);
    }

    //traverseInOrder method takes a Node
    public void traverseInOrder(Node node)
    {
        //If the node is not null
        if (node != null)
        {
            //Recursively call the traverseInOrder method
            traverseInOrder(node.left);
            //{rint out a space with the value of the node passed in
            System.out.print(" " + node.value);
            //Recursively call the traverseInOrder method pass in the right node
            traverseInOrder(node.right);
        }

    }
    //travserNodes method takes a string builder 2 strings a node and a booleab variable
    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                              boolean hasRightSibling)
    {
        //if the node is not null
        if (node != null)
        {
            //Append a new line to the string builder variable
            sb.append("\n");
            //Append the padding and pointer variables passed in
            sb.append(padding);
            sb.append(pointer);
            //Append the value of the node pass in
            sb.append(node.value);

            //Instntaie a new string builder and pass in the padding string passed into the method
            StringBuilder paddingBuilder = new StringBuilder(padding);
            //if the boolean passed in is true
            if (hasRightSibling)
            {
                //append to the string builder created above
                paddingBuilder.append("│  ");
            }
            //if it returns false
            else
            {
                //Append a Space
                paddingBuilder.append("   ");
            }
            //Instantiate a new string builder
            String paddingForBoth = paddingBuilder.toString();
            //Declare a new string called pointer right
            String pointerRight = "└──";
            //Declare a new string called pointerLeft
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            //Recursively call the traverseNodes method
            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }
    //traversePreOrder method takes a node and returns a String
    public String traversePreOrder(Node root)
    {
        //if the node passed in is null
        if (root == null)
        {
            //return a blank string
            return "";
        }

        //Instantiate a new string builder variable
        StringBuilder sb = new StringBuilder();
        //append the value of the root node passed into the method
        sb.append(root.value);
        //Declare a string variable called pointer right
        String pointerRight = "└──";
        //Declare a string variable called pointer left
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        //Call the traverseNodes methods pass in all strings created for left and right nodes of the root node passed in
        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        //return the string returned from the toString method on the string builder variable created
        return sb.toString();
    }
    //Additional traversePreOrder method much simpler not as fancy
    public void traversePreOrder2(Node node)
    {
        //If the node passed in is null
        if(node != null)
        {
            //Print the value of the node passed in followed by a space
            System.out.print( node.value + " ");
            //Recursively call the method and pass in the left node
            traversePreOrder2(node.left);
            //Recursively call the method and pass in the right node
            traversePreOrder2(node.right);
        }
    }
    //traversePostOrder method takes in a node variable returns nothing
    public void traversePostOrder(Node node)
    {
        //if the node passed in is null
        if(node != null)
        {
            //Recursively call the traversePostOrder method pass in the left node
            traversePostOrder(node.left);
            //Recursively call the traversePostOrder method pass in the right node
            traversePostOrder(node.right);
            //Print out the value of the node passed in followed by a space
            System.out.print(node.value + " ");
        }
    }
    //traverseLevelOrder method takes nothing returs nothing
    public void traverseLevelOrder()
    {
        //if the root node is null
        if (root == null)
        {
            //return nothing
            return;
        }

        //Instantiate a new Queue variable
        Queue<Node> nodes = new LinkedList<>();
        //Call the add method and pass into the root variable
        nodes.add(root);

        //While the isEmpty() method returns false
        while (!nodes.isEmpty())
        {
            //Instantiate a new node and set it to the node returned from the remove() method
            Node node = nodes.remove();
            //Print out a space followed by the value of the node created above
            System.out.print(" " + node.value);

            //if the left node is not null
            if (node.left != null)
            {
                //call the add method and pass in the left node
                nodes.add(node.left);
            }
            //if the right node is not null
            if (node.right != null)
            {
                //call the add method and pass in the right node
                nodes.add(node.right);
            }
        }
    }
}
