package chap05.sect01;
public interface IOutput {
  public String getAll();
}
class StrOutput implements IOutput{
  String str;
  public StrOutput(String str) {
    this.str = str;
  }
  public String getAll() {
    return str;
  }
}
class ArrayOutput implements IOutput{
  String[] arr;
  public ArrayOutput(String[] arr) {
    this.arr =arr; 
  }
  public String getAll() {
    return java.util.Arrays.toString(arr).replace("[", "").replace("]", "");
  }
}