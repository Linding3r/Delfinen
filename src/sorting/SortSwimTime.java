package sorting;

import entities.Member;

import java.util.Comparator;

public class SortSwimTime implements Comparator<Member>{

  @Override
  public int compare(Member o1, Member o2) {
    return o1.getFastestSwimmingTime().getTime().getTime().compareTo(o2.getFastestSwimmingTime().getTime().getTime());
  }
}

