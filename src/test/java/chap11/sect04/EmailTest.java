package chap11.sect04;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import chap11.EmailValidator;

@RunWith(Parameterized.class)
public class EmailTest {

  @Parameters(name = "Index: {index}: [Input: {0}] -> Excepted: {1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
        new Object[][] { { "zhangsan@gs.cn", true }, { "lisi@.cm", false }, { "wangwu@gs@cn", true } });
  }

  @Parameter(0)
  public String email;
  @Parameter(1)
  public boolean expected;

  @Test
  public void testAllEmail() {
    boolean validEmail = EmailValidator.isEmailPublic(email);
    assertEquals("邮箱地址合法性校验--",validEmail, expected);
  }
}