package io.github.dunwu.springboot.snake;

public class Location {

    /**
     * The X location.
     */
    public int x;

    /**
     * The Y location.
     */
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location getAdjacentLocation(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Location(this.x, this.y - SnakeUtils.GRID_SIZE);
            case SOUTH:
                return new Location(this.x, this.y + SnakeUtils.GRID_SIZE);
            case EAST:
                return new Location(this.x + SnakeUtils.GRID_SIZE, this.y);
            case WEST:
                return new Location(this.x - SnakeUtils.GRID_SIZE, this.y);
            case NONE:
                // fall through
            default:
                return this;
        }
    }

    @Override
    public int hashCode() {
        int result = this.x;
        result = 31 * result + this.y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        if (this.x != location.x) {
            return false;
        }
        if (this.y != location.y) {
            return false;
        }
        return true;
    }

}
