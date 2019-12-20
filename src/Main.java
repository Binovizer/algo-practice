import tree.TreeNode;

public class Main {

  public static void main(String[] args) {
    String s1 = "abc";
    String s2 = "bcd";

    String s3 = s1;
    s3 = "def";

    System.out.println("s1 = " + s1);
    System.out.println("s2 = " + s2);
    System.out.println("s3 = " + s3);

    TreeNode node = new TreeNode(1);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = node;

    node3.data = 2;

    System.out.println("node = " + node.data);
    System.out.println("node2 = " + node2.data);
    System.out.println("node3 = " + node3.data);
  }
}
