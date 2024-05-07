package edu.pnu.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVOBuilder;
import lombok.Builder;

@RestController
public class MemberController {
	
	List<MemberVOBuilder> memberlist = new ArrayList<>();
	
	public MemberController() {
	
		for (int i=1; i<=10; i++) {
			MemberVOBuilder membervo= new MemberVOBuilder();
					membervo.setId(i);
					membervo.setName("name"+i);
					membervo.setPass("pass"+i);
					membervo.setRegidate(new Date());
					memberlist.add(membervo);
		}
	}

	@GetMapping("/members")
	public List<MemberVOBuilder> getAllMember(){
		return memberlist;
	}

	@GetMapping("/member")
	public MemberVOBuilder getMemberById(Integer id) {
		for (MemberVOBuilder m: memberlist) {
			if(m.getId() == id){
				return m;
			}		
			return null;
		}
		return null;	
	}
	
	@PostMapping("/member")
	public MemberVOBuilder addMember(MemberVOBuilder memberVO) {
		if(getMemberById(memberVO.getId())!=null)
			return null;
		memberVO.setRegidate(new Date());
		memberlist.add(memberVO);
		return memberVO;
		
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVOBuilder memberVO) {
		MemberVOBuilder m = getMemberById(memberVO.getId());
		if(m==null)
			return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}
	
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		try {
			memberlist.remove(getMemberById(id));
		}catch(Exception e) {
			return 0;
		}
		return 1;
	}
	
	@PostMapping("/memberJSON")
	public MemberVOBuilder addMemberJSON(@RequestBody MemberVOBuilder memberVO) {
		
		return addMember(memberVO);
	}
	
	@PutMapping("/memberJSON")
	public int updateMemberJSON(@RequestBody MemberVOBuilder memberVO) {
		
		return updateMembers(memberVO);
	}
	
	@DeleteMapping("/memberJSON")
	public int removeMemberJSON(@RequestBody Integer memberVO) {
		return removeMember(memberVO);
		
	}
	
}
