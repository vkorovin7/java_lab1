package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        List<String> strings = List.of("Sega", "Mega", "Drive", "16bit");
        System.out.println("Список до: " + strings);
        List<String> filteredStrings = filterStrings(strings);
        System.out.println("Список после: " + filteredStrings);
    }

    public static List<String> filterStrings(List<String> strings) {
        return strings.stream()
                .filter(str -> str.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
    }
}
