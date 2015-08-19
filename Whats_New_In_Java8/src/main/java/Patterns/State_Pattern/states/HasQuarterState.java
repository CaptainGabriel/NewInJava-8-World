package Patterns.State_Pattern.states;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.State;
import Patterns.State_Pattern.factory.FactoryStatesEnum;
import Patterns.State_Pattern.factory.StateFactory;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class HasQuarterState implements State {

    private GumBallMachine machine;

    public HasQuarterState(GumBallMachine mach){
        machine = mach;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Machine already has a quarter ... nothing happens");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Take your quarter back !");
        machine.setState(StateFactory.CreateState(machine, FactoryStatesEnum.NO_QUARTER));
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned, gum sold !");
        machine.setState(StateFactory.CreateState(machine, FactoryStatesEnum.SOLD));
    }

    @Override
    public void dispense() {
        System.out.println("You need to turn the crank around first ... nothing happens");
    }
}