import java.util.ArrayList;

public class BSTNodeMain {
    public static void main(String[] args) {
        ArrayList<String> researchInts = new ArrayList<>();
        researchInts.add("history");
        Profile p1 = new Profile("Troy Kaighin", "Astarte",
                2019, 2, 28,
                "t.k.astarte@swansea.ac.uk", researchInts);
        Profile p2 = new Profile("Bob", "Astarte",
                2019, 2, 28,
                "t.k.astarte@swansea.ac.uk", researchInts);
        Profile p3 = new Profile("Andrew", "Astarte",
                2019, 2, 28,
                "t.k.astarte@swansea.ac.uk", researchInts);

        BSTNode n1 = new BSTNode(p1);
        BSTNode n2 = new BSTNode(p2);
        BSTNode n3 = new BSTNode(p3);
        System.out.println(n3.getResearcher());
    }
}
