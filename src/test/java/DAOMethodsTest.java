import org.junit.Assert;
import org.junit.Test;

public class DAOMethodsTest {

    @Test
    public void testFindCarById() {
        Integer indexToTest = 101;
        String expected = "Car is not registered";
        String actual = DAOMethods.findCarById (indexToTest).toString ();

        Assert.assertEquals (expected, actual);
    }

    @Test
    public void testFindCarById2() {
        Integer indexToTest = 5;
        String expected = "Mercedes-Benz";
        String actual = DAOMethods.findCarById (indexToTest).toString ();

        Assert.assertEquals (expected, actual);
    }

    @Test
    public void testInsertCar() {
        Boolean expected = true;
        DAOModel testCar = new DAOModel (101, "Honda", "Accord", "2013", "Blue"  );
        
    }
}
