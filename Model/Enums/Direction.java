package Model.Enums;

public enum Direction  
{
    RIGHT,
    DOWN,
    LEFT,
    UP;

    public Direction getNextDirection()
    {
        if(this.ordinal() + 1 < Direction.values().length)
        {
            return Direction.values()[this.ordinal() + 1];
        }
        else
        {
            return null;
        }
    }

    public static Direction getStartingDirection()
    {
        return Direction.values()[0];
    }
}
