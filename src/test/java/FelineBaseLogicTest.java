import com.example.Feline;
import org.junit.*;
import java.util.List;

public class FelineBaseLogicTest {
    @Test
    public void eatMeatReturnRightList() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("списки не равны", expectedResult, result);
    }

    @Test
    public void getFamilyReturnValue() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        String expectedResult = "Кошачьи";
        Assert.assertEquals("Значение не равно Кошачьи", expectedResult, result);
    }

    @Test
    public void getKittensReturnOne() {
        Feline feline = new Feline();
        int result = feline.getKittens();
        int expectedResult = 1;
        Assert.assertEquals("Значение не равно 1", expectedResult, result);
    }
}
