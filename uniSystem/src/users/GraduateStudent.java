package users;

import additional.DissertationProject;
import enums.GraduateStudentType;
import researcher.ResearchProject;
import researcher.Researcher;

public class GraduateStudent extends Student implements Researcher {

    private GraduateStudentType studentType;
    private DissertationProject dissertationProject;

    public GraduateStudent(String login, String password) {
        super(login, password);
    }

    private GraduateStudentType getStudentType() {
        return this.studentType;
    }

    private void setStudentType(GraduateStudentType studentType) {
        this.studentType = studentType;
    }

    private DissertationProject getDissertationProject() {
        return this.dissertationProject;
    }

    private void setDissertationProject(DissertationProject dissertationProject) {
        this.dissertationProject = dissertationProject;
    }

    @Override
    public void addProject(ResearchProject researchProject) {
        // TODO: Implement
    }

    @Override
    public String printPapers(String sortType) {
        // TODO: Implement
        return null;
    }

    @Override
    public void calculateHIndex() {
        // TODO: Implement
    }
}
