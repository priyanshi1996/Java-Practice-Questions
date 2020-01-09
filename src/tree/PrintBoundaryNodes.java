//Write a function to print Boundary Traversal of a binary tree. 
//Boundary Traversal of a binary tree here means that you have to print boundary 
//nodes of the binary tree Anti-Clockwise starting from the root.
package tree;

public class PrintBoundaryNodes {

}

class GfG
{
	void printBoundary(Node node)
	{
	    if(node==null)
	        return;
	    System.out.print(node.data+" ");
		printLeftBoundary(node.left);
		printLeafNode(node);
		printRightBoundary(node.right);
	}
	
	void printLeftBoundary(Node node){
	    if(node==null)
	        return;
	    if(node.left!=null){
	        System.out.print(node.data+" ");
	        printLeftBoundary(node.left);
	    }
	    else if(node.right!=null){
	        System.out.print(node.data+" ");
	        printLeftBoundary(node.right);
	    }
	}
	
	void printLeafNode(Node node){
	    if(node==null)
	        return;
	    if(node.left==null && node.right==null)
	        System.out.print(node.data+" ");
	    printLeafNode(node.left);
	    printLeafNode(node.right);
	}
	
	void printRightBoundary(Node node){
	    if(node==null)
	        return;
	    if(node.right!=null){
	        printRightBoundary(node.right);
	        System.out.print(node.data+" ");
	    }
	    else if(node.left!=null){
	        printRightBoundary(node.left);
	        System.out.print(node.data+" ");
	    }
	}
}

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
