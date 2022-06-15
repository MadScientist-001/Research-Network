/**
 * this class creates the nodes
 * that store the profiles
 * the nodes are used to create
 * our Binary Search Tree
 * @author Rami
 */
public class BSTNode {
    private Profile researcher;
    private BSTNode l;
    private BSTNode r;

    /**
     * @param elem the element stored in our nodes
     */
    public BSTNode(Profile elem) {
        this.researcher = elem;
    }

    /**
     * @return gets the researcher of the node
     */
    public Profile getResearcher() {
        return researcher;
    }


    /**
     * @return gets the left child
     *          of the node
     */
    public BSTNode getL() {
        return l;
    }

    /**
     * @param l sets the left child
     *          of the node
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * @return gets the right child
     *          of the node
     */
    public BSTNode getR() {
        return r;
    }

    /**
     * @param r sets the right child
     *          of the node
     */
    public void setR(BSTNode r) {
        this.r = r;
    }


}
