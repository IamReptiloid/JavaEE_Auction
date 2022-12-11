package ru.rsreu.auction.data;

import ru.rsreu.auction.enums.RoleType;

public class User {
	private long id;
	private String userName;
	private String password;
	private RoleType role;
	private String name;
	private int isBlocked;

	private boolean status = false;

	public User(long id, String userName, String password, RoleType role, String name, int isBlocked) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.name = name;
		this.isBlocked = isBlocked;
	}

	public User(long id, String userName, String password, String name, int isBlocked) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.isBlocked = isBlocked;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsBlocked(int isBlocked) {
		this.isBlocked = isBlocked;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public RoleType getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public int getIsBlocked() {
		return isBlocked;
	}

	@Override
	public String toString() {
		return "User {" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				", isBlocked=" + isBlocked +
				", status=" + status +
				"}";
	}
}
