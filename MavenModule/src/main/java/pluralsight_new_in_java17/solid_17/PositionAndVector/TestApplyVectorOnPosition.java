package pluralsight_new_in_java17.solid_17.PositionAndVector;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Not super linked to any solid principle but the tell don't ask principle
 * One shall not ask objects for data but tell them what to do
 *
 * The less clean variant of this example is something like posNew.x=pos.x+vec.x; posNew.y=pos.y+vec.y
 */


public class TestApplyVectorOnPosition {
    Position pos=new Position(1d,1d);
    Vector vec=new Vector(1d,1d);

    @Test
    public void whenApplyingVectorOnPos_thenCorrectNewPos() {
        Position posNew=pos.applyVector(vec);
        assertEquals(new Position(2d,2d),posNew);
    }

    @Test
    public void whenApplyingReversedVectorOnPos_thenCorrectNewPos() {
        Position posNew=pos.applyVector(vec.reversed());
        assertEquals(new Position(0d,0d),posNew);
    }
}
