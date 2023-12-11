package researcher;

import java.util.Vector;

import enums.Format;

public class ResearchPaper implements Comparable<ResearchPaper> {
	public String name;
	public Vector<ResearchPaper> citations;
	public  Vector<ResearcherDecorator> authors = new Vector<ResearcherDecorator>();
	public int pages;
	public String journal;
	
	public ResearchPaper(String name, 
	Vector<ResearchPaper> citations,
	Vector<ResearcherDecorator> authors, 
	int pages, String journal) {
		this.name = name;
		this.citations = citations;
		this.authors = authors;
		this.pages = pages;
		this.journal = journal;
	}
	
	public Vector<ResearchPaper> getCitation(Format f) {
		return citations;
	}

	@Override
	public int compareTo(ResearchPaper o) {
		if(this.pages>o.pages) return 1;
		if(this.pages<o.pages) return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", citations=" + citations + ", authors=" + authors + ", pages=" + pages
				+ ", journal=" + journal + "]";
	}
	

}
