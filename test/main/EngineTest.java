package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    @Test
    void checkIncome() {
        Engine engine = new Engine();
        engine.loadMembersFromFile();
        int total = engine.checkIncome();
        int expected = 10600;

                assertEquals(expected,total);
    }
}