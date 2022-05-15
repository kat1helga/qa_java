import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineGetFoodTestWrongArgumentLogicTest {
    private final String animalType;

    public FelineGetFoodTestWrongArgumentLogicTest(String animalType) {
        this.animalType = animalType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")// добавили аннотацию
    public static Object[][] getListWrongFoodData() {
        return new Object[][]{
                {"123"},
                {null},
                {""},
                {"  "},
        };
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        Feline feline = new Feline();

        boolean throwsException = false;
        try {
            feline.getFood(animalType);
        } catch (Exception e) {
            throwsException = true;
        }
        Assert.assertTrue(throwsException);
    }

    @Test
    public void getFoodThrowsExceptionWithCorrectMessage() throws Exception {
        Feline feline = new Feline();

        String exceptionMessage = null;
        try {
            feline.getFood(animalType);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Assert.assertEquals("wrong message", expectedExceptionMessage, exceptionMessage);
    }
}
