package ws.abhis.amazonpreps.datastructures;



public class RedBlackNode
{
        // Constructors
    RedBlackNode( Comparable theElement )
    {
        this( theElement, null, null );
    }

    RedBlackNode( Comparable theElement, RedBlackNode lt, RedBlackNode rt )
    {
        element  = theElement;
        left     = lt;
        right    = rt;
        color    = RedBlackTree.BLACK;
    }

        // Friendly data; accessible by other package routines
    Comparable   element;    // The data in the node
    RedBlackNode left;       // Left child
    RedBlackNode right;      // Right child
    int          color;      // Color
}