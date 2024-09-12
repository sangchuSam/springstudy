package com.hanul.springstudy.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
	private String userid;
	private String userpw;
	private String name;
	private String email;
	private Timestamp regdate;
	private Timestamp updatedate;
}
