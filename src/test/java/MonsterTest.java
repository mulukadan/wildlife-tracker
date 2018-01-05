import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class MonsterTest {
  @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void save_savesPersonIdIntoDB_true() {
      Person testPerson = new Person("Henry", "henry@henry.com");
      testPerson.save();
      Monster testMonster = new Monster("Bubbles", testPerson.getId());
      testMonster.save();
      Monster savedMonster = Monster.find(testMonster.getId());
      assertEquals(savedMonster.getPersonId(), testPerson.getId());
    }

    @Test
    public void isAlive_recognizesMonsterIsDeadWhenLevelsReachMinimum_false(){
      Monster testMonster = new Monster("Bubbles", 1);
      for(int i = Monster.MIN_ALL_LEVELS; i <= Monster.MAX_FOOD_LEVEL; i++){
        testMonster.depleteLevels();
      }
      assertEquals(testMonster.isAlive(), false);
    }

    @Test(expected = UnsupportedOperationException.class)
  public void feed_throwsExceptionIfFoodLevelIsAtMaxValue(){
    Monster testMonster = new Monster("Bubbles", 1);
    for(int i = Monster.MIN_ALL_LEVELS; i <= (Monster.MAX_FOOD_LEVEL); i++){
      testMonster.feed();
    }
  }

  @Test
  public void monster_foodLevelCannotGoBeyondMaxValue(){
    Monster testMonster = new Monster("Bubbles", 1);
    for(int i = Monster.MIN_ALL_LEVELS; i <= (Monster.MAX_FOOD_LEVEL); i++){
      try {
        testMonster.feed();
      } catch (UnsupportedOperationException exception){ }
    }
    assertTrue(testMonster.getFoodLevel() <= Monster.MAX_FOOD_LEVEL);
  }

  @Test
  public void monster_sleepLevelCannotGoBeyondMaxValue(){
    Monster testMonster = new Monster("Bubbles", 1);
    for(int i = Monster.MIN_ALL_LEVELS; i <= (Monster.MAX_SLEEP_LEVEL); i++){
      try {
        testMonster.sleep();
      } catch (UnsupportedOperationException exception){ }
    }
    assertTrue(testMonster.getSleepLevel() <= Monster.MAX_SLEEP_LEVEL);
  }

  @Test
  public void timer_executesDepleteLevelsMethod() {
    Monster testMonster = new Monster("Bubbles", 1);
    int firstPlayLevel = testMonster.getPlayLevel();
    testMonster.startTimer();
    try {
      Thread.sleep(6000);
    } catch (InterruptedException exception){}
    int secondPlayLevel = testMonster.getPlayLevel();
    assertTrue(firstPlayLevel > secondPlayLevel);
  }



}
