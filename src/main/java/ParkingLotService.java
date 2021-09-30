public class ParkingLotService {

    ParkAt_ParkingLot parkAt_parkingLot = new ParkAt_ParkingLot();
    private AirportSecurityPersonal observer;
    private String vehicleId;
    private int uniqueId;

    public ParkingLotService() {
    }

    public ParkingLotService(AirportSecurityPersonal airportSecurityPersonal) {
        this.observer = airportSecurityPersonal;
    }

    public void parkedVehicle(String vehicleId) throws ParkingLotException {
        uniqueId = (int) (Math.random() * 100);
        if (this.vehicleId != null)
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
        return this.vehicleId != null;
    }

    public boolean isParkingLotHasFreeSpace() {
        return this.vehicleId == null;
    }

    public boolean onUpdateAirportSecurityPersonal() {
        return observer.onUpdate(this.vehicleId);
    }
}
