package webDriverFactory;

public enum DriverManagerType {
    CHROME("ChromeDriver", "Init ChromeDriver"),
    FIREFOX("FirefoxDriver", "Init FirefoxDriver"),
    EGGE("EdgeDriver", "Init EdgeDriver");
    private final String driverName;

    DriverManagerType(String driverName, String desc) {
        this.driverName = driverName;
    }

    public String getDriver() {
        return driverName;
    }
}