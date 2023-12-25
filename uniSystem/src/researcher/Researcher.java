package researcher;

import java.util.Vector;

/**
 * The Researcher interface represents a researcher who can manage research projects and papers.
 * It allows for adding new projects, printing information about published papers, 
 * calculating H-Index, and managing new papers.
 */
public interface Researcher {
    
    /**
     * Adds a new research project.
     * 
     * @param researchProject The ResearchProject object to be added.
     */
    public void joinProject(String topic);

    /**
     * Prints the details of published papers.
     * Sorts the papers based on the specified sort type.
     * 
     * @param sortType The type of sorting to be applied ("by citations" or default sorting). 
     *                 If an empty string is passed, default sorting is applied.
     * @return A string representation of the sorted papers.
     */
    public String printPapers(String sortType);

    /**
     * Calculates and updates the H-Index of the researcher.
     * 
     * @throws LowHIndex If the calculated H-Index is below a certain threshold.
     */
    public void calculateHIndex() throws LowHIndex;
    
    /**
     * Creates a new research project with specified details.
     * 
     * @param topic The topic of the new research project.
     * @param publishedPapers A vector of published papers related to the project.
     * @param participants A vector of researchers participating in the project.
     * @return 
     */
    public void newProject(String topic, Vector<ResearchPaper> publishedPapers, Vector<ResearcherDecorator> participants);
        
    /**
     * Adds a new research project.
     * 
     * @param rp The ResearchProject object to be added.
     */
    public void newProject(ResearchProject rp);
    
    /**
     * Adds a new research paper.
     * 
     * @param rp The ResearchPaper object to be added.
     */
    public void newPaper(ResearchPaper rp);

    /**
     * Creates and adds a new research paper with specified details.
     * 
     * @param name The name of the new paper.
     * @param pages The number of pages in the paper.
     * @param journal The journal in which the paper is published.
     */
    public void newPaper(String name, int pages, String journal);
    
    public void joinPaper(String name);
}
