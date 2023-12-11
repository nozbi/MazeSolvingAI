package Model.Structs;

public class Location 
{
    private int x;
    private int y;

    public Location(int xParameter, int yParameter)
    {
        this.x = xParameter;
        this.y = yParameter;
    }

    public int getX()
    {
        return this.x;
    }

     public int getY()
    {
        return this.y;
    }

    public void moveUp()
    {
        this.y--;
    }

    public void moveDown()
    {
        this.y++;
    }

    public void moveLeft()
    {
        this.x--;
    }

    public void moveRight()
    {
        this.x++;
    }

    public Location getCopy()
    {
        return new Location(this.x, this.y);
    }

    public boolean isLocationEqual(Location locationParameter)
    {
        if((this.x == locationParameter.x) && (this.y == locationParameter.y))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
