import java.util.List;

class RecommendationEngine {
    RankingStrategy rankingStrategy;

    RecommendationEngine(RankingStrategy rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
    }

    List<String> getRecommendations(List<String> items) {
        return rankingStrategy.rank(items);
    }
}
