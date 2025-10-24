package Experimentation.components.lanes;

public record AllLanes(
    Lane productLane, Lane quotientLane, Lane sumLane, Lane differenceLane) {

    public void reinitialise() {
        // reinitialise operands of each lane
    }
}
