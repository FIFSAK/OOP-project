package researcher;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;

public class ResearchProject implements Serializable {

	public String topic;
	public Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
	public Vector<ResearcherDecorator> getParticipantsofProject(ResearchProject project) {
	    return Data.getInstance().getResearcherDatabase().stream()
	               .filter(researcher -> researcher.projects.contains(project))
	               .collect(Collectors.toCollection(Vector::new));// сейм как в пейпере
	}
    
	
    public ResearchProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants) {
    	this.topic = topic;
    	this.publishedPapers = publishedPapers;
    }
    {
		if(Data.getInstance().getResearchProject().contains(this)) {
			System.out.println("this paper already exist");
		}
		else {
			Data.getInstance().addResearchProject(this);
		}
			
		 //добавляет каждый новый пейпер в бд
	}
    
    public String toString() {
    	return "Topic: " + topic + "publishedPapers: " + publishedPapers + "participant" + getParticipantsofProject(this);
    }
    
    public Vector<ResearchPaper> getPapers() {
    	return publishedPapers;
    }
    
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
