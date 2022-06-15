import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * this class creates a
 * graph of the collaborators
 * using a EdgeList
 * @author Rami
 */
public class Graph {
    BST tree;

    /**
     * the constructor adds collaborators
     * to the graph according the EdgeList
     * file
     * @param fileName a string of the file
     *                 containing our EdgeList
     * @param tree a Tree with all the profiles
     */
    public Graph(String fileName, BST tree) {
        this.tree = tree;
        addCollaborator(readEdgeList(fileName));
    }

    /**
     * this method reads the EdgeList file
     * @param fileName name of the EdgeList file
     * @return HashSet of all the edges created
     */
    private static HashSet<Graph.Edge> readEdgeList(String fileName) {
        HashSet<Graph.Edge> edgeList = new HashSet<>();
        File inputFile = new File(fileName);
        Scanner edgeListReader;
        try {
            edgeListReader = new Scanner(inputFile);
            while (edgeListReader.hasNextLine()) {
                edgeList.add(readEdges(edgeListReader.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
            System.exit(0);
        }

        return edgeList;
    }

    /**
     * this method takes every line from the
     * EdgeList and create the edges
     * @param edges a String line from the file
     * @return the edge created
     */
    private static Graph.Edge readEdges(String edges) {
        Scanner readEdges = new Scanner(edges);
        readEdges.useDelimiter(",");
        Graph.Edge edge = new Graph.Edge(readEdges.next(), readEdges.next());
        return edge;
    }

    /**
     * this method adds the researchers
     * to each other's collaborator HashSet
     * @param edgeList A HashSet of edges
     */
    private void addCollaborator(HashSet<Edge> edgeList) {
        for (Edge edge : edgeList) {
            if (tree.findProfile(edge.getResearcher()) != null ||
                    tree.findProfile(edge.getCollaborator()) != null) {
                tree.findProfile(edge.getResearcher()).collaborate
                        (tree.findProfile(edge.getCollaborator()));
                tree.findProfile(edge.getCollaborator()).collaborate
                        (tree.findProfile(edge.getResearcher()));
            }
        }
    }

    /**
     * this method finds the profile
     * with the most collaborations
     * @param profileList takes in an Arraylist of profiles
     * @return the profile with the most collaborations
     */
    private Profile getMostCollaborator(ArrayList<Profile> profileList) {
        Profile most = profileList.get(0);
        for (Profile profile : profileList) {
            if (most.numOfCollabs() < profile.numOfCollabs()) {
                most = profile;
            }
        }
        return most;
    }

    /**
     * this method gets the suitable collaborator
     * by calling method mostCollaborator
     * @param researcher takes in a profile
     * @return profile of suitable
     * if a suitable collaborator was found
     * the researcher otherwise
     */
    private Profile getSuitableCollaborator(Profile researcher) {
        ArrayList<Profile> profileList = new ArrayList<>(tree.getAllProfiles());
        for (Profile profile : new ArrayList<Profile>(profileList)) {
            if (researcher.hasCollaboratedWith(profile)) {
                profileList.remove(profile);
            }
            profileList.remove(researcher);
        }
        if (profileList.size() == 0) {
            return researcher;
        } else {
            return getMostCollaborator(profileList);
        }
    }

    /**
     * finds the influencer using getSuitableCollaborator
     * @param familyNames takes in family name of a researcher
     * @return influencer profile to collab with the researcher
     */
    public Profile findInfluencer(String familyNames) {
        return getSuitableCollaborator(tree.findProfile(familyNames));
    }


    /**
     * this class creates
     * the edges to our graph
     */
    public static class Edge {
        private String researcher;
        private String collaborator;

        Edge(String researcher, String collaborator) {
            this.collaborator = collaborator;
            this.researcher = researcher;
        }

        public String getResearcher() {
            return researcher;
        }

        public String getCollaborator() {
            return collaborator;
        }

    }

}
