import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads a file that
 * contains details of the researchers
 * and then creates their profiles
 * then adds them to our
 * Binary Search Tree
 * @author Rami
 */
public class FileReader {

    /**
     * this method reads a segment from the profile line
     * since this segment uses different tokens
     * this segment is the researcher's interests
     * the interests are then added into a list
     *
     * @param researchInts string segment taken
     *                     from the file
     * @return a list of the
     * researcher's interests
     */
    private static ArrayList<String> readResearchInts(String researchInts) {
        Scanner in = new Scanner(researchInts);
        in.useDelimiter("/");
        ArrayList<String> researchIntsList = new ArrayList<>();
        while (in.hasNext()) {
            researchIntsList.add(in.next());
        }
        return researchIntsList;
    }

    /**
     * this method creates a profile using the
     * data taken from the readLineByLine method
     *
     * @return the profile created
     */
    private static Profile createProfile(String givenNames, String familyNames, int yearOfPhD,
                                         int monthOfPhD, int dayOfPhD, String email,
                                         ArrayList<String> researchInts) {
        return new Profile(givenNames, familyNames, yearOfPhD, monthOfPhD, dayOfPhD, email, researchInts);
    }

    /**
     * method takes the file line by line and
     * reads it since every profile is one line
     *
     * @param profile string parameter that takes in
     *                the line taken from the file
     * @return a profile from a method called createProfile
     */
    private static Profile readLineByLine(String profile) {
        Scanner readProfile = new Scanner(profile);
        readProfile.useDelimiter(",");
        String givenNames = "";
        String familyNames = "";
        String dateOfPhD = "";
        String email = "";
        String researchInts = "";
        /**
         * this loop reads through the line
         * until the line is done
         * the Scanner separates the parameters
         * of the profile from the line
         */
        while (readProfile.hasNext()) {
            givenNames = readProfile.next();
            familyNames = readProfile.next();
            dateOfPhD = readProfile.next();
            email = readProfile.next();
            researchInts = readProfile.next();
        }
        String[] arrayOfDates = dateOfPhD.split("-");
        int yearOfPhD = Integer.parseInt(arrayOfDates[0]);
        int monthOfPhD = Integer.parseInt(arrayOfDates[1]);
        int dayOfPhD = Integer.parseInt(arrayOfDates[2]);
        return createProfile(familyNames, givenNames, yearOfPhD, monthOfPhD, dayOfPhD, email,
                readResearchInts(researchInts));
    }

    /**
     * @param fileName string parameter that
     *                 contains the file's name
     * @return a tree with all the profiles read
     * from the file added in
     */
    public static BST readResearcherProfiles(String fileName) {
        File inputFile = new File(fileName);
        Scanner in;
        BST researcherProfilesTree = new BST();
        try {
            in = new Scanner(inputFile);
            /**
             * this loop goes through the file taking every line
             * and sends it to the readLineByLine method
             * which after the method returns a profile
             * the profile is added to the tree using
             * the insertResearcher method from our BST class
             */
            while (in.hasNextLine()) {
                researcherProfilesTree.insertResearcher(readLineByLine(in.nextLine()));
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
            System.exit(0);
        }

        return researcherProfilesTree;
    }


}

