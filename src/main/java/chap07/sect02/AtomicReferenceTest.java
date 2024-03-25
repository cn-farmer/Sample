package chap07.sect02;
import java.util.concurrent.atomic.*;
public class AtomicReferenceTest {
  public static void main(String[] args) {
    User user1 = new User( "name_1");
    User user2 = new User( "name_2");
    var objectRef = new AtomicReference( user1);
    var field=AtomicReferenceFieldUpdater.newUpdater(User.class,String.class,"name");
    field.compareAndSet(user1, "name_1", "cas_name");
    objectRef.compareAndSet(user1, user2);
    System.out.println( user1 + " ; " + objectRef.get());
    int i = 1;
    var stamp = new AtomicStampedReference<>(user1, i);
    stamp.compareAndSet(user1, user2, i++, i);
    System.out.println( user1+"; "+stamp.getReference()+"; stamp="+stamp.getStamp());
} }
class User{
  public volatile String name = "";
  public User(String name) { this.name = name; }
  public String toString() { return "User=" + name; }
}