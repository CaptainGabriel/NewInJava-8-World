package StatePattern_Test;

import Patterns.State_Pattern.GumBallMachine;
import Patterns.State_Pattern.states.HasQuarterState;
import Patterns.State_Pattern.states.NoQuarterState;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pedro Gabriel on 30/05/2015.
 */
public class TestGumBallMachine {

    @Test
    public void TestSimpleFluxOfMachine(){
        GumBallMachine machine = new GumBallMachine();

        machine.insertQuarter();
        Assert.assertTrue(machine.getState() instanceof HasQuarterState);
    }


    @Test
    public void TestEjectQuarter(){
        GumBallMachine machine = new GumBallMachine();

        machine.insertQuarter();
        machine.ejectQuarter();

        Assert.assertTrue(machine.getState() instanceof NoQuarterState);
    }

}
