import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

//    UC1
    @Test
    public void givenAVehivle_WhenParked_ShouldReturnTrue(){
        ParkingLotService parkingLotService = new ParkingLotService(1);
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkingVehicle(vehicleId);
            boolean isParked = parkingLotService.isVehicleParked(vehicleId);
            Assertions.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenLotIsFull_ShouldReturnFalse() {
        ParkingLotService parkingLotService = new ParkingLotService(1);
        String vehicleId = "MH-04-122";

        try {
            parkingLotService.parkingVehicle(vehicleId);
            String vehicleId2 = "MH-04-1224";
            parkingLotService.parkingVehicle(vehicleId2);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot Full",e.getMessage());
            e.printStackTrace();
        }
    }

//    UC2
    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue(){
        ParkingLotService parkingLotService = new ParkingLotService(1);
        String vehicleId = "MH-04-122";
        try {
            parkingLotService.parkingVehicle(vehicleId);
            boolean isUnparked = parkingLotService.vehicleUnparked(vehicleId);
            Assertions.assertTrue(isUnparked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

//    UC3
    @Test
    void isParkingLot_IsFull_ParkingLotOwner_ShouldReturnTrue() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLotService parkingLotService = new ParkingLotService(1);
        parkingLotService.lotServiceRegister(parkingLotOwner);
        try {
            String vehicleId = "MH-04-122";
            parkingLotService.parkingVehicle(vehicleId);
            String vehicleId1 = "MH-04-1224";
            parkingLotService.parkingVehicle(vehicleId1);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        boolean isParkingLotFull = parkingLotOwner.isCapacityFull();
        Assertions.assertTrue(isParkingLotFull);
    }

//    UC4
    @Test
    void isParkingLot_IsFull_AirportSecurityPersonal_ShouldReturnTrue() {
        AirportSecurityPersonal airportSecurityPersonal = new AirportSecurityPersonal();
        ParkingLotService parkingLotService = new ParkingLotService(1);
        parkingLotService.lotServiceRegister(airportSecurityPersonal);

        try {
            String vehicleId = "MH-04-122";
            parkingLotService.parkingVehicle(vehicleId);
            String vehicleId1 = "MH-04-1224";
            parkingLotService.parkingVehicle(vehicleId1);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        boolean isParkingLotFull = airportSecurityPersonal.isCapacityFull();
        Assertions.assertTrue(isParkingLotFull);
    }

//    UC5
    @Test
    void isParkingLot_IsFreeSpace_ShouldRetrunTrue() {
        ParkingLotService parkingLotService = new ParkingLotService(2);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        String vehicleId = "MH-04-122";
        String vehicleId1 = "MH-04-1224";
        try {
            parkingLotService.parkingVehicle(vehicleId);
            parkingLotService.parkingVehicle(vehicleId1);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        parkingLotService.vehicleUnparked(vehicleId);
        boolean capacityFull = parkingLotOwner.isCapacityFull();
        Assertions.assertFalse(capacityFull);
    }



}
