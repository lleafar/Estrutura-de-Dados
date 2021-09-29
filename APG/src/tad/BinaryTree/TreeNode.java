package tad.BinaryTree;

import java.util.HashMap;
import java.util.Map;

import utils.Estudante;

/**
 * TreeNode
 */
public class TreeNode {

    private Estudante estudante = new Estudante();
    public Map<Integer, String> m = new HashMap<>();

    TreeNode left;
    TreeNode right;

    int v;

    TreeNode(int v) {
        m.put(estudante.getMatricula(), estudante.getCurso());
        this.v = estudante.getMatricula();
        right = null;
        left = null;
    }

    public Estudante getEstudante() {
        return estudante;
    }
}