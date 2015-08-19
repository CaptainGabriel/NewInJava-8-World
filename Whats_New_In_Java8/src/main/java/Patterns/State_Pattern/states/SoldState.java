package Patterns.State_Pattern.states;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.State;
import Patterns.State_Pattern.factory.FactoryStatesEnum;
import Patterns.State_Pattern.factory.StateFactory;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class SoldState implements State {
    private GumBallMachine machine;

    public SoldState(GumBallMachine mach){
        machine = mach;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have already done that ... nothing happens");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Its been sold, theres no turning back ... nothing happens");
    }

    @Override
    public void turnCrank() {
        System.out.println("You have already done that ... nothing happens");
    }

    @Override
    public void dispense() {
        System.out.println("Gum goes out !");
        machine.setState(StateFactory.CreateState(machine, FactoryStatesEnum.NO_QUARTER));
    }
}
