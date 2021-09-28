import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void driverParkTheirCarInParking_Sucess(){
        ParkingLotService parkingLotService = new ParkingLotService();
        String vehicaleId = "MH-04-122";
        String actual = parkingLotService.isParkedVehicle(vehicaleId);
        String expected = "Parked";
        Assertions.assertEquals(expected,actual);
    }
}
