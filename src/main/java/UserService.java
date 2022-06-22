import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    public List<User> getUsersFromFile(String filepath) throws IOException {
        List<String> usersStringList = Files.readAllLines(Paths.get(filepath));
        usersStringList.removeAll(Arrays.asList("", null));
        usersStringList.remove(usersStringList.get(0));
        List<User> users = new ArrayList<>();
        for (int i = 0; i < usersStringList.size(); i++) {
            String[] nameAndAge = usersStringList.get(0).split(" ");
            users.add(new User(nameAndAge[0], Integer.parseInt(nameAndAge[1])));
        }
        return users;
    }

    public void usersToJson(List<User> users, String outputFilePath) {
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