import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatLogicTest {
    @Mock
    Feline feline;

    @Test
    public void getFoodReturnsPredatorEatMeatResult() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        List<String> result = cat.getFood();
        Assert.assertEquals("Predator возвращает некорректное значение", List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void getFoodProxyToPredator() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void getFoodProxyExceptionFromPredator() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow();
        Cat cat = new Cat(feline);
        boolean throwsException = false;
        try {
            cat.getFood();
        } catch (Exception e) {
            throwsException = true;
        }
        Assert.assertTrue(throwsException);
    }

    @Test
    public void getSoundReturnsRightSound() {
        Cat cat = new Cat(feline);
        String result = cat.getSound();
        String expectedResult = "Мяу";
        Assert.assertEquals("Значение не равно Мяу", expectedResult, result);
    }
}
