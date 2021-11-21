package designpatterns.utils.models;

public enum Direction {

	EAST(0,1),
	SOUTH_EAST(-1,1),
	SOUTH(-1,0),
	SOUTH_WEST(-1,-1),
	NULL;

	private int row;
	private int column;

	Direction(){
	}

	Direction(int row, int column){
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isNull() {
		return this == Direction.NULL;
	}	

}
