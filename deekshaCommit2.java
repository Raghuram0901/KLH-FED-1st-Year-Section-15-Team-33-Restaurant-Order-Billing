import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Commit2 {

    private ArrayList<String> menuItems = new ArrayList<>();

    // Reads menu items from menu.txt
    public void loadMenu() throws IOException {

        try (BufferedReader br =
                 new BufferedReader(new FileReader("menu.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                menuItems.add(line);
            }
        }
    }
}