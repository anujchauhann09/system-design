class EntryService {

    void parkVehicle(ParkingSlot slot, String vehicleNumber) {
        if (slot == null) return;
        slot.isOccupied = true;
        System.out.println("Vehicle " + vehicleNumber + " parked at slot " + slot.slotId);
    }
}
