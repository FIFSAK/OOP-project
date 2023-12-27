package additional;

import java.io.Serializable;

import researcher.ResearchProject;
import users.GraduateStudent;

public class DissertationProject implements Serializable {
    
    private String thesis;
    private String main;
    private GraduateStudent graduateStudent;
    
    public DissertationProject() {
        this.thesis = thesis;
        this.main = main;
        this.graduateStudent = graduateStudent;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    // Additional operations based on project requirements
    public void submitThesis() {
        // TODO: Implement logic to submit the thesis
    }

    public String reviewThesis() {
        // TODO: Implement logic to review the thesis
        return "";
    }

	public void addResearchProject(ResearchProject researchProject) {
		// TODO Auto-generated method stub
		
	}
}
