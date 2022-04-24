package whiteBoxTest;

import Classes.*;


import org.junit.jupiter.api.Test;

import Classes.MyFrame;

public class MyFrameTest {

    @Test
    public void testMyFrameConstructor() {
        String frameName = "GameFrame";
        Game startGame = new Game();
        MyFrame frame = new MyFrame(frameName, startGame);
    }

}