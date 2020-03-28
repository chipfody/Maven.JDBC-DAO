import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class DAOCarMethodsTest {
    DAOCarMethods testCar = new DAOCarMethods();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindCarById() {
        Integer indexToTest = 42;
        String expected = "Chevrolet";
        String actual = testCar.findCarById (42).getMake();
        Assert.assertEquals (expected, actual);
        Assert.assertEquals (expected, actual);
    }

    @Test
    public void testFindCarById2() {
        Integer indexToTest = 101;
        Assert.assertNull (testCar.findCarById (indexToTest));
    }

    @Test
    public void testGetAllCars() {

        List<DAOCarModel> testCarList = testCar.getAllCars ();
        Integer expected = 100;
        Integer actual = testCarList.size ();
        Assert.assertEquals (expected, actual);
    }

    @Test
    public void testInsertCar() {
        DAOCarModel testNewCar = new DAOCarModel (101, "Honda", "Accord", "2013", "Blue"  );
        Boolean actual = testCar.insertCar(testNewCar);
        System.out.println (testCar.insertCar ( testNewCar ));
        Assert.assertTrue (actual);
    }

    @Test
    public void testUpdateCar() {
        DAOCarModel updateCar = testCar.findCarById ( 74 );
        updateCar.setColor("Black");
        DAOCarModel testCar2 = testCar.updateCar(updateCar);

        String expected = "Black";
        String actual = testCar2.getColor ();
        Assert.assertEquals ( expected, actual );

    }

    @Test
    public void testDeleteCar() {
        List<DAOCarModel> testCarList = testCar.getAllCars ();

        Integer actual = testCarList.size ();
        System.out.println (actual);
        testCar.deleteCar ( 101 );
        Integer expected = testCarList.size();
        Assert.assertEquals (expected, actual);

    }
}
