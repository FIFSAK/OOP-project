package researcher;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

import javax.security.auth.login.LoginException;

import enums.Format;
import users.Student;
import users.User;
import users.Employee;

public class ResearcherDecorator implements Researcher {	   
	    private User user;
	    
	    public Vector<ResearchProject> projects = new Vector<ResearchProject>();
	    
	    public Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
	    
	    public double hindex;
	    
	    public ResearcherDecorator () {}
	    
	    public ResearcherDecorator (User u) {
	    	user = u;
	    }
	    
	    

	    public User getWrapped(){
	    	if(user instanceof Student) {	    		
	    		return (Student) user;
	    	}
	    	if(user instanceof Employee) {	    		
	    		return (Employee) user;
	    	}
	    	
	    	return user;
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
		public void calculateHIndex() throws LowHIndex {
			int minimalCitations = Integer.MAX_VALUE;
				for(ResearchPaper paper: papers) {
					if (paper.getCitation(Format.PLAIN_TEXT).size() < minimalCitations) {
						minimalCitations = paper.getCitation(Format.PLAIN_TEXT).size();
					}
				}
			hindex = minimalCitations;
			if(hindex < 3) {
				System.out.println(new LowHIndex("your hindex lesser than 3"));
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
		
		public void newProject(ResearchProject rp) {
			projects.add(rp);
		}
		
		public void newPaper(String name, 
				int pages, String journal) {
			papers.add(new ResearchPaper(name, pages, journal));
			
		}
		public void newPaper(ResearchPaper rp) {
			papers.add(rp);
			
		}

		@Override
		public int hashCode() {
			return Objects.hash(hindex, papers, projects, user);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ResearcherDecorator other = (ResearcherDecorator) obj;
			return Double.doubleToLongBits(hindex) == Double.doubleToLongBits(other.hindex)
					&& Objects.equals(papers, other.papers) && Objects.equals(projects, other.projects)
					&& Objects.equals(user, other.user);
		}
		
		

}
