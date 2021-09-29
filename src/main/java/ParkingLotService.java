public class ParkingLotService {

    private String vehicleId;
    private int uniqueId;
    ParkAt_ParkingLot parkAt_parkingLot = new ParkAt_ParkingLot();

    public void parkedVehicle(String vehicleId) throws ParkingLotException {
        uniqueId = (int) (Math.random()*100);
        if(this.vehicleId != null)
            throw new ParkingLotException("Parking Lot Full");
        this.vehicleId = vehicleId;
        parkAt_parkingLot.addVehicle(uniqueId, vehicleId);
    }

    public boolean isParkedVehicle(String vehicleId) {
        return parkAt_parkingLot.getVehicleParked(uniqueId).equals(vehicleId);
    }

    public boolean isUnparkedVehicle(String vehicleId) {
        return parkAt_parkingLot.getVehicleParked(uniqueId).equals(vehicleId);
    }


    public boolean isParkingLotFull() {
        return parkAt_parkingLot.getVehicleParked(uniqueId).equals(vehicleId);
    }

    public boolean isParkingLotHasFreeSpace() {
        return this.vehicleId == null;
    }
}
