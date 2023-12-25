package researcher;

import java.util.Comparator;

public class TextComparator implements Comparator<ResearchPaper>{
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

		if(o1.text.length()>o2.text.length()) return 1;
		if(o1.text.length()<o2.text.length()) return -1;
		return 0;
	}
}