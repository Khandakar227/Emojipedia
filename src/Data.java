import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import com.opencsv.CSVReader;

public class Data {
    CSVReader reader;
    static LinkedHashMap<String, ArrayList<Emoji>> emojiMap = new LinkedHashMap<>();
    static LinkedHashSet<String> groups = new LinkedHashSet<>();
    static public String selectedGroup = "All";

    Data() {
        try {
            InputStream in = getClass().getResourceAsStream("emoji_df.csv");
            BufferedReader csvData = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            
            reader = new CSVReader(csvData);

            String[] nextLineStrings;
            int i = 0;
            while ((nextLineStrings = reader.readNext()) != null) {

                if (i++ == 0)
                    continue;
                    
                    Emoji emoji = new Emoji();

                emoji.emoji = nextLineStrings[0];
                emoji.name = nextLineStrings[1];
                emoji.group = nextLineStrings[2];
                emoji.sub_group = nextLineStrings[3];
                emoji.codepoints = nextLineStrings[4];

                ArrayList<Emoji> emojis = emojiMap.get(emoji.group);

                if (emojis == null) {
                    emojis = new ArrayList<>();
                    emojiMap.put(emoji.group, emojis);
                }
                emojis.add(emoji);
                groups.add(emoji.group);
                IconsPanel.emojis.add(emoji);
            }

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("[Error]: " + e.getMessage());
        }
    }

    public static void setSelectedGroup(String groupName) {

        if (groupName.compareTo(selectedGroup) == 0)
            return;

        if (groupName.compareTo("All") == 0) {
            selectedGroup = groupName;
            IconsPanel.emojis = new ArrayList<>();
            for (ArrayList<Emoji> emojis : emojiMap.values()) {
                IconsPanel.emojis.addAll(emojis);
            }
            return;
        }

        selectedGroup = groupName;
        // System.out.println(selectedGroup);
        IconsPanel.emojis = emojiMap.get(groupName);
    }
}
