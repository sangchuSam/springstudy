package com.hanul.springstudy.domain;

import java.util.ArrayList;
import java.util.List;

import com.hanul.springstudy.SampleDTO;

import lombok.Data;


@Data
public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
	
}
