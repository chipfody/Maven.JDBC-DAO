import org.junit.Assert;
import org.junit.Test;


public class DAOCarModelTest {
    DAOCarModel testCar = new DAOCarModel ( );


    @Test
    public void testgetId() {
        Integer expected = 101;
        testCar.setId ( 101 );
        Assert.assertEquals (expected, testCar.getId ());
    }

    @Test
    public void getMake() {
        String expected = "Mazda";
        testCar.setMake ( "Mazda" );
        Assert.assertEquals (expected, testCar.getMake ());
    }

    @Test
    public void getModel() {
        String expected = "Mazda6";
        testCar.setModel ( "Mazda6" );
        Assert.assertEquals (expected, testCar.getModel ());
    }

    @Test
    public void getYear() {
        String expected = "2016";
        testCar.setYear ( "2016" );
        Assert.assertEquals (expected, testCar.getYear ());
    }

    @Test
    public void getColor() {
        String expected = ("Midnight Blue");
        testCar.setColor ( "Midnight Blue" );
        Assert.assertEquals ( expected, testCar.getColor () );
    }

}
