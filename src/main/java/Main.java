import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static final String PHONE_NUMBERS_FILE_PATH = "file.txt";
    public static final String JSON_FILE_INPUT_PATH = "file1.txt";
    public static final String JSON_FILE_OUTPUT_PATH = "user.json";
    public static final String WORDS_TASK_FILE_PATH = "words.txt";
    public static final String PHONE_NUMBERS_REGEX = "(\\(\\d{3}\\)\\s\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})";

    public static void main(String[] args) throws IOException {
        // first task
        File file = new File(PHONE_NUMBERS_FILE_PATH);
        PhoneService service = new PhoneService();
        service.getPhoneNumbersFromFile(file, PHONE_NUMBERS_REGEX);
        // second task
        UserService userService = new UserService();
        List<String> users = userService.getUsersFromFile(JSON_FILE_INPUT_PATH);
        userService.usersToJson(users, JSON_FILE_OUTPUT_PATH);
        // third task
        WordsService wordsService = new WordsService();
        wordsService.getWordsFrequency(WORDS_TASK_FILE_PATH);

    }
}
