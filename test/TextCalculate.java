import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TextCalculate {

    @BeforeAll
    public static void notigication(){
        System.out.println("------------------------");
        System.out.println("     Umbala ambala trap ");
        System.out.println("------------------------");
    }
//    @AfterAll
//    public void beforeRunTestCase(){
//        System.out.println("Umbala ambala trap");
//    }
    @Test
    public void testFeatureAdd(){
        int result = Calculate.add(5,7);

        Assert.assertEquals(result, 12);

    }
    @Test
    @DisplayName("A")
    public void testFeatureMinue(){
        int result = Calculate.minue(7,7);

        Assert.assertEquals(result, 0);

    }
    @Test
    public void testFeatureMulti(){
        int result = Calculate.multi(7,5);

        Assert.assertEquals(result, 35);

    }
}
