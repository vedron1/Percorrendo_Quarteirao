import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<Object> parseInput(String input) {
        List<Object> neighborhood = new ArrayList<>();
        int index = 0;

        while (index < input.length()) {
            char current = input.charAt(index);

            if (Character.isDigit(current)) {
                int num = 0;
                while (index < input.length() && Character.isDigit(input.charAt(index))) {
                    num = num * 10 + Character.getNumericValue(input.charAt(index));
                    index++;
                }
                neighborhood.add(num);
            } else if (current == '(') {
                List<Object> subtree = new ArrayList<>();
                index++;
                while (current != ')') {
                    subtree.add(parseInput(input.substring(index)));
                    current = input.charAt(index);
                    index++;
                }
                neighborhood.add(subtree);
            } else if (current == ' ' || current == ')') {
                index++;
            }
        }

        return neighborhood;
    }
}
