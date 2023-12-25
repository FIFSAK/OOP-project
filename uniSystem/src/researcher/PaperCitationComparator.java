package researcher;

import java.util.Comparator;

import enums.Format;
/**
 * A comparator class for comparing two ResearchPaper objects based on their number of citations.
 * This class implements the Comparator interface, providing a comparison method specific to the 
 * citation count of research papers.
 */
public class PaperCitationComparator implements Comparator<ResearchPaper>{
	/**
     * Compares two ResearchPaper objects based on their citation counts.
     * 
     * @param o1 The first ResearchPaper to be compared.
     * @param o2 The second ResearchPaper to be compared.
     * @return A positive integer if the first paper has more citations than the second,
     *         a negative integer if it has fewer, and zero if both have the same number of citations.
     */
	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		int cit1 = o1.citations.size();
		int cit2 = o2.citations.size();
		if(cit1>cit2) return 1;
		if(cit1<cit2) return -1;
		return 0;
	}
}
