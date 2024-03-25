package chap04.sect05;
import java.nio.charset.Charset; 
class DisplayCharsetAliases {
    public static void main(String[] args) {
        System.out.println("Charset -> Aliases");
        for (Charset cs : Charset.availableCharsets().values()) {
            System.out.println(cs.name() + " -> " + cs.aliases());
        }
    }
}