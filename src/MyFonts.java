import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class MyFonts {
    static public Font NotoEmojiFont;
    static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    MyFonts() {
        try {
            NotoEmojiFont = Font
            .createFont(Font.TRUETYPE_FONT, Main.class.getClassLoader().getResourceAsStream("NotoEmoji-VariableFont_wght.ttf"))
            .deriveFont(40f);
            
            ge.registerFont(NotoEmojiFont);
        } catch (FontFormatException e) {
            System.out.println("[Error]: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[Error]: " + e.getMessage());
            e.printStackTrace();
        }
    }
    static public Font seogeUiFont(float fontSize) throws FontFormatException, IOException {
        Font SeogeUI = Font.createFont(Font.TRUETYPE_FONT, Main.class.getClassLoader().getResourceAsStream("seguiemj.ttf"))
        .deriveFont(fontSize);
        ge.registerFont(SeogeUI);

        return SeogeUI;
    }
    static public Font RobotoFont(float fontSize) throws FontFormatException, IOException {
        Font Roboto = Font
        .createFont(Font.TRUETYPE_FONT, Main.class.getClassLoader().getResourceAsStream("Roboto-Regular.ttf"))
        .deriveFont(fontSize);
        ge.registerFont(Roboto);

        return Roboto;
    };
    static public Font RobotoFont(int style, float fontSize) throws FontFormatException, IOException {
        Font Roboto = Font
        .createFont(Font.TRUETYPE_FONT, Main.class.getClassLoader().getResourceAsStream("Roboto-Regular.ttf"))
        .deriveFont(style, fontSize);
        ge.registerFont(Roboto);

        return Roboto;
    };
    static public Font NotoFont(int style, float fontSize) throws FontFormatException, IOException {
        Font NotoFont = Font
            .createFont(Font.TRUETYPE_FONT, Main.class.getClassLoader().getResourceAsStream("NotoEmoji-VariableFont_wght.ttf"))
            .deriveFont(style, fontSize);
        ge.registerFont(NotoEmojiFont);
        
        return NotoFont;
    }
}
