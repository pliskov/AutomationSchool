import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalcAdd {
    @DataProvider(name = "AddDataProvider")
    public Object[][] addDataProvider(){
        return new Object[][]{
                {"1+2", 3.0},
                {"4+5", 9.0},
                {"6.7 + 6.7", 13.4},
                {"-1+3", 2.0}
        };
    }

    @Test(dataProvider = "AddDataProvider")
    public void testAdd(String expression, double result){
        Assert.assertEquals(Calculator.calculateExpression(expression), result);
    }
}