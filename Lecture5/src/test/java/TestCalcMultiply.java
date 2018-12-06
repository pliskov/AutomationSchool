import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalcMultiply {

    @DataProvider(name = "MultiplyDataProvider")
    public Object[][] multiplyDataProvider() {
        return new Object[][]{
                {"1*0", 0.0},
                {"4*5", 20.0},
                {"6.7 * 8.9", 59.63},
                {"-2*3", -6.0}
        };
    }

    @Test(dataProvider = "MultiplyDataProvider", dependsOnMethods = "TestCalcAdd.testAdd")
    public void testMultiply(String expression, double result) {
        Assert.assertEquals(Calculator.calculateExpression(expression), result);
    }
}