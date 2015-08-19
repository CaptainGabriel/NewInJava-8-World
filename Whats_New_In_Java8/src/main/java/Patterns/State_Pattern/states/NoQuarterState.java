package Patterns.State_Pattern.states;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.State;
import Patterns.State_Pattern.factory.FactoryStatesEnum;
import Patterns.State_Pattern.factory.StateFactory;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class NoQuarterState implements State {

    private GumBallMachine machine;

    public NoQuarterState(GumBallMachine mach){
        machine = mach;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have inserted a quarter ! Well done lad !");
        machine.setState(StateFactory.CreateState(machine, FactoryStatesEnum.HAS_QUARTER));
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter can be ejected ... nothing happens");
    }

    @Override
    public void turnCrank() {
        System.out.println("You need to insert a quarter first ... nothing happens");
    }

    @Override
    public void dispense() {
        System.out.println("You need to insert a quarter first ... nothing happens");
    }
}