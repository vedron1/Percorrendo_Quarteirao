// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) throws FileNotFoundException {
//         Scanner sc = new Scanner(new File("casosTeste.txt"));
//         for (int i = 0; i < 5; i++) {
//             String input = sc.nextLine();
//             Neighborhood neighborhood = new Neighborhood(input);
//             System.out.println(neighborhood.getMinimumStreets() + " " + neighborhood.getTotalCandies());
//         }
//         sc.close();
//     }
// }
import java.util.*;

public class Main {
    static class House {
        int id;
        int candy;

        public House(int id, int candy) {
            this.id = id;
            this.candy = candy;
        }
    }

    static class TreeNode {
        int id;
        TreeNode left;
        TreeNode right;

        public TreeNode(int id) {
            this.id = id;
        }
    }

    static int[] dfs(TreeNode node, House[] houses, int[] visited) {
        if (node == null) {
            return new int[]{0, 0};
        }

        visited[node.id] = 1;
        int[] left = dfs(node.left, houses, visited);
        int[] right = dfs(node.right, houses, visited);

        int streets = left[0] + right[0];
        int candies = left[1] + right[1] + houses[node.id].candy;

        return new int[]{streets + visited[node.id], candies};
    }

    static int[] dp(TreeNode node, House[] houses, int[] visited, int[][] memo) {
        if (node == null) {
            return new int[]{0, 0};
        }

        if (memo[node.id][visited[node.id]] != -1) {
            return memo[node.id][visited[node.id]];
        }

        visited[node.id] = 1;
        int[] left = dp(node.left, houses, visited, memo);
        int[] right = dp(node.right, houses, visited, memo);

        int streets = left[0] + right[0];
        int candies = left[1] + right[1] + houses[node.id].candy;

        int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < houses.length; i++) {
            if (visited[i] == 0) {
                int[] temp = dp(new TreeNode(i), houses, visited.clone(), memo);
                if (temp[0] < result[0]) {
                    result[0] = temp[0];
                    result[1] = temp[1];
                } else if (temp[0] == result[0] && temp[1] > result[1]) {
                    result[1] = temp[1];
                }
            }
        }

        memo[node.id][visited[node.id]] = new int[]{result[0] + streets, result[1] + candies};
        return memo[node.id][visited[node.id]];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        House[] houses = new House[5];
        for (int i = 0; i < 5; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int id = i;
            int candy = Integer.parseInt(parts[parts.length - 1]);
            houses[i] = new House(id, candy);
        }

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        int[] visited = new int[5];
        int[] result = dfs(root, houses, visited);
        System.out.println(result[0] + " " + result[1]);

        int[][] memo = new int[5][32];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(memo[i], -1);
        }

        visited = new int[5];
        result = dp(root, houses, visited, memo);
        System.out.println(result[0] + " " + result[1]);
    }
}