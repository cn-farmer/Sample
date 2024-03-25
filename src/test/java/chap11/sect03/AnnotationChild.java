package chap11.sect03;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AnnotationChild extends AnnotationParent {

  @BeforeClass
  public static void childClassInit() {
    System.err.println("--------- child BeforeClass");
  }

  @After
  public void childMethodInitOne() {
    System.out.println("child method Before one ***");
  }

  @After
  public void childMethodInitTwo() {
    System.out.println("child method Before two ^^^");
  }

  @Test
  public void testDemoOne() {
    System.out.println("test demo one");
    assertTrue(false);
  }

  @Test
  public void testDemoTwo() {
    System.out.println("test demo two");
    throw new RuntimeException();
  }
}

class AnnotationParent {
  @After
  public void parentInit() {
    System.err.println("~~~~~ parent Before ");
  }
}