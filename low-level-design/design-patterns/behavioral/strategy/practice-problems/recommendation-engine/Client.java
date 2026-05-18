import java.util.Arrays;
import java.util.List;

class Client {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Laptop", "Phone", "Tablet", "Watch");

        RecommendationEngine popularity = new RecommendationEngine(new PopularityRanking());
        RecommendationEngine rating = new RecommendationEngine(new RatingRanking());
        RecommendationEngine relevance = new RecommendationEngine(new RelevanceRanking());

        System.out.println(popularity.getRecommendations(items));
        System.out.println(rating.getRecommendations(items));
        System.out.println(relevance.getRecommendations(items));
    }
}
