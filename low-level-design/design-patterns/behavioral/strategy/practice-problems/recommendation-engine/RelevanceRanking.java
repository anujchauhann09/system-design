import java.util.List;

// Ranks by relevance to user — returns as-is (personalized order)
class RelevanceRanking implements RankingStrategy {
    @Override
    public List<String> rank(List<String> items) {
        System.out.println("Ranking by relevance (personalized for user)");
        return items;
    }
}
