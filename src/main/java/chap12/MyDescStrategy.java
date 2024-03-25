package chap12;

import java.util.Comparator;

public class MyDescStrategy implements Comparator<IStudent<Number>> {

  public int compare(IStudent<Number> o1, IStudent<Number> o2) {
    return (int) (o2.getId().doubleValue() - o1.getId().doubleValue());
  }
}