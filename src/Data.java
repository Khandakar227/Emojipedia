import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import com.opencsv.CSVReader;

public class Data {
    CSVReader reader;
    static LinkedHashMap<String, ArrayList<Emoji>> emojiMap = new LinkedHashMap<>();
    static LinkedHashSet<String> groups = new LinkedHashSet<>();
    static public String selectedGroup = "All";

    Data() {
        try {
            FileReader csvData = new FileReader("resources\\emoji_df.csv", StandardCharsets.UTF_8);
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
            System.out.println("[Error]: " + e.getMessage());
        }
    }

    // private static void startThread(CSVReader reader) {
    // SwingWorker<String, Emoji> sw = new SwingWorker<>() {

    // @Override
    // protected String doInBackground() throws Exception {
    // String[] nextLineStrings;
    // int i = 0;
    // while ((nextLineStrings = reader.readNext()) != null) {

    // if (i++ == 0)
    // continue;

    // Emoji emoji = new Emoji();

    // emoji.emoji = nextLineStrings[0];
    // emoji.name = nextLineStrings[1];
    // emoji.group = nextLineStrings[2];
    // emoji.sub_group = nextLineStrings[3];
    // emoji.codepoints = nextLineStrings[4];

    // ArrayList<Emoji> emojis = emojiMap.get(emoji.group);

    // if (emojis == null) {
    // emojis = new ArrayList<>();
    // emojiMap.put(emoji.group, emojis);
    // }
    // emojis.add(emoji);

    // groups.add(emoji.group);
    // IconsPanel.emojis.add(emoji);
    // }
    // return "Complete";
    // }
    // };
    // sw.execute();
    // }

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
        System.out.println(selectedGroup);
        IconsPanel.emojis = emojiMap.get(groupName);
    }
}
