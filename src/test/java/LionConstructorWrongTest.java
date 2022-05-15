import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionConstructorWrongTest {
    private final String sexType;

    public LionConstructorWrongTest(String sexType) {
        this.sexType = sexType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}") // добавили аннотацию
    public static Object[][] getSexTypeData() {
        return new Object[][]{
                {"самка"},
                {"самец"},
                {"123"},
                {null},
        };
    }

    @Test
    public void constructorLionRightWorks() throws Exception {
        boolean throwsException = false;
        try {
            new Lion(null, sexType);
        } catch (Exception e) {
            throwsException = true;
        }
        Assert.assertTrue(throwsException);
    }
}
