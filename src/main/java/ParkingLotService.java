public class ParkingLotService {

    public String isParkedVehicle(String vehicaleId) {
        int uniqueId = (int) (Math.random()*100);
        ParkAt_ParkingLot parkAt_parkingLot = new ParkAt_ParkingLot();
        parkAt_parkingLot.addVehicle(uniqueId, vehicaleId);
        if(parkAt_parkingLot.getVehicleParked(uniqueId).equals(vehicaleId))
            return "Parked";
        return "UnParked";
    }
}
