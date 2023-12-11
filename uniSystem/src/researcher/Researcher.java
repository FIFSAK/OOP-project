package researcher;

public interface Researcher {
	public void addProject(ResearchProject researchProject);
	public String printPapers(String sortType);
	public void calculateHIndex();
	
}
