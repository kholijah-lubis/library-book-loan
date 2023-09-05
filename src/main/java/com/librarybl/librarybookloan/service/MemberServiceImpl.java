package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Member;
import com.librarybl.librarybookloan.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(UUID id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(UUID id, Member updatedMember) {
        Member existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            BeanUtils.copyProperties(updatedMember, existingMember, "id");
            return memberRepository.save(existingMember);
        }
        return null;
    }

    @Override
    public void deleteMember(UUID id) {
        memberRepository.deleteById(id);
    }
}
