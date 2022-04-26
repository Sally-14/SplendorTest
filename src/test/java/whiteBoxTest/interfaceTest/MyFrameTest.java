package whiteBoxTest.interfaceTest;

import Classes.*;
import Interface.*;

import org.junit.jupiter.api.Test;

public class MyFrameTest {

    @Test
    public void testMyFrameConstructor() {
        String frameName = "GameFrame";
        Game startGame = new Game();
        MyFrame frame = new MyFrame(frameName, startGame);
    }

}