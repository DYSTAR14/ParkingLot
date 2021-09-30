import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void givenAVehivle_WhenParked_ShouldReturnTrue(){
        ParkingLotService parkingLotService = new ParkingLotService();
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkedVehicle(vehicleId);
            boolean isParked = parkingLotService.isParkedVehicle(vehicleId);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        ParkingLotService parkingLotService = new ParkingLotService();
        String vehicleId = "MH-04-122";

        try {
            parkingLotService.parkedVehicle(vehicleId);
            String vehicleId2 = "MH-04-1224";
            parkingLotService.parkedVehicle(vehicleId2);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot Full",e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue(){
        ParkingLotService parkingLotService = new ParkingLotService();
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkedVehicle(vehicleId);
            boolean isUnparked = parkingLotService.isUnparkedVehicle(vehicleId);
            Assertions.assertTrue(isUnparked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isParkingLot_IsFull_ShouldReturnTrue() {
        ParkingLotService parkingLotService = new ParkingLotService();
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkedVehicle(vehicleId);
            boolean isParkingFull = parkingLotService.isParkingLotFull();
            Assertions.assertTrue(isParkingFull);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isParkingLot_IsFull_AirportSecurityPersonal_ShouldReturnTrue() {
        AirportSecurityPersonal airportSecurityPersonal = new AirportSecurityPersonal();
        ParkingLotService parkingLotService = new ParkingLotService(airportSecurityPersonal);
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkedVehicle(vehicleId);
            boolean isParkingFull = parkingLotService.onUpdateAirportSecurityPersonal();
            Assertions.assertTrue(isParkingFull);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isParkingLot_IsFreeSpace_ShouldRetrunTrue() {
        ParkingLotService parkingLotService = new ParkingLotService();
        boolean isParkingHasFreeSpace = parkingLotService.isParkingLotHasFreeSpace();
        Assertions.assertTrue(isParkingHasFreeSpace);
    }

}
