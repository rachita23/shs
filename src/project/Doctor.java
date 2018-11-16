package project;
public class Doctor extends Person {

	private int id;
	private String appt;
	private int deptid;
	private String position;
	private int roomno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppt() {
		return appt;
	}
	public void setAppt(String appt) {
		this.appt = appt;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
}
