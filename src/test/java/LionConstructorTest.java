import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionConstructorTest {
    private final String sexType;

    public LionConstructorTest(String sexType) {
        this.sexType = sexType;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSexTypeData() {
        return new Object[][]{
                {"Самка"},
                {"Самец"},
        };
    }

    @Test
    public void constructorLionRightWorks() throws Exception {
        new Lion(null, sexType);
    }
}