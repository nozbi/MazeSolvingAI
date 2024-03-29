package Model.Structs;

import Model.Enums.Direction;

public class LocationWithDirection 
{
	private Location location;
    private Direction direction;

	public LocationWithDirection(Location locationParameter) 
	{
		this.location = locationParameter;
        this.direction = Direction.getStartingDirection();
	}

	public Location getLocation()
    {
        return this.location;
    }

	public Direction getDirection()
	{
		return this.direction;
	}

	public void changeDirection() 
	{
		if(this.direction != null)
		{
			this.direction = this.direction.getNextDirection();
		}
	}
}
