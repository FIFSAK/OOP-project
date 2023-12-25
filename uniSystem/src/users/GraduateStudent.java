package users;

import java.io.InvalidClassException;
import java.util.Vector;

import additional.DissertationProject;
import enums.GraduateStudentType;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import researcher.Researcher;
import researcher.ResearcherDecorator;

public class GraduateStudent extends Student implements Researcher {

	private GraduateStudentType studentType;
    private DissertationProject dissertationProject;
    private Researcher supervisor;

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

  
    public void addProject(ResearchProject researchProject) {
        // TODO
    	 if (dissertationProject == null) {
             dissertationProject = new DissertationProject();
         }
         dissertationProject.addResearchProject(researchProject);
    }

   
    public String printPapers(String sortType) {
        // TODO
        return "Papers printed based on sortType";
    }

    
    public void calculateHIndex() {
        // TODO: Implement h-index calculation
    }

//	public Researcher getSupervisor() {
//		return supervisor;
//	}

//	public void setSupervisor(Researcher supervisor){
//		try {
//            setSupervisor(supervisor);
//            this.supervisor = supervisor;
//        } catch (InvalidSupervisorException e) {
//            System.out.println(e.getMessage());
//        }
//    }
	
//	private void validateSupervisor(Researcher supervisor) throws InvalidSupervisorException {
//        if (studentType == GraduateStudentType.MASTER || studentType == GraduateStudentType.PHD) {
//            if (supervisor.calculateHIndex() < 3) {
//                throw new InvalidSupervisorException("Supervisor must have an h-index >= 3 ");
//            }
//        }
//    }



	
=======


	@Override
	public void newProject(String topic, Vector<ResearchPaper> publishedPapers,
			Vector<ResearcherDecorator> participants) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newPaper(ResearchPaper rp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newProject(ResearchProject rp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newPaper(String name, Vector<ResearchPaper> citations, int pages, String journal) {
		// TODO Auto-generated method stub
		
	}

}
