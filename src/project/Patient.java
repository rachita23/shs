package project;
public class Patient extends Person {

	private int id;
	private int roomno;
	private String critical;
	private int referedto;
	private int referedby;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCritical() {
		return critical;
	}
	public void setCritical(String cr) {
		this.critical = cr;
	}
	public int getReferedto() {
		return referedto;
	}
	public void setReferedto(int rt) {
		this.referedto = rt;
	}
	public int getReferedby() {
		return referedby;
	}
	public void setReferedby(int rb) {
		this.referedby = rb;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
}
