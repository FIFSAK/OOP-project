package researcher;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;
import enums.Format;

public class ResearchPaper implements Comparable<ResearchPaper>, Serializable {
	public String name;
	public Vector<ResearchPaper> citations = new Vector<ResearchPaper>(); // какие статьи процитировали this
	public Vector<ResearcherDecorator> getAuthorsOfPaper(ResearchPaper paper) {
	    return Data.getInstance().getResearcherDatabase().stream()
	               .filter(researcher -> researcher.papers.contains(paper))
	               .collect(Collectors.toCollection(Vector::new));
	}//проверяет все у всех ресерчеров есть ли данный пейпер
	
	
	public int pages;
	public String journal;
	
	public ResearchPaper(String name,
	int pages, String journal) {
		this.name = name;
		this.pages = pages;
		this.journal = journal;
		
	}
	{
		if(Data.getInstance().getResearchPaper().contains(this)) {
			System.out.println("this paper already exist");
		}
		else {
			Data.getInstance().addResearchPaper(this);
		}
			
		 //добавляет каждый новый пейпер в бд
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
		
	}// работает так что передаешь статью которую хочешь цитировать после к 
//	статье которую хочешь цитировать добавляется то что ты ее процетировал
	
	

}
