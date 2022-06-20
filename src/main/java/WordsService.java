import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordsService {

    public void getWordsFrequency(String filepath) {
        Map<String, Integer> unsortedMap = new LinkedHashMap<>();
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader(filepath)) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
            String[] arr = builder.toString().split("\\s");
            for (String s : arr) {
                int count = 0;
                for (String value : arr) {
                    if (value.equals(s)) {
                        count++;
                    }
                }
                if (!s.isBlank()) {
                    unsortedMap.put(s, count);
                }
            }
            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
            unsortedMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
            System.out.println(sortedMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
