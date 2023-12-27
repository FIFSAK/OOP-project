package additional;

import java.io.Serializable;

import researcher.ResearchProject;
import users.GraduateStudent;


public class DissertationProject implements Serializable {

/**
 * The {@code DissertationProject} class represents a dissertation project
 * undertaken by a graduate student. It includes information about the thesis,
 * the main content, and the associated graduate student.
 */


    /**
     * The thesis of the dissertation project.
     */
    private String thesis;

    /**
     * The main content of the dissertation project.
     */
    private String main;

    /**
     * The graduate student associated with the dissertation project.
     */
    private GraduateStudent graduateStudent;

    /**
     * Constructs a new dissertation project.
     */
    public DissertationProject() {
        this.thesis = "";
        this.main = "";
        this.graduateStudent = null;
    }

    /**
     * Gets the thesis of the dissertation project.
     *
     * @return The thesis of the dissertation project.
     */
    public String getThesis() {
        return thesis;
    }

    /**
     * Sets the thesis of the dissertation project.
     *
     * @param thesis The thesis of the dissertation project.
     */
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    /**
     * Gets the main content of the dissertation project.
     *
     * @return The main content of the dissertation project.
     */
    public String getMain() {
        return main;
    }

    /**
     * Sets the main content of the dissertation project.
     *
     * @param main The main content of the dissertation project.
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * Gets the graduate student associated with the dissertation project.
     *
     * @return The graduate student associated with the dissertation project.
     */
    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    /**
     * Sets the graduate student associated with the dissertation project.
     *
     * @param graduateStudent The graduate student associated with the dissertation project.
     */
    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    // Additional operations based on project requirements

    /**
     * Submits the thesis of the dissertation project.
     */
    public void submitThesis() {
        // TODO: Implement logic to submit the thesis
    }

    /**
     * Reviews the thesis of the dissertation project.
     *
     * @return The review result or comments.
     */
    public String reviewThesis() {
        // TODO: Implement logic to review the thesis
        return "";
    }

    /**
     * Adds a research project to the dissertation project.
     *
     * @param researchProject The research project to be added.
     */
    public void addResearchProject(ResearchProject researchProject) {
        // TODO: Implement logic to add a research project
    }
}

