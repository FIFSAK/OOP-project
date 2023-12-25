package researcher;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;

/**
 * Represents a research project, including its topic, published papers, and participants.
 * Provides functionalities to manage and retrieve information about the research project.
 */
public class ResearchProject implements Serializable {

	public String topic;
	public Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
	/**
     * Retrieves the participants of a specified research project.
     * 
     * @param project The research project for which to find the participants.
     * @return A vector of ResearcherDecorator objects representing the participants of the project.
     */
	public Vector<ResearcherDecorator> getParticipantsofProject(ResearchProject project) {
	    return Data.getInstance().getResearcherDatabase().stream()
	               .filter(researcher -> researcher.projects.contains(project))
	               .collect(Collectors.toCollection(Vector::new));// сейм как в пейпере
	}
    
	/**
     * Constructs a new ResearchProject with a specified topic and list of published papers.
     * 
     * @param topic The topic of the research project.
     * @param publishedPapers A vector of ResearchPaper objects associated with the project.
     * @param participants A vector of ResearcherDecorator objects participating in the project.
     */
    public ResearchProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants) {
    	this.topic = topic;
    	this.publishedPapers = publishedPapers;
    }
    {
//		if(Data.getInstance().getResearchProject().stream().anyMatch(n -> n.topic.equals(topic))) {
//		}
//		else {
//			Data.getInstance().addResearchProject(this);
//		}
			
		 //добавляет каждый новый пейпер в бд
	}
    /**
     * Returns a string representation of the ResearchProject.
     * 
     * @return A string describing the ResearchProject.
     */
    public String toString() {
    	return "Topic: " + topic + "publishedPapers: " + publishedPapers + "participant" + getParticipantsofProject(this);
    }
    /**
     * Retrieves the published papers of the research project.
     * 
     * @return A vector of ResearchPaper objects associated with the project.
     */
    public Vector<ResearchPaper> getPapers() {
    	return publishedPapers;
    }
    /**
     * Adds a research paper to the project.
     * 
     * @param rp The ResearchPaper to be added to the project.
     */
    public void addPaper(ResearchPaper rp) {
    	publishedPapers.add(rp);
    }
    


	@Override
	public int hashCode() {
		return Objects.hash(publishedPapers, topic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchProject other = (ResearchProject) obj;
		return Objects.equals(publishedPapers, other.publishedPapers) && Objects.equals(topic, other.topic);
	}
     
    
    
}
