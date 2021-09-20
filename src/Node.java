public class Node
{
    //Instance variables for Node class holds value, left and right nodes
    int value;
    Node left;
    Node right;

    //Node constructor, takes in an integer
    Node(int inputValue)
    {
        //Sets the input integer to the current value of the Node
        this.value = inputValue;
        //Set right node to null
        right = null;
        //Set left node to null
        left = null;
    }
}
