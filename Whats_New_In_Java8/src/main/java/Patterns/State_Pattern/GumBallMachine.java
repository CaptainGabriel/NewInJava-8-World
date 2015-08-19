package Patterns.State_Pattern;

import Patterns.State_Pattern.states.NoQuarterState;

/**
 * Created by Pedro Gabriel on 29/05/2015.
 */
public class GumBallMachine {

    private State state;

    public GumBallMachine(){
        state = new NoQuarterState(this);
    }

    //delegate action to the state instance
    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
    }

    public void dispense(){
        state.dispense();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
