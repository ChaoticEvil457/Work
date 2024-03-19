package Feb1;

import java.util.*;

public class HouseToDo implements Cloneable, Comparable<HouseToDo> {
  private int id;
  private double area;
  private java.util.Date whenBuilt;

  public HouseToDo(int id, double area) {
    this.id = id;
    this.area = area;
    whenBuilt = new java.util.Date();
  }

  public int getId() {
    return id;
  }

  public double getArea() {
    return area;
  }

  public java.util.Date getWhenBuilt() {
    return whenBuilt;
  }

  @Override /**
             * Override the protected clone method defined in
             * the Object class, and strengthen its accessibility
             */
  public Object clone() {
    try {
      HouseToDo houseClone = (HouseToDo) super.clone();
      houseClone.whenBuilt = (Date) (whenBuilt.clone());
      return houseClone;

    } catch (CloneNotSupportedException ex) {
      return null;
    }
  }

  @Override // Implement the compareTo method defined in Comparable
  public int compareTo(HouseToDo o) {
    if (area > o.area)
      return 1;
    else if (area < o.area)
      return -1;
    else
      return 0;
  }

  public static void main(String[] args) {

    HouseToDo house1 = new HouseToDo(1, 1750.50);
    HouseToDo house2 = (HouseToDo) house1.clone();
    System.out.println("house1.whenBuilt==house2.whenBuilt is " + (house1.whenBuilt == house2.whenBuilt));
  }

}
