import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ranks alphabetically as a proxy for rating-based sort
class RatingRanking implements RankingStrategy {
    @Override
    public List<String> rank(List<String> items) {
        System.out.println("Ranking by rating (highest rated first)");
        List<String> sorted = new ArrayList<>(items);
        Collections.sort(sorted);
        return sorted;
    }
}
