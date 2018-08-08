package net.MHE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MHE_SensorData {
	@Id
	@GeneratedValue
	private	String MAC;
	private String ID;
	private int Activity;
	private int Vector0;
	private int Vector1;
	private int Vector2;
	private int Vector3;
	private int Vector4;
	private int Vector5;
	private int Vector6;
	private int Vector7;
	private int Vector8;
	private int Vector9;
	private int Vector10;
	private int Vector11;
	private int Vector12;
	private String Vector13;
	private String time;
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getActivity() {
		return Activity;
	}
	public void setActivity(int activity) {
		Activity = activity;
	}
	public int getVector0() {
		return Vector0;
	}
	public void setVector0(int vector0) {
		Vector0 = vector0;
	}
	public int getVector1() {
		return Vector1;
	}
	public void setVector1(int vector1) {
		Vector1 = vector1;
	}
	public int getVector2() {
		return Vector2;
	}
	public void setVector2(int vector2) {
		Vector2 = vector2;
	}
	public int getVector3() {
		return Vector3;
	}
	public void setVector3(int vector3) {
		Vector3 = vector3;
	}
	public int getVector4() {
		return Vector4;
	}
	public void setVector4(int vector4) {
		Vector4 = vector4;
	}
	public int getVector5() {
		return Vector5;
	}
	public void setVector5(int vector5) {
		Vector5 = vector5;
	}
	public int getVector6() {
		return Vector6;
	}
	public void setVector6(int vector6) {
		Vector6 = vector6;
	}
	public int getVector7() {
		return Vector7;
	}
	public void setVector7(int vector7) {
		Vector7 = vector7;
	}
	public int getVector8() {
		return Vector8;
	}
	public void setVector8(int vector8) {
		Vector8 = vector8;
	}
	public int getVector9() {
		return Vector9;
	}
	public void setVector9(int vector9) {
		Vector9 = vector9;
	}
	public int getVector10() {
		return Vector10;
	}
	public void setVector10(int vector10) {
		Vector10 = vector10;
	}
	public int getVector11() {
		return Vector11;
	}
	public void setVector11(int vector11) {
		Vector11 = vector11;
	}
	public int getVector12() {
		return Vector12;
	}
	public void setVector12(int vector12) {
		Vector12 = vector12;
	}
	public String getVector13() {
		return Vector13;
	}
	public void setVector13(String vector13) {
		Vector13 = vector13;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
<<<<<<< HEAD
		return "MHE_SensorData MAC=" + MAC + ",   UID=" + UID + ", Activity=" + Activity + ", Vector0=" + Vector0
				+ ", Vector1=" + Vector1 + ", Vector2=" + Vector2 + ", Vector3=" + Vector3 + ", Vector4=" + Vector4
				+ ", Vector5=" + Vector5 + ", Vector6=" + Vector6 + ", Vector7=" + Vector7 + ", Vector8=" + Vector8
				+ ", Vector9=" + Vector9 + ", Vector10=" + Vector10 + ", Vector11=" + Vector11 + ", Vector12="
				+ Vector12 + ", Vector13=" + Vector13 + ", time=" + time;
=======
		return "MHE_SensorData MAC=" + MAC + ", ID=" + ID + ", Activity=" + Activity + ", Vector0=" + Vector0
				+ ", Vector1=" + Vector1 + ", Vector2=" + Vector2 + ", Vector3=" + Vector3 + ", Vector4=" + Vector4
				+ ", Vector5=" + Vector5 + ", Vector6=" + Vector6 + ", Vector7=" + Vector7 + ", Vector8=" + Vector8
				+ ", Vector9=" + Vector9 + ", Vector10=" + Vector10 + ", Vector11=" + Vector11 + ", Vector12="
				+ Vector12 + ", Vector13=" + Vector13 + ", time=" + time ";
>>>>>>> 28a36590d0c42b8bae3a147c15b978fb2e4563b8
	}
	
	
}

