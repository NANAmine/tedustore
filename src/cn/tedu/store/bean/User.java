package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/user")
public class User implements Serializable {

	// 当类描述有变化时，该序列化版本号应该对应修改
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String image;
	private Integer gender;
	private String createdUser;
	private Date createdTime;// 年月日时秒分
								// 对应mysql中的：datetime或者timestamp
	private String modifiedUser;
	private Date modifiedTime;
	private int role;

	public User() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", image=" + image + ", gender=" + gender + ", created_user=" + createdUser
				+ ", created_time=" + createdTime + ", modified_user=" + modifiedUser + ", modified_time="
				+ modifiedTime + ", role=" + role + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getCreated_user() {
		return createdUser;
	}

	public void setCreated_user(String created_user) {
		this.createdUser = created_user;
	}

	public Date getCreated_time() {
		return createdTime;
	}

	public void setCreated_time(Date created_time) {
		this.createdTime = created_time;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modified_user) {
		this.modifiedUser = modified_user;
	}

	public Date getModified_time() {
		return modifiedTime;
	}

	public void setModified_time(Date modified_time) {
		this.modifiedTime = modified_time;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
