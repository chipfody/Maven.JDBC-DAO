package daos;

import java.util.List;

public interface UserCarDao {
    DAOCarModel findCarById(int id);
    List<DAOCarModel> getAllCars();
    Boolean insertCar(DAOCarModel newCar);
    DAOCarModel updateCar(DAOCarModel newCar);
    Boolean deleteCar(Integer id);
}

