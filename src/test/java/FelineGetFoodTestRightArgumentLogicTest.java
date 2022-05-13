import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineGetFoodTestRightArgumentLogicTest {

    private final String animalType;
    private final List<String> expectedList;

    public FelineGetFoodTestRightArgumentLogicTest(String animalType, List<String> expectedList) {
        this.animalType = animalType;
        this.expectedList = expectedList;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getListFoodData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodReturnRightList() throws Exception {
        Feline feline = new Feline();
        List<String> actualList = feline.getFood(animalType);
        Assert.assertEquals("списки не равны", expectedList, actualList);
    }
}
