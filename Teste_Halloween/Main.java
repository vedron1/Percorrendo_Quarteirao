import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {
//         try {
//             Scanner scanner = new Scanner(new File("casosTeste.txt"));

//             while (scanner.hasNextLine()) {
//                 // Leitura da entrada
//                 String input = scanner.nextLine().trim();
//                 List<Object> neighborhood = InputParser.parseInput(input);

//                 // Processamento e exibição da saída
//                 Tree result = Tree.processNeighborhood(neighborhood);
//                 System.out.println(result.streets + " " + result.candies);
//             }

//             scanner.close();
//         } catch (FileNotFoundException e) {
//             System.err.println("Arquivo não encontrado: casosTeste.txt");
//             e.printStackTrace();
//         }
//     }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Tree> trees = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("casosTeste.txt"));

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                List<Object> neighborhood = InputParser.parseInput(input);
                Tree result = Tree.processNeighborhood(neighborhood);
                trees.add(result);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: casosTeste.txt");
            e.printStackTrace();
        }

        // Exibir os resultados
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            System.out.println((i + 1) + " " + tree.streets);
        }
    }
}
