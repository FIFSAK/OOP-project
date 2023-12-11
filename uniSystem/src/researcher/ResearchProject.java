package researcher;

import java.util.Vector;

public class ResearchProject {

	public String topic;
	public Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
	public Vector<ResearcherDecorator> participants = new Vector<ResearcherDecorator>();;
    
    
	
    public ResearchProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants) {
    	this.topic = topic;
    	this.publishedPapers = publishedPapers;
    	this.participants = participants;
    }
    
    public String toString() {
    	return "Topic: " + topic + "publishedPapers: " + publishedPapers + "participant"  + participants.toString();
    }
    
    public Vector<ResearchPaper> getPapers() {
    	return publishedPapers;
    }
    
    public void addPaper(ResearchPaper rp) {
    	publishedPapers.add(rp);
    }
    
    public void addParticipant(ResearcherDecorator rd) throws NoResearcherException {
    	if(rd.getClass().getSimpleName() == "ResearcherDecorator") {
    		participants.add(rd);
    		return;
    	}
    	throw new NoResearcherException("No Researcher");
    	
    }
     
    
    
}
