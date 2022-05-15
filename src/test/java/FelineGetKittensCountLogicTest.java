import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineGetKittensCountLogicTest {
    private final int kittensTestCount;

    public FelineGetKittensCountLogicTest(int kittensTestCount) {
        this.kittensTestCount = kittensTestCount;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}") // добавили аннотацию
    public static Object[][] getKittensCountData() {
        return new Object[][]{
                {-1},
                {0},
                {1},
                {1000000},
        };
    }

    @Test
    public void getKittensReturnCount() {
        Feline feline = new Feline();
        int result = feline.getKittens(kittensTestCount);
        int expectedResult = kittensTestCount;
        Assert.assertEquals("Значения не равны", expectedResult, result);
    }
}
