package Model.Classes;

import java.util.Stack;
import Model.Enums.PathFinderStatus;
import Model.Structs.Location;
import Model.Structs.LocationWithDirection;
import Model.Structs.PathFinderResult;

public class PathFinder 
{
	private Stack<LocationWithDirection> stack;
	private Maze maze;

	public PathFinder(Maze mazeParameter)
	{
		this.maze = mazeParameter;
		this.stack = new Stack<LocationWithDirection>();
		LocationWithDirection startingLocationWithDirection = new LocationWithDirection(this.maze.getStartLocationCopy());
		this.stack.push(startingLocationWithDirection);
	}

	public PathFinderResult getNextFindingStepResult()
	{
		if(this.stack.empty())
		{
			return new PathFinderResult(PathFinderStatus.PATH_NOT_FOUND, this.maze.getMazeArray());
		}
		else if (this.maze.isLocationTheTarget(this.stack.peek().getLocation()))
		{
			this.maze.setLocationAsPath(this.stack.peek().getLocation());
			return new PathFinderResult(PathFinderStatus.PATH_FOUND, this.maze.getMazeArray());
		}
		else if(this.stack.peek().getDirection() == null)
		{
			this.maze.setLocationAsVisited(this.stack.peek().getLocation());
			this.stack.pop();
			return new PathFinderResult(PathFinderStatus.SEARCHING, this.maze.getMazeArray());
		}
		else
		{
			LocationWithDirection currentlocationWithDirection = this.stack.peek();

			Location nextLocation = null;
			while(currentlocationWithDirection.getDirection() != null)
			{
				nextLocation = currentlocationWithDirection.getLocation().getCopy();
				switch(currentlocationWithDirection.getDirection())
				{
					case UP: 
						nextLocation.moveUp();
						break;
					case DOWN:
						nextLocation.moveDown();
						break;
					case LEFT:
						nextLocation.moveLeft();
						break;
					case RIGHT:
						nextLocation.moveRight();
						break;
					default:
						break;
				}
				currentlocationWithDirection.changeDirection();
				if(this.maze.isLocationUnvisited(nextLocation))
				{
					LocationWithDirection newLocationWithDirection = new LocationWithDirection(nextLocation);
					this.stack.push(newLocationWithDirection);
					break;
				}
			}

			if(!this.maze.isLocationPath(currentlocationWithDirection.getLocation()))
			{
				this.maze.setLocationAsPath(currentlocationWithDirection.getLocation());
				return new PathFinderResult(PathFinderStatus.SEARCHING, this.maze.getMazeArray());
			}
			else if(nextLocation == null)
			{
				this.maze.setLocationAsVisited(this.stack.peek().getLocation());
				this.stack.pop();
				return new PathFinderResult(PathFinderStatus.SEARCHING, this.maze.getMazeArray());
			}
			else
			{
				return this.getNextFindingStepResult();
			}
		}
	}

	public PathFinderResult getPathFinderResult()
	{
		PathFinderResult pathFinderResult = this.getNextFindingStepResult();
		while((pathFinderResult.getPathFinderStatus() != PathFinderStatus.PATH_FOUND) && (pathFinderResult.getPathFinderStatus() != PathFinderStatus.PATH_NOT_FOUND))
		{
			pathFinderResult = this.getNextFindingStepResult();
		}
		return pathFinderResult;
	}
}
