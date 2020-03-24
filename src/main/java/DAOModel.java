public class DAOModel {
    private static Integer id;
    private static String make;
    private static String model;
    private static String year;
    private static String color;

    public DAOModel(Integer id, String make, String model, String year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
    public DAOModel(Integer id){
        this.id = id;

        }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public static String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

