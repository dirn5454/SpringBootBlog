package com.woong.blog.model;



import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 디비의 넘버링 전략을 따라감
	private int id;  //auto_increament
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) 
	private String password;
	@Column(nullable = false, length = 50)
	private String email;
	

	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	
	@CreationTimestamp // 시간 자동입력
	private Timestamp createDate; //회원이 가입한 시간




	
}
