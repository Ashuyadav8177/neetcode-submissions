public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};

        return buildTree(values, index);
    }

    private TreeNode buildTree(String[] values, int[] index) {
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(
            Integer.parseInt(values[index[0]++])
        );

        node.left = buildTree(values, index);
        node.right = buildTree(values, index);

        return node;
    }
}
