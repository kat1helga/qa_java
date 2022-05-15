import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.example.Feline;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionBaseLogicTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsOnce() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensReturnsFelineRightResult() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        int result = lion.getKittens();
        Assert.assertEquals("Возвращает некорректное значение", 1, result);
    }

    @Test
    public void doesHaveManeReturnsTrueIfSexMale() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean result = lion.doesHaveMane();
        Assert.assertTrue("Возвращает некорректное значение", result);
    }

    @Test
    public void doesHaveManeReturnsFalseIfSexFemale() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean result = lion.doesHaveMane();
        Assert.assertFalse("Возвращает некорректное значение", result);
    }

    @Test
    public void getFoodLionReturnsOnce() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFoodLionReturnsWrightList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(feline, "Самец");
        List<String> actualList = lion.getFood();
        Assert.assertEquals("списки не равны", List.of("Животные", "Птицы", "Рыба"), actualList);
    }

    @Test
    public void getFoodProxyExceptionFromFeline() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenThrow();
        Lion lion = new Lion(feline, "Самец");
        boolean throwsException = false;
        try {
            lion.getFood();
        } catch (Exception e) {
            throwsException = true;
        }
        Assert.assertTrue(throwsException);
    }
}
