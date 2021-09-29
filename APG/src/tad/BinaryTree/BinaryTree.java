package tad.BinaryTree;

public class BinaryTree {
    TreeNode root;

    private TreeNode addRec(TreeNode c, int v) {
        if (c == null) {
            return new TreeNode(v);
        }

        if (v < c.v) {
            c.left = addRec(c.left, v);
        } else if (v > c.v) {
            c.right = addRec(c.right, v);
        } else {
            return c;
        }
        return c;
    }

    public void add(int v) {
        root = addRec(root, v);
    }

    private TreeNode deleteRec(TreeNode c, int v) {
        if (c == null) {
            return null;
        }

        if (v == c.v) {

        }

        if (v < c.v) {
            c.left = deleteRec(c.left, v);
            return c;
        }

        c.right = deleteRec(c.right, v);
        return c;
    }

    public void delete(int v) {
        root = deleteRec(root, v);
    }

    public void traverseInOrder(TreeNode tn) {
        if (tn != null) {
            traverseInOrder(tn.left);
            //printar
            traverseInOrder(tn.right);
        }
    }

    // criar árvore binária e adicionar os valores (exemplo)
    // private BinaryTree createBinaryTree() {
    //     BinaryTree b = new BinaryTree();

    //     b.add(4);
    //     b.add(5);
    //     b.add(3);

    //     return b;
    // }
}
