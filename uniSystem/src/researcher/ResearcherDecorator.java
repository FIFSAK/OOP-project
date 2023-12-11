package researcher;

import java.util.Collections;
import java.util.Set;
import java.util.Vector;

import enums.Format;
import users.Student;
import users.User;
import users.Employee;

public class ResearcherDecorator implements Researcher {	   
	    private User user;
	    
	    public Vector<ResearchProject> projects;
	    
	    public Vector<ResearchPaper> papers;
	    
	    public double hindex;
	    
	    public ResearcherDecorator () {}
	    
	    public ResearcherDecorator (User u) {
	    	user = u;
	    }
	    
	    
	    public User getWrappedUser(){
	    	return user;
	    }
	    public Student getWrappedStudent(){
	    	return (Student) user;
	    }
	    public Employee getWrappedEmployee(){
	    	return (Employee) user;
	    }
		@Override
		public void addProject(ResearchProject researchProject) {
			// TODO Auto-generated method stub
			projects.add(researchProject);
			
		}
		@Override
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
		@Override
		public void calculateHIndex() {
			Set<ResearchPaper> s = null;
			int minimalCitations = Integer.MAX_VALUE;
			for(ResearchProject project: projects) {
				for(ResearchPaper paper: project.getPapers()) {
					s.add(paper);
					if (paper.getCitation(Format.PLAIN_TEXT).size() < minimalCitations) {
						minimalCitations = paper.getCitation(Format.PLAIN_TEXT).size();
					}
				}
			}
			hindex = minimalCitations;
			if(hindex < 3) {
				new LowHIndex("your hindex lesser than 3");
			}
		}
		
		public String toString() {
			if(user instanceof Student) {
				user = (Student) user;
			}
			else if(user instanceof Employee) {
				user = (Employee) user;
			}
			return user.toString() + " projects: " + projects.toString() + " hindex: " +hindex;
		}
		
		public void newProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants) {
			projects.add(new ResearchProject(topic, publishedPapers, participants));
		}
		public void newPaper(String name, 
				Vector<ResearchPaper> citations,
				Vector<ResearcherDecorator> authors, 
				int pages, String journal) {
			papers.add(new ResearchPaper(name, citations, authors, pages, journal));
			
		}
		
		

}
