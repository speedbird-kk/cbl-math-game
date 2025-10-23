package Experimentation.Components.Lanes;

public record AllLanes(
    Lane productLane, Lane quotientLane, Lane sumLane, Lane differenceLane) {

    public void reinitialise() {
        // reinitialise operands of each lane
    }
}
