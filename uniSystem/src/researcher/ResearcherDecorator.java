package researcher;

import java.io.Serializable;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

import javax.security.auth.login.LoginException;

import enums.Format;
import users.Student;
import users.User;
import users.Employee;
/**
 * The ResearcherDecorator class is a decorator for the User class, providing additional functionalities 
 * related to managing research projects and papers. It implements the Researcher interface and is Serializable.
 */

public class ResearcherDecorator implements Researcher, Serializable {	   
	    private User user;
	    
	    public Vector<ResearchProject> projects = new Vector<ResearchProject>();
	    
	    public Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
	    
	    public double hindex;
	    /**
	     * Default constructor for creating an instance of ResearcherDecorator without a user.
	     */
	    public ResearcherDecorator () {}
	    /**
	     * Constructs a ResearcherDecorator with a specified user.
	     * 
	     * @param u The User object that is being decorated.
	     */
	    public ResearcherDecorator (User u) {
	    	user = u;
	    }
	    
	    /**
	     * Provides access to the underlying User object.
	     * 
	     * @return The wrapped User object, either Student or Employee.
	     */

	    public User getWrapped(){
	    	if(user instanceof Student) {	    		
	    		return (Student) user;
	    	}
	    	if(user instanceof Employee) {	    		
	    		return (Employee) user;
	    	}
	    	
	    	return user;
	    } // доступ к предыдущим функциям до того как стал ресерчером

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
					if (paper.citations.size() < minimalCitations) {
						minimalCitations = paper.citations.size();
					}
				}
			hindex = minimalCitations;
			if(hindex < 3) {
				System.out.println(new LowHIndex("your hindex lesser than 3"));
			}
		} // если каждая статья цитировалась минимум сколько то раз этот минимум и будет hindex
		/**
	     * Returns a string representation of the ResearcherDecorator, including user details, projects, and H-index.
	     * 
	     * @return A string describing the ResearcherDecorator.
	     */
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
