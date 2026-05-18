import java.util.List;

// Ranks by most viewed/purchased — simulated by reversing order
class PopularityRanking implements RankingStrategy {
    @Override
    public List<String> rank(List<String> items) {
        System.out.println("Ranking by popularity (most viewed first)");
        return items.reversed();
    }
}
