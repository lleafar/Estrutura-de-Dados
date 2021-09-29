package tad.BinaryTree;

import utils.Estudante;

/**
 * Créditos: baeldung.com
 */

public class BinaryTree {
    public TreeNode root;

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
            // sem nós filhos
            if (c.left == null && c.right == null) {
                return null;
            }

            // um nó filho na esquerda
            if (c.right == null) {
                return c.left;
            }
            
            // um nó filho na direita
            if (c.left == null) {
                return c.right;
            }

            // dois nós filhos
            int smallestValue = findSmallestValue(c.right);
            c.v = smallestValue;
            c.right = deleteRec(c.right, smallestValue);
            return c;
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

    // pesquisa in-order
    public int estudantesES;
    public void traverseInOrder(TreeNode tn) {
        tn = root;
        if (tn != null) {
            traverseInOrder(tn.left);
            if (tn.getEstudante().isCursoES()) {
                estudantesES++;
            }
            traverseInOrder(tn.right);
        }
        System.out.println(estudantesES);
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.v : findSmallestValue(root.left);
    }

}
