import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.survivor1305.model.Position;

public class PositionTest {

    @Test
    public void getx_test(){
        Position position = new Position(2,2);
        Assertions.assertEquals(position.x(), 2);
    }

    @Test
    public void gety_test(){
        Position position = new Position(2,2);
        Assertions.assertEquals(position.y(), 2);
    }

}
