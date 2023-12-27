package users;

import java.io.InvalidClassException;

/**
 * The GraduateStudent class represents a graduate student in the university.
 * Extends the Student class and implements the Researcher interface.
 */
import java.util.Collections;
import java.util.Optional;
import java.util.Vector;

import additional.DissertationProject;
import data.Data;
import enums.GraduateStudentType;
import researcher.LowHIndex;
import researcher.PaperCitationComparator;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import researcher.Researcher;
import researcher.ResearcherDecorator;

public class GraduateStudent extends Student implements Researcher {

	private GraduateStudentType studentType;
    private DissertationProject dissertationProject;
    private Researcher supervisor;
    
    
    
    public Vector<ResearchProject> projects = new Vector<ResearchProject>();
    
    public Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    
    public double hindex;
    
    /**
     * Constructs a new GraduateStudent with the specified login and password.
     *
     * @param login     The login ID of the graduate student.
     * @param password  The password of the graduate student.
     */
    public GraduateStudent(String login, String password) {
        super(login, password);
    }
    
    /**
     * Gets the student type of the graduate student.
     *
     * @return The student type.
     */

	private GraduateStudentType getStudentType() {
        return this.studentType;
    }
	
	/**
     * Sets the student type for the graduate student.
     *
     * @param studentType The student type to be set.
     */

    private void setStudentType(GraduateStudentType studentType) {
        this.studentType = studentType;
    }
    
    /**
     * Gets the dissertation project of the graduate student.
     *
     * @return The dissertation project.
     */

    private DissertationProject getDissertationProject() {
        return this.dissertationProject;
    }
    
    /**
     * Sets the dissertation project for the graduate student.
     *
     * @param dissertationProject The dissertation project to be set.
     */

    private void setDissertationProject(DissertationProject dissertationProject) {
        this.dissertationProject = dissertationProject;
    }
    /**
     * Prints the papers of the graduate student, sorted based on the specified sort type.
     *
     * @param sortType The sort type ("by citations").
     * @return A string representation of the papers.
     */
  


   
    public String printPapers(String sortType) {
    	if(sortType == "by citations") {				
			Collections.sort(papers, new PaperCitationComparator());
		}
		String p = "";
		for(ResearchPaper cur: papers) {
			p += cur.toString();
		}
		return p;
    }

    /**
     * Calculates the h-index for the graduate student.
     */
    public void calculateHIndex() {
    	int minimalCitations = Integer.MAX_VALUE;
		for(ResearchPaper paper: papers) {
			if (paper.citations.size() < minimalCitations) {
				minimalCitations = paper.citations.size();
			}
		}
		hindex = minimalCitations;
		if(hindex < 3) {
			System.out.println(new LowHIndex("your hindex lesser than 3"));
		}
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



	


	@Override
	public void newProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants) {
		if(!Data.getInstance().getResearchProject().stream().anyMatch(n -> n.topic.equals(topic))) {
			ResearchProject rp = new ResearchProject(topic, publishedPapers, participants);
			projects.add(rp);
			Data.getInstance().addResearchProject(rp);
			System.out.println("succes"); 
		}
		else {
			System.out.println("this project already exist");

		}
	}

	@Override
	public void newPaper(ResearchPaper rp) {
		if(! Data.getInstance().getResearchPaper().stream().anyMatch(n -> n.equals(rp))) {
			papers.add(rp);
			System.out.println("succes"); 
			Data.getInstance().addResearchPaper(rp);
		}
		else {
			System.out.println("this project already exist");

		}
	}

	@Override
	public void newProject(ResearchProject rp) {
		if(! Data.getInstance().getResearchProject().stream().anyMatch(n -> n.equals(rp))) {
			projects.add(rp);
			Data.getInstance().addResearchProject(rp);
			System.out.println("succes"); 
		}
		else {
			System.out.println("this project already exist");
		}		
	}

	@Override
    public void newPaper(String name, int pages, String journal, String text) {
		if(! Data.getInstance().getResearchPaper().stream().anyMatch(n -> n.name.equals(name))) {
			ResearchPaper rp = new ResearchPaper(name, pages, journal, text);
			papers.add(rp);
			Data.getInstance().addResearchPaper(rp);
			System.out.println("succes"); 
		}
		else {
			System.out.println("this project already exist");

		}	};

		/**
	     * Joins a specified project based on the given topic.
	     *
	     * @param topic The topic of the project to join.
	     */
	@Override
	public void joinProject(String topic) {
		Optional<ResearchProject> matchingProject = Data.getInstance().getResearchProject().stream()
                .filter(n -> n.topic.equals(topic))
                .findFirst();

		if (matchingProject.isPresent()) {
		// Add the found project to the projects vector
		projects.add(matchingProject.get());
		} else {
		System.out.println("Not existing project");
		}
	}

	 /**
     * Joins a specified paper based on the given name.
     *
     * @param name The name of the paper to join.
     */

	@Override
	public void joinPaper(String name) {
		Optional<ResearchPaper> matchingPaper = Data.getInstance().getResearchPaper().stream()
                .filter(n -> n.name.equals(name))
                .findFirst();

		if (matchingPaper.isPresent()) {
		// Add the found project to the projects vector
		papers.add(matchingPaper.get());
		} else {
		System.out.println("Not existing project");
		}
		
	}

}
