import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneService {

    public void getPhoneNumbersFromFile(File file, String regex) throws IOException {
        Pattern firstPattern = Pattern.compile(regex);
        FileInputStream inputStream = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();

        int i;
        while ((i = inputStream.read()) != -1) {
            builder.append((char) i);
        }
        String[] linesFromFile = builder.toString().trim().split("\n");
        for (String line : linesFromFile) {
            Matcher matcher = firstPattern.matcher(line);
            if (matcher.find()) {
                System.out.println(line);
            }
        }
    }

}
