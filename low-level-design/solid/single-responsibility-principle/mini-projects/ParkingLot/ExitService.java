class ExitService {

    void removeVehicle(ParkingSlot slot, String vehicleNumber) {
        if (slot == null) return;
        slot.isOccupied = false;
        System.out.println("Vehicle " + vehicleNumber + " removed from slot " + slot.slotId);
    }
}
