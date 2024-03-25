package chap11.sect03;
import org.junit.Test;
import org.junit.experimental.categories.Category;
public class MyCategoryTest {
    @Test
    public void a() {
      System.out.println("normal");
    }
    @Category(chap11.sect03.ISlow.class)
    @Test
    public void b() {
      System.out.println("slow ");
    }
    @Category({ chap11.sect03.IFast.class, chap11.sect03.ISmoke.class })
    @Test
    public void c() {
      System.out.println("fast + smoke");
    }
}
interface ISlow {}
interface IFast {}
interface ISmoke {}