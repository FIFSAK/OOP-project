package users;

import java.io.InvalidClassException;
import java.io.Serializable;
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

public class GraduateStudent extends Student implements Researcher, Serializable {

	private GraduateStudentType studentType;
    private DissertationProject dissertationProject;
    private Researcher supervisor;
    
    
    
    public Vector<ResearchProject> projects = new Vector<ResearchProject>();
    
    public Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    
    public double hindex;
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
