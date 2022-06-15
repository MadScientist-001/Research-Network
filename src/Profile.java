import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class creates the profile for the users
 *
 * @author Rami
 */
public class Profile {
    private String familyNames;
    private String givenNames;
    private int yearPhD;
    private int monthPhD;
    private int dayPhD;
    private String email;
    private ArrayList<String> researchInts;
    /**
     * collaborators Hashset that stores the profiles
     * the researcher collaborated with
     */
    private HashSet<Profile> collaborators = new HashSet<>();


    /**
     * @param familyNames  the researcher's family name(String)
     * @param givenNames   the researcher's given name(String)
     * @param yearPhD      the year the researcher got his PhD(Int)
     * @param monthPhD     the month the researcher got his PhD(Int)
     * @param dayPhD       the day the researcher got his PhD(Int)
     * @param email        the researcher's email (String)
     * @param researchInts a list of the researcher's interests
     */
    public Profile(String familyNames, String givenNames, int yearPhD,
                   int monthPhD, int dayPhD, String email,
                   ArrayList<String> researchInts) {
        this.familyNames = familyNames;
        this.givenNames = givenNames;
        this.yearPhD = yearPhD;
        this.monthPhD = monthPhD;
        this.dayPhD = dayPhD;
        this.email = email;
        this.researchInts = researchInts;
    }

    /**
     * @param p profile parameter added into collaborator set
     */
    public void collaborate(Profile p) {
        collaborators.add(p);
    }

    /**
     * @param p profile used to check if this
     *          profile has been collaborated with before
     * @return true if researcher has collaborated
     * with a profile p false otherwise
     */
    public boolean hasCollaboratedWith(Profile p) {
        return collaborators.contains(p);
    }

    /**
     * @return the number of people the researcher
     * collaborated with
     */
    public int numOfCollabs() {
        return collaborators.size();
    }

    /**
     * @return family name of the researcher
     */
    public String getFamilyNames() {
        return familyNames;
    }

    /**
     * @param familyNames setter for the researcher's family name
     */
    public void setFamilyNames(String familyNames) {
        this.familyNames = familyNames;
    }

    /**
     * @return researcher's given name
     */
    public String getGivenNames() {
        return givenNames;
    }

    /**
     * @param givenNames setter for the researcher's given name
     */
    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    /**
     * @return researcher's year of PhD
     */
    public int getYearPhD() {
        return yearPhD;
    }

    public void setYearPhD(int yearPhD) {
        this.yearPhD = yearPhD;
    }

    /**
     * @return researcher's month of PhD
     */
    public int getMonthPhD() {
        return monthPhD;
    }

    /**
     * @param monthPhD sets the researcher's month of PhD
     */
    public void setMonthPhD(int monthPhD) {
        this.monthPhD = monthPhD;
    }

    /**
     * @return researcher's day of PhD
     */
    public int getDayPhD() {
        return dayPhD;
    }

    /**
     * @param dayPhD sets the researcher's PhD
     */
    public void setDayPhD(int dayPhD) {
        this.dayPhD = dayPhD;

    }

    public String getDateOfPhD() {
        return String.format("%02d-%02d-%02d", yearPhD, monthPhD, dayPhD);
    }

    /**
     * @return the researcher's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email setter for the researcher's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return list of the researcher's research interests
     */
    public ArrayList<String> getResearchInts() {
        return researchInts;
    }

    /**
     * @param researchInts setter for the researcher's
     *                     list of interests
     */
    public void setResearchInts(ArrayList<String> researchInts) {
        this.researchInts = researchInts;
    }

    /**
     * @return a string of the researcher's
     *         collaborators' family names
     *         to be used in toString
     */
    public String getCollaboratorNames() {
        String collaboratorName = "";
        for (Profile p : this.collaborators) {
            collaboratorName += p.getFamilyNames() + " ";
        }
        return collaboratorName;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "familyNames='" + familyNames + '\'' +
                ", givenNames='" + givenNames + '\'' +
                getDateOfPhD() +
                ", email='" + email + '\'' +
                ", researchInts=" + researchInts +
                ", collaborators= " + getCollaboratorNames() +
                '}';
    }
}