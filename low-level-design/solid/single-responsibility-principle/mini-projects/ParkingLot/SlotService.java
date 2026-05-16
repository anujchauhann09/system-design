import java.util.List;

class SlotService {

    ParkingSlot findAvailableSlot(List<ParkingSlot> slots) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied) return slot;
        }
        System.out.println("No slots available.");
        return null;
    }
}
