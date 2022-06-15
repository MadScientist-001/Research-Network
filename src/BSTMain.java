import java.util.ArrayList;

public class BSTMain {
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
        BST t1 =new BST();

    }
}
