package researcher;

import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;
import enums.Format;

public class ResearchPaper implements Comparable<ResearchPaper> {
	public String name;
	public Vector<ResearchPaper> citations = new Vector<ResearchPaper>();
	public Vector<ResearcherDecorator> getAuthorsOfPaper(ResearchPaper paper) {
	    return Data.getInstance().getResearcherDatabase().stream()
	               .filter(researcher -> researcher.papers.contains(paper))
	               .collect(Collectors.toCollection(Vector::new));
	}
	public int pages;
	public String journal;
	
	public ResearchPaper(String name,
	int pages, String journal) {
		this.name = name;
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
		return "ResearchPaper [name=" + name + ", citations=" + citations + ", authors=" + getAuthorsOfPaper(this) + ", pages=" + pages
				+ ", journal=" + journal + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(citations, journal, name, pages);
	}

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

	public void cite(ResearchPaper cp) throws PaperCantCiteyourself {
		if(this != cp) {			
			cp.citations.add(this);
			return;
		}
		System.out.println(new PaperCantCiteyourself("PaperCantCiteyourself"));
		
	}
	

}
