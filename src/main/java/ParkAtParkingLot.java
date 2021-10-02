public class ParkAtParkingLot {
    String[] parkingLotStore = new String[100];

    public void addVehicle(int uniqueId, String vehicaleId) {
        parkingLotStore[uniqueId] = vehicaleId;
    }

    public String getVehicleParked(int uniqueId) {
        return parkingLotStore[uniqueId];
    }
}
