//package SnakeGame.serial.tests;
//
//import SnakeGame.models.Level;
//import SnakeGame.serial.StockLevels;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class StockLevelsTest {
//    @Test
//    void extractLevels() {
//        List<Level> levels = StockLevels.extractLevels();
//        String[] names = new String[]{
//                "Level1", "Level2", "Level3", "hello"};
//        for (int number = 0; number < names.length; number++) {
//            assertEquals(names[number], levels.get(number).name);
//            assertEquals(20, levels.get(number).map.length);
//        }
//    }
//
//    @Test
//    void addAndRemoveLevel() {
//        StockLevels.addLevel("TestLevel", new boolean[][]{
//                new boolean[]{true, true},
//                new boolean[]{false, true}});
//        List<Level> levels = StockLevels.extractLevels();
//        try {
//            assertEquals("TestLevel", levels.get(4).name);
//            assertTrue(Arrays.equals(
//                    new String[]{"10", "11"}, levels.get(4).map));
//        } finally {
//            StockLevels.removeLevel("TestLevel");
//        }
//        extractLevels();
//    }
//}