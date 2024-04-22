//class Node {
//    Product product;
//    Node left, right;
//
//    public Node(Product product) {
//        this.product = product;
//        this.left = this.right = null;
//    }
//}
class Node {
    Product data;
    Node left;
    Node right;

    Node(Product data) {
        this.data = data;
        left = right = null;
    }
}