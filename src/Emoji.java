import java.util.Comparator;

public class Emoji {
    public String emoji;
    public String name;
    public String group;
    public String sub_group;
    public String codepoints;

    public Emoji(String emoji, String name, String group, String sub_group, String codepoints) {
        this.emoji = emoji;
        this.name = name;
        this.group = group;
        this.sub_group = sub_group;
        this.codepoints = codepoints;
    }
    public Emoji() {}
    
    public static Comparator<Emoji> emojGrp = new Comparator<Emoji>() {

        @Override
        public int compare(Emoji o1, Emoji o2) {
            return o1.group.compareTo(o2.group);
        }
    };
}
