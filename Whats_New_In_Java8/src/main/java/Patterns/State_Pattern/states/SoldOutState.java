package Patterns.State_Pattern.states;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.State;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class SoldOutState implements State {

    private GumBallMachine machine;

    public SoldOutState(GumBallMachine mach){
        machine = mach;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have inserted a quarter but the machine its sold out !");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("The machine its sold out !");
    }

    @Override
    public void turnCrank() {
        System.out.println("The machine its sold out !");
    }

    @Override
    public void dispense() {
        System.out.println("The machine its sold out !");
    }
}