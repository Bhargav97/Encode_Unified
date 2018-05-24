package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BTtut extends Fragment {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStop() {
        ((MainActivity)getActivity()).getSupportActionBar().show();
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bttut_layout, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().hide();
        MainActivity.hideSearch();
        ((MainActivity)getActivity()).setNavItem(R.id.navref);
        t1 = (TextView) v.findViewById(R.id.titleText1bt);
        t2 = (TextView) v.findViewById(R.id.titleDefbt);
        t3 = (TextView) v.findViewById(R.id.propBST1);
        t4 = (TextView) v.findViewById(R.id.propBST2);
        t5 = (TextView) v.findViewById(R.id.propBST3);
        t6 = (TextView) v.findViewById(R.id.codeText1);
        t7 = (TextView) v.findViewById(R.id.thisIsCodeBS1);
        t8 = (TextView) v.findViewById(R.id.thisIsCodeBS2);
        t9 = (TextView) v.findViewById(R.id.codeText2);
        t1.setText("Binary Search Tree");
        t2.setText("Binary Search Tree, is a node-based binary tree data structure which has the following properties");
        t3.setText("The left subtree of a node contains only nodes with keys lesser than the node’s key");
        t4.setText("The right subtree of a node contains only nodes with keys greater than the node’s key");
        t5.setText("The left and right subtree each must also be a binary search tree");
        t6.setText("// A utility function to search a given key in BST\n" +
                "public Node search(Node root, int key)\n" +
                "{\n" +
                "    // Base Cases: root is null or key is present at root\n" +
                "    if (root==null || root.key==key)\n" +
                "        return root;\n" +
                " \n" +
                "    // val is greater than root's key\n" +
                "    if (root.key > key)\n" +
                "        return search(root.left, key);\n" +
                " \n" +
                "    // val is less than root's key\n" +
                "    return search(root.right, key);\n" +
                "}\n");
        t7.setText("JAVA Code for searching in Binary Search Tree would look like this: ");
        t8.setText("JAVA Code for inserting in Binary Search Tree would look like this: ");
        t9.setText("// Java program to demonstrate insert operation in binary search tree\n" +
                "class BinarySearchTree {\n" +
                " \n" +
                "    /* Class containing left and right child of current node and key value*/\n" +
                "    class Node {\n" +
                "        int key;\n" +
                "        Node left, right;\n" +
                " \n" +
                "        public Node(int item) {\n" +
                "            key = item;\n" +
                "            left = right = null;\n" +
                "        }\n" +
                "    }\n" +
                " \n" +
                "    // Root of BST\n" +
                "    Node root;\n" +
                " \n" +
                "    // Constructor\n" +
                "    BinarySearchTree() { \n" +
                "        root = null; \n" +
                "    }\n" +
                " \n" +
                "    // This method mainly calls insertRec()\n" +
                "    void insert(int key) {\n" +
                "       root = insertRec(root, key);\n" +
                "    }\n" +
                "     \n" +
                "    /* A recursive function to insert a new key in BST */\n" +
                "    Node insertRec(Node root, int key) {\n" +
                " \n" +
                "        /* If the tree is empty, return a new node */\n" +
                "        if (root == null) {\n" +
                "            root = new Node(key);\n" +
                "            return root;\n" +
                "        }\n" +
                " \n" +
                "        /* Otherwise, recur down the tree */\n" +
                "        if (key < root.key)\n" +
                "            root.left = insertRec(root.left, key);\n" +
                "        else if (key > root.key)\n" +
                "            root.right = insertRec(root.right, key);\n" +
                " \n" +
                "        /* return the (unchanged) node pointer */\n" +
                "        return root;\n" +
                "    }\n" +
                " \n" +
                "    // This method mainly calls InorderRec()\n" +
                "    void inorder()  {\n" +
                "       inorderRec(root);\n" +
                "    }\n" +
                " \n" +
                "    // A utility function to do inorder traversal of BST\n" +
                "    void inorderRec(Node root) {\n" +
                "        if (root != null) {\n" +
                "            inorderRec(root.left);\n" +
                "            System.out.println(root.key);\n" +
                "            inorderRec(root.right);\n" +
                "        }\n" +
                "    }\n" +
                " \n" +
                "    // Driver Program to test above functions\n" +
                "    public static void main(String[] args) {\n" +
                "        BinarySearchTree tree = new BinarySearchTree();\n" +
                " \n" +
                "        /* Let us create following BST\n" +
                "              50\n" +
                "           /     \\\n" +
                "          30      70\n" +
                "         /  \\    /  \\\n" +
                "       20   40  60   80 */\n" +
                "        tree.insert(50);\n" +
                "        tree.insert(30);\n" +
                "        tree.insert(20);\n" +
                "        tree.insert(40);\n" +
                "        tree.insert(70);\n" +
                "        tree.insert(60);\n" +
                "        tree.insert(80);\n" +
                " \n" +
                "        // print inorder traversal of the BST\n" +
                "        tree.inorder();\n" +
                "    }\n" +
                "}\n" +
                "// This code is contributed by Ankur Narain Verma");
        return v;
    }
}
