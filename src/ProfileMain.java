import java.util.ArrayList;

public class ProfileMain {
    public static void main(String[] args) {
        ArrayList<String> researchInts = new ArrayList<>();
        researchInts.add("history");
        Profile p1 = new Profile("Troy Kaighin","Astarte",
                2019, 2,28,
                "t.k.astarte@swansea.ac.uk", researchInts);
        System.out.println(p1.getDateOfPhD());

    }
}
