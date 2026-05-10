package timus.lr6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task_2023 {
    public static void main(String[] args) {
        String[][] a = {
                {"Alice", "Ariel", "Aurora"},
                {"Phil", "Peter", "Olaf"},
                {"Phoebus", "Ralph", "Robin"}
        };

        String[][] b = {
                {"Bambi", "Belle", "Bolt"},
                {"Mulan", "Mowgli", "Mickey"},
                {"Silver", "Simba", "Stitch"}
        };

        String[][] c = {
                {"Dumbo", "Genie", "Jiminy"},
                {"Kuzko", "Kida", "Kenai"},
                {"Tarzan", "Tiana", "Winnie"}
        };

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Character> letterMap = new HashMap<>();
        fillLetterMap(letterMap, a, 'A');
        fillLetterMap(letterMap, b, 'B');
        fillLetterMap(letterMap, c, 'C');

        String[] letters = new String[n];
        for (int i = 0; i < n; i++) {
            letters[i] = scanner.nextLine();
        }

        char currentCabinet = 'A';
        int steps = 0;

        for (String letter : letters) {
            char targetCabinet = letterMap.get(letter);
            steps += Math.abs(targetCabinet - currentCabinet);
            currentCabinet = targetCabinet;
        }

        System.out.println(steps);
    }

    private static void fillLetterMap(Map<String, Character> map, String[][] cabinet, char cabinetName) {
        for (int i = 0; i < cabinet.length; i++) {
            for (int j = 0; j < cabinet[i].length; j++) {
                map.put(cabinet[i][j], cabinetName);
            }
        }
    }
}