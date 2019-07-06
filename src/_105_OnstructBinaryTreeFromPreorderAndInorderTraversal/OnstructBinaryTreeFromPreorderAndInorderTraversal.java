package _105_OnstructBinaryTreeFromPreorderAndInorderTraversal;

public class OnstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int getInorderIndex(int[] inorder, int nodeVal) {
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == nodeVal) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int leftOrderLen = getInorderIndex(inorder, preorder[0]);
        if (leftOrderLen > 0) {
            int[] leftPreorder = new int[leftOrderLen], leftInorder = new int[leftOrderLen];
            System.arraycopy(preorder, 1, leftPreorder, 0, leftPreorder.length);
            System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
            node.left = buildTree(leftPreorder, leftInorder);
        }
        int rightOrderLen = inorder.length - leftOrderLen - 1;
        if ((rightOrderLen) > 0) {
            int[] rightPreorder = new int[rightOrderLen], rightInorder = new int[rightOrderLen];
            System.arraycopy(preorder, leftOrderLen + 1, rightPreorder, 0, rightPreorder.length);
            System.arraycopy(inorder, leftOrderLen + 1, rightInorder, 0, rightInorder.length);
            node.right = buildTree(rightPreorder, rightInorder);
        }
        return node;
    }
}
