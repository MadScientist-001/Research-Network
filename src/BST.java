import java.util.HashSet;

/**
 * This class creates our
 * Binary Search Tree
 * which stores all the profiles
 * @author Rami
 */
public class BST {
    private BSTNode root;
    private String output = "";
    HashSet<Profile> allProfiles = new HashSet<>();

    public BST() {

    }

    /**
     * this method inserts a profile
     * into our tree by calling a
     * recursive method
     * @param p profile to be inserted
     *          into the tree
     */
    public void insertResearcher(Profile p) {
        BSTNode node = new BSTNode(p);
        /**checks if our tree is empty
         * if it is then inserts the
         * first node as root calls
         * recursive method otherwise
        */
        if (root == null) {
            root = node;
        } else {
            findInsertNode(p, root);
        }
    }

    /**
     * recursive method that finds where
     * should the profile be inserted
     * it is sorted according to ascending
     * alphabetical sequence of the
     * researcher's family names
     * @param p profile to be inserted
     * @param root root of the tree
     */
    private void findInsertNode(Profile p, BSTNode root) {
        if (root.getResearcher().getFamilyNames().
                compareTo(p.getFamilyNames()) > 0) {
            if (root.getL() == null) {
                root.setL(new BSTNode(p));
            } else {
                findInsertNode(p, root.getL());
            }
        } else if (root.getResearcher().getFamilyNames().
                compareTo(p.getFamilyNames()) < 0) {
            if (root.getR() == null) {
                root.setR(new BSTNode(p));
            } else {
                findInsertNode(p, root.getR());
            }

        }
    }

    /**
     * @return researcher's names in alphabetical order
     */
    public String printAlphabetical() {
        return traverseTree(root);
    }

    /**
     * recursive method that goes through tree
     * in ascending order adding all the profiles'
     * names to a string
     * @param node takes in root
     * @return a string that contains all the
     *         researcher's name in alphabetical order
     */
    private String traverseTree(BSTNode node) {
        if (node != null) {
            traverseTree(node.getL());
            output += node.getResearcher().getFamilyNames() + ", " +
                    node.getResearcher().getGivenNames() + "\n";
            traverseTree(node.getR());
        }
        return output;
    }

    /**
     * this method searches for a researcher
     * using their family name by calling a recursive
     * method
     * @param familyName family name of a researcher
     * @return the profile of this researcher
     */
    public Profile findProfile(String familyName) {
        return traverseSearch(root, familyName);
    }

    /**
     * @param node takes in root
     * @param familyName search target(family name of researcher)
     * @return the profile of this researcher
     */
    private Profile traverseSearch(BSTNode node, String familyName) {

        if (node != null) {
            if (node.getResearcher().getFamilyNames().
                    equals(familyName)) {
                return node.getResearcher();
            } else if (node.getResearcher().getFamilyNames().
                    compareTo(familyName) > 0) {
                return traverseSearch(node.getL(), familyName);
            } else {
                return traverseSearch(node.getR(), familyName);
            }
        }
        return null;
    }


    /**
     * this method calls a recursive method to
     * add all profiles in the tree to a HashSet
     * @return all profiles in a HashSet
     * used for our Graph class
     */
    public HashSet<Profile> getAllProfiles() {

        return traverseTreeForProfiles(root);
    }

    /**
     * @param node takes in root
     * @return a HashSet of all the profiles
     */
    private HashSet<Profile> traverseTreeForProfiles(BSTNode node) {
        if (node != null) {
            traverseTreeForProfiles(node.getL());
            allProfiles.add(node.getResearcher());
            traverseTreeForProfiles(node.getR());
        }
        return allProfiles;
    }
}


