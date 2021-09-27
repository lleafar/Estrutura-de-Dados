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

    // criar árvore binária e adicionar os valores (exemplo)
    // private BinaryTree createBinaryTree() {
    //     BinaryTree b = new BinaryTree();

    //     b.add(4);
    //     b.add(5);
    //     b.add(3);

    //     return b;
    // }
}
