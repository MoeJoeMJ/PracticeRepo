
class TreeNode<T> {
    private T data;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}

class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    public BinaryTree() {
        root = null;
    }

    public void add(T data) {
        root = recursiveAdd(data, root);
    }

    public TreeNode<T> recursiveAdd(T data,TreeNode<T> root) {
        if (root == null) {
            return new TreeNode<>(data);
        }
        if (root.getData().equals(data)) {
            return root;
        }
        else if (data.compareTo(root.getData()) < 0) {
            root.left = recursiveAdd(data, root.left);
        }
        else {
            root.right = recursiveAdd(data,root.right);
        }
        return root;
    }

}

public class BinaryTreeUsingGenerics {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(8);
    }

}
