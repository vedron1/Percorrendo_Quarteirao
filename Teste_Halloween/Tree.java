import java.util.List;

public class Tree {
    int streets;
    int candies;

    public Tree(int streets, int candies) {
        this.streets = streets;
        this.candies = candies;
    }

    public static Tree processNeighborhood(Object neighborhood) {
        if (neighborhood instanceof Integer) {
            return new Tree(0, (Integer) neighborhood);
        } else {
            List<Object> neighborhoodList = (List<Object>) neighborhood;
            int totalStreets = 0;
            int totalCandies = 0;

            for (Object child : neighborhoodList) {
                Tree childTree = processNeighborhood(child);
                totalStreets += childTree.streets;
                totalCandies += childTree.candies;
            }

            // Ajuste na contagem de ruas
            totalStreets += Math.max(1, neighborhoodList.size());

            return new Tree(totalStreets, totalCandies + Math.max(1, totalStreets)); // Ajuste na contagem de doces
        }
    }
}
