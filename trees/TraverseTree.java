package trees;

public class TraverseTree<T> {
    public static void main(String[] args) {
        TraverseTree<String> traverser = new TraverseTree<>();
        traverser.preorder();
        traverser.inorder();
        traverser.postorder();
    }

    private void postorder() {
        BstTreeNode<String> root = create(4);
        postorder(root);
        System.out.println();
    }

    private void inorder() {
        BstTreeNode<String> root = create(4);
        inorder(root);
        System.out.println();
    }

    private void preorder() {
        BstTreeNode<String> root = create(0);
        root = create(4);
        preorder(root);
        System.out.println();
    }

    private void doOperation(String data) {
        System.out.print(", " + data);
    }

    private void postorder(BstTreeNode bst) {
        if (bst == null) return;
        postorder(bst.left);
        postorder(bst.right);
        bst.doOperation();
    }

    private void preorder(BstTreeNode bst) {
        if (bst == null) return;
        bst.doOperation();
        preorder(bst.left);
        preorder(bst.right);
    }

    private void inorder(BstTreeNode bst) {
        if (bst == null) return;
        inorder(bst.left);
        bst.doOperation();
        inorder(bst.right);
    }

    /* helper method to create the tree with different levels
     * 0                 7
     * 1           1          9
     * 2        0    3     8     10
     * 3           2   5
     * 4             4   6
     */
    private BstTreeNode<String> create(int level) {
        BstTreeNode<String> root = new BstTreeNode<>(null, null, "7");
        BstTreeNode<String> fifteen = null;
        BstTreeNode<String> seventeen = null;
        BstTreeNode<String> six = null;
        BstTreeNode<String> twentyone = null;
        BstTreeNode<String> three = null;
        BstTreeNode<String> five = null;

        if (level >= 1) {
            fifteen = new BstTreeNode<>("9");
            six = new BstTreeNode<>("1");

            root.left = six;
            root.right = fifteen;

        }
        if (level >= 2) {
            three = new BstTreeNode<>("0");
            five = new BstTreeNode<>("3");
            BstTreeNode<String> eight = new BstTreeNode<>("8");
            seventeen = new BstTreeNode<>("10");

            six.left = three;
            six.right = five;
            fifteen.left = eight;
            fifteen.right = seventeen;
        }
        if (level >= 3) {
            BstTreeNode<String> one = new BstTreeNode<>("2");
            BstTreeNode<String> two = new BstTreeNode<>("x");
            twentyone = new BstTreeNode<>("5");

            five.left = one;
            five.right = twentyone;
        }

        if (level >= 4) {
            BstTreeNode<String> eighteen = new BstTreeNode<>("4");
            BstTreeNode<String> nL4_1 = new BstTreeNode<>("6");

            twentyone.left = eighteen;
            twentyone.right = nL4_1;
        }

        return root;
    }

    public static class BstTreeNode<T> {
        BstTreeNode<T> left;
        BstTreeNode<T> right;
        T data;

        public BstTreeNode(BstTreeNode<T> left, BstTreeNode<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public BstTreeNode(T data) {
            this.data = data;
        }

        public void doOperation() {
            System.out.print(", " + data);
        }
    }
}
