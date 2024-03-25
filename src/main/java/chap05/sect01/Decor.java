package chap05.sect01;
public class Decor implements IOutput{
  IOutput out;
  public Decor(IOutput out) { this.out = out; }
  public String getAll() {
    return out.getAll();
  }
}
class UpperDecor extends Decor{
  public UpperDecor(IOutput out) { super(out); }
  public String getAll() {
    return super.getAll().toUpperCase();
  }
}
class LineDecor extends Decor{
  public LineDecor(IOutput out) { super(out); }
  public String getAll() {
    return super.getAll().replace(" ","\n");
  }
}
class ReverseDecor extends Decor{
  public ReverseDecor(IOutput out) { super(out); }
  public String getAll() {
    return new StringBuffer(out.getAll()).reverse().toString();
  }
}