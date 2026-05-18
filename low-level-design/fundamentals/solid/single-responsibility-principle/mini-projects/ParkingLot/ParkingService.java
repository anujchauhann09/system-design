import java.util.ArrayList;
import java.util.List;

class ParkingService {

    List<ParkingSlot> slots = new ArrayList<>();
    SlotService slotService = new SlotService();
    EntryService entryService = new EntryService();
    ExitService exitService = new ExitService();

    ParkingService(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    void park(String vehicleNumber) {
        ParkingSlot slot = slotService.findAvailableSlot(slots);
        entryService.parkVehicle(slot, vehicleNumber);
    }

    void leave(ParkingSlot slot, String vehicleNumber) {
        exitService.removeVehicle(slot, vehicleNumber);
    }
}
