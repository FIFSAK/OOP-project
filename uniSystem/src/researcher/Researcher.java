package researcher;

import java.util.Vector;

public interface Researcher {
	public void addProject(ResearchProject researchProject);
	public String printPapers(String sortType); //если передать пустую строку выведит дефолт или передать "by citations"
	public void calculateHIndex() throws LowHIndex;
	
	public void newProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants);
		
	public void newProject(ResearchProject rp);
	
	public void newPaper(ResearchPaper rp);

	
	public void newPaper(String name, 
			int pages, String journal);
}
