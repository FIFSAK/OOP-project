package researcher;

import java.util.Comparator;

import enums.Format;

public class PaperCitationComparator implements Comparator<ResearchPaper>{

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		int cit1 = o1.citations.size();
		int cit2 = o2.citations.size();
		if(cit1>cit2) return 1;
		if(cit1<cit2) return -1;
		return 0;
	}
}
