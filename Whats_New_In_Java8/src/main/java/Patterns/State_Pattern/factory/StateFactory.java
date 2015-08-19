package Patterns.State_Pattern.factory;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.State;
import Patterns.State_Pattern.states.HasQuarterState;
import Patterns.State_Pattern.states.NoQuarterState;
import Patterns.State_Pattern.states.SoldOutState;
import Patterns.State_Pattern.states.SoldState;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class StateFactory {

    private static SoldState soldState;
    private static SoldOutState soldOutState;
    private static HasQuarterState hasQuarterState;
    private static NoQuarterState noQuarterState;

    public static State CreateState(GumBallMachine machine, FactoryStatesEnum state){
        switch (state) {
            case SOLD:
                return (soldState!=null) ? soldState : new SoldState(machine);
            case SOLD_OUT:
                return (soldOutState!=null) ? soldOutState : new SoldOutState(machine);
            case HAS_QUARTER:
                return (hasQuarterState != null) ? hasQuarterState : new HasQuarterState(machine);
            case NO_QUARTER:
                return (noQuarterState != null) ? noQuarterState : new NoQuarterState(machine);
            default:
                return null;
        }
    }
}
