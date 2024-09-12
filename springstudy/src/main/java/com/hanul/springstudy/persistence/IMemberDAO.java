package com.hanul.springstudy.persistence;

import com.hanul.springstudy.domain.MemberDTO;

public interface IMemberDAO {
	public String getTime();
	public void insertMember(MemberDTO mDto);
}
