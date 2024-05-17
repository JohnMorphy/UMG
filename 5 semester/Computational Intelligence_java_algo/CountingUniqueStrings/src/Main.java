import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String... args) {

        /*
        // as a script in cmd
        String fileName = args[0];
        int stringLength = Integer.parseInt(args[1]);
        int viewCount = Integer.parseInt(args[2]);

        try {
            String text = getText(fileName);
            HashMap<String, Integer> uniqueStrings1 = countStrings(text, stringLength);
            showNMostCommon(uniqueStrings1, viewCount);
        } catch (IOException e) {
            System.out.println("Problems with reading the file!");
        }
        */

        // showcase
        try {
            String text = getText("Lalka.txt");

            int viewCount = 20;

            HashMap<String, Integer> uniqueStrings1 = countStrings(text, 1);
            showNMostCommon(uniqueStrings1, viewCount);
            System.out.println();

            HashMap<String, Integer> uniqueStrings2 = countStrings(text, 2);
            showNMostCommon(uniqueStrings2, viewCount);
            System.out.println();

            HashMap<String, Integer> uniqueStrings3 = countStrings(text, 3);
            showNMostCommon(uniqueStrings3, viewCount);
            System.out.println();

            HashMap<String, Integer> uniqueStrings4 = countStrings(text, 4);
            showNMostCommon(uniqueStrings4, viewCount);
            System.out.println();

            HashMap<String, Integer> uniqueStrings5 = countStrings(text, 5);
            showNMostCommon(uniqueStrings5, viewCount);
            System.out.println();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getText(String fileName) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        content = content.replace("\r\n", " ");
        return content;

    }

    // Ignores uppercase
    private static HashMap<String, Integer> countStrings(String testedText, int stringLength) {

        HashMap<String, Integer> uniqueStrings = new HashMap<>();

        String key;

        for (int i = 0; i < testedText.length()-stringLength+1; i++) {
            key = testedText.substring(i, i + stringLength).toLowerCase();
            if (!uniqueStrings.containsKey(key)) {
                uniqueStrings.put(key, 1);
            } else {
                uniqueStrings.put(key, uniqueStrings.get(key) + 1);
            }
        }

        return uniqueStrings;
    }

    private static void showNMostCommon(HashMap<String, Integer> values, int n) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(values.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        if(n > list.size()) {
            n = list.size();
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry: list) {
            sum += entry.getValue();
        }

        for (int i = 0; i < n; i++) {
            var element = list.get(i);
            double percentage = (double)element.getValue()/sum;
            System.out.println((i+1) + ".'" + element.getKey() + "' = " + element.getValue() + ", " + String.format("%.4f", percentage));
        }
    }


}
