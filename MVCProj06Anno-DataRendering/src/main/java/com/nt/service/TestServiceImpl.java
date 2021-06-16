package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.nt.dto.StudentDTO;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public String getData1() {
		return "raja";
	}

	@Override
	public int[] getData2() {
		return new int[] {20,30,56,78};
	}

	@Override
	public List<String> getData3() {
			return  List.of("Loyola school","Sri chaitnya"," CBIET");
	}

	@Override
	public Set<Long> getData4() {
		return Set.of(99999999L,88888888888L,7777777777L,66666666666L);
	}

	@Override
	public Map<String, Object> getData5() {
		return Map.of("shirt","PeterEngland","trouser","pepe","shoe","kelenji-Decothlan");
	}

	@Override
	public List<StudentDTO> getData6() {
		return List.of(new StudentDTO(101,"raja","hyd",89.0f),
				               new StudentDTO(102,"ramesh","vizag",56.0f),
				               new StudentDTO(103,"suresh","delhi",59.0f)
				               );
	}

}
