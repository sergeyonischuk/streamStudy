import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UserService {

    public List<String> getUsersFromFile(String filepath) throws IOException {
        List<String> usersList = Files.readAllLines(Paths.get(filepath));
        usersList.removeAll(Arrays.asList("", null));
        usersList.remove(usersList.get(0));
        return usersList;
    }

    public void usersToJson(List<String> users, String outputFilePath) {
        String json = new Gson().toJson(users);
        File file = new File(outputFilePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(json);
    }
}