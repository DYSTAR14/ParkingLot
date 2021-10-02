import java.util.ArrayList;

public class ParkingLotService {

    private ArrayList<String> vehiclesList;
    private ArrayList<Observer> observersList;
    private int actualCapacity;
    ParkAtParkingLot parkAt_parkingLot = new ParkAtParkingLot();
    private String vehicleId;
    private int uniqueId;
    public ParkingLotService(){}

    public ParkingLotService(int actualCapacity) {
        this.actualCapacity = actualCapacity;
        this.vehiclesList = new ArrayList<>();
        this.observersList = new ArrayList<>();
    }

    public void lotServiceRegister(Observer observer){
//        this.observer = observer;
        this.observersList.add(observer);
    }

    public void parkingVehicle(String vehicleId) throws ParkingLotException {
        if (isVehicleParked(vehicleId))
            throw new ParkingLotException("This Vehicle Already Parked");
        if (this.vehiclesList.size() == this.actualCapacity) {
            for (Observer observer : observersList) {
                observer.capacityIsFull();
            }
            throw new ParkingLotException("Parking Lot Full");
        }
        vehiclesList.add(vehicleId);
    }

    public boolean isVehicleParked(String vehicleId) {
        return this.vehiclesList.contains(vehicleId);
    }

    public boolean vehicleUnparked(String vehicleId) {
        if(vehicleId == null) return false;
        if(this.vehiclesList.contains(vehicleId)){
            this.vehiclesList.remove(vehicleId);
            for (Observer observer:observersList) {
                observer.capacityIsAvailable();
            }
            return true;
        }
        return false;
    }

    public boolean isParkingLotHasFreeSpace() {
        return this.vehicleId == null;
    }

//    public boolean onUpdateReport() {
//        for (Observer observer: observersList) {
//            return observer.onUpdate(isParkingLotFull());
//        }
//        return false;
//    }
}
