package Patterns.Decorator_Pattern;

import Patterns.Decorator_Pattern.condimentsDecorate.Milk;
import Patterns.Decorator_Pattern.condimentsDecorate.Whip;
import Patterns.Decorator_Pattern.differentTypes.Cosi;
import Patterns.Decorator_Pattern.differentTypes.Ristretto;
import Patterns.Decorator_Pattern.mainType.Beverage;

public class Main {

  public static void main(String[] args) {
    System.out.println("Coffee Please !  Black no sugar.");
    Beverage simpleCoffee = new Ristretto();
    System.out.println("--- "+simpleCoffee.getDescription()+" - "+simpleCoffee.cost()+" cents. ---");
    System.out.println("Anything else sir ?");
    System.out.println("Some milk and... ");

    //now we start to decorate the coffee
    simpleCoffee = new Milk(simpleCoffee);
    System.out.println("--- "+simpleCoffee.getDescription()+" - "+simpleCoffee.cost()+" cents. ---");
    System.out.println("... whip too please.");
    simpleCoffee = new Whip(simpleCoffee);
    System.out.println("Ok. "+simpleCoffee.getDescription());
    System.out.println("Total cost is "+simpleCoffee.cost());
    System.out.println("Thanks !!");
    
    System.out.println("\n\n");
    
    System.out.println("Cosi Please .");
    Beverage cosi = new Cosi();
    System.out.println("--- "+cosi.getDescription()+" - "+cosi.cost()+" cents. ---");
    System.out.println("Anything else sir ?");
    System.out.println("Nope.");
    System.out.println("Ok. "+cosi.getDescription());
    System.out.println("Total cost is "+cosi.cost());
    System.out.println("Thanks !!");

    /*
      Coffee Please !  Black no sugar.

      --- Ristretto - 0.39 cents. ---

      Anything else sir ?
      Some milk and...

      --- Ristretto, with Milk - 0.44 cents. ---

      ... whip too please.
      Ok. Ristretto, with Milk, whith Whip
      Total cost is 0.64
      Thanks !!


      Cosi Please .

      --- Cosi - 0.39 cents. ---

      Anything else sir ?
      Nope.
      Ok. Cosi
      Total cost is 0.39
      Thanks !!
       */

  }
}
