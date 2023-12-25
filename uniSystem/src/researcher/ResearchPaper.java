package researcher;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;
import enums.Format;

/**
 * Represents a research paper, including its metadata like name, pages, journal, and citations.
 * This class also provides functionalities for managing citations and authors of the paper.
 */
public class ResearchPaper implements Comparable<ResearchPaper>, Serializable {
	public String name;
	public Vector<ResearchPaper> citations = new Vector<ResearchPaper>(); // какие статьи процитировали this
	 /**
     * Retrieves the authors of a specified research paper.
     * 
     * @param paper The research paper for which to find the authors.
     * @return A vector of ResearcherDecorator objects representing the authors of the paper.
     */
	public Vector<ResearcherDecorator> getAuthorsOfPaper(ResearchPaper paper) {
	    return Data.getInstance().getResearcherDatabase().stream()
	               .filter(researcher -> researcher.papers.contains(paper))
	               .collect(Collectors.toCollection(Vector::new));
	}//проверяет все у всех ресерчеров есть ли данный пейпер
	
	
	public int pages;
	public String journal;
	 /**
     * Constructs a new ResearchPaper with the given details and adds it to the database if it doesn't already exist.
     * 
     * @param name The name of the research paper.
     * @param pages The number of pages in the research paper.
     * @param journal The journal in which the research paper is published.
     */
	public ResearchPaper(String name,
	int pages, String journal) {
		this.name = name;
		this.pages = pages;
		this.journal = journal;
		
	}
	{
//		if(Data.getInstance().getResearchPaper().stream().anyMatch(n -> n.name.equals(name))) {
//		}
//		else {
//			Data.getInstance().addResearchPaper(this);
//		}
			
		 //добавляет каждый новый пейпер в бд
	}
	/**
     * Returns a string representing the citations of the paper in a specified format.
     * 
     * @param f The format in which to return the citation string.
     * @return A string representation of the paper's citations.
     */
	public String getCitation(Format f) {
		if(f == Format.PLAIN_TEXT) {
			return citations.toString();
		}
		String s = "name=" + "{" + this.name + "}\n" +
				"citations=" + "{" + this.citations.toString() + "}\n" +
				"Authors=" + "{" + this.getAuthorsOfPaper(this) + "}\n" +
				"pages=" + "{" + this.pages + "}\n" +
				"journal=" + "{" + this.journal + "}\n";
		return s;
	}
	 /**
     * Compares this ResearchPaper to another based on the number of pages.
     * 
     * @param o The ResearchPaper to compare with.
     * @return A positive integer if this paper has more pages, 
     *         a negative integer if it has fewer, or zero if they are equal.
     */
	@Override
	public int compareTo(ResearchPaper o) {
		if(this.pages>o.pages) return 1;
		if(this.pages<o.pages) return -1;
		return 0;
	}
	/**
     * Returns a string representation of the ResearchPaper.
     * 
     * @return A string describing the ResearchPaper.
     */
	@Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", citations=" + citations + ", authors=" + getAuthorsOfPaper(this) + ", pages=" + pages
				+ ", journal=" + journal + "]";
	}
	 /**
     * Generates a hash code for the ResearchPaper.
     * 
     * @return The hash code of the ResearchPaper.
     */
	@Override
	public int hashCode() {
		return Objects.hash(citations, journal, name, pages);
	}
	/**
     * Compares this ResearchPaper with another object for equality.
     * 
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchPaper other = (ResearchPaper) obj;
		return Objects.equals(citations, other.citations) && Objects.equals(journal, other.journal)
				&& Objects.equals(name, other.name) && pages == other.pages;
	}
	 /**
     * Adds a citation to this research paper.
     * 
     * @param cp The ResearchPaper that cites this paper.
     * @throws PaperCantCiteyourself If the paper tries to cite itself.
     */
	public void cite(ResearchPaper cp) throws PaperCantCiteYourself {
		if(this != cp) {			
			cp.citations.add(this);
			return;
		}
		System.out.println(new PaperCantCiteYourself("PaperCantCiteyourself"));
		
	}// работает так что передаешь статью которую хочешь цитировать после к 
//	статье которую хочешь цитировать добавляется то что ты ее процетировал
	
	

}
