import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalcSubtract {
    @DataProvider(name = "SubtractDataProvider")
    public Object[][] subtractDataProvider(){
        return new Object[][]{
                {"2-5", -3.0},
                {"5-3", 2.0},
                {"8.9 - 6.7", 2.2}
        };
    }

    @Test(dataProvider = "SubtractDataProvider")
    public void testSubtract(String expression, double result){
        Assert.assertEquals(Calculator.calculateExpression(expression), result);
    }
}
