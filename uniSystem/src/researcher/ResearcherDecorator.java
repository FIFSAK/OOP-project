package researcher;

import java.io.Serializable;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Vector;

import javax.security.auth.login.LoginException;

import data.Data;
import enums.Format;
import users.Student;
import users.Teacher;
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
	    private ResourceBundle messages;

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
	    	if(user instanceof Teacher) {
	    		return (Teacher) user;
	    	}
	    	
	    	return user;
	    } // доступ к предыдущим функциям до того как стал ресерчером

	    private void printMessage(String key, Object... args) {
	        String message = messages.getString(key);
	        System.out.println(args.length > 0 ? String.format(message, args) : message);
	    }
		@Override
		public void joinProject(String topic) {
		    Optional<ResearchProject> matchingProject = Data.getInstance().getResearchProject().stream()
		                                                     .filter(n -> n.topic.equals(topic))
		                                                     .findFirst();

		    if (matchingProject.isPresent()) {
		        // Add the found project to the projects vector
		        projects.add(matchingProject.get());
	            printMessage("joinProjectSuccess", matchingProject.get().topic);

		    } else {
	            printMessage("joinProjectNotExist");
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
		    	printMessage("joinProjectNotExist");		    }
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
		    	printMessage("lowHIndexError");		    }
			}
		 // если каждая статья цитировалась минимум сколько то раз этот минимум и будет hindex
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
			if(!Data.getInstance().getResearchProject().stream().anyMatch(n -> n.topic.equals(topic))) {
				ResearchProject rp = new ResearchProject(topic, publishedPapers, participants);
				projects.add(rp);
				Data.getInstance().addResearchProject(rp);
	            printMessage("successMessage");
			}
			else {
	            printMessage("projectAlreadyExistError");

			}
		}

		@Override
		public void newPaper(ResearchPaper rp) {
			if(! Data.getInstance().getResearchPaper().stream().anyMatch(n -> n.equals(rp))) {
				papers.add(rp);
	            printMessage("successMessage");
				Data.getInstance().addResearchPaper(rp);
			}
			else {
	            printMessage("paperAlreadyExistError");

			}
		}

		@Override
		public void newProject(ResearchProject rp) {
			if(! Data.getInstance().getResearchProject().stream().anyMatch(n -> n.equals(rp))) {
				projects.add(rp);
				Data.getInstance().addResearchProject(rp);
	            printMessage("successMessage");
			}
			else {
	            printMessage("projectAlreadyExistError");
			}		
		}

		@Override
	    public void newPaper(String name, int pages, String journal, String text) {
			if(! Data.getInstance().getResearchPaper().stream().anyMatch(n -> n.name.equals(name))) {
				ResearchPaper rp = new ResearchPaper(name, pages, journal, text);
				papers.add(rp);
				Data.getInstance().addResearchPaper(rp);
	            printMessage("successMessage");
			}
			else {
	            printMessage("paperAlreadyExistError");

			}	};

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
