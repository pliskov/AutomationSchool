import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalcDivide {
    @DataProvider(name = "DivideDataProvider")
    public Object[][] divideDataProvider(){
        return new Object[][]{
                {"2/1", 2.0},
                {"5/10", 0.5},
                {"10/4", 2.5}
        };
    }

    @Test(dataProvider = "DivideDataProvider", dependsOnMethods = "TestCalcSubtract.testSubtract")
    public void testDivide(String expression, double result){
        Assert.assertEquals(Calculator.calculateExpression(expression), result);
    }
}