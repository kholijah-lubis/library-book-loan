package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private final List<Member> members = new ArrayList<>();

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Member getMemberById(UUID id) {
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Member createMember(Member member) {
        member.setId(UUID.randomUUID());
        members.add(member);
        return member;
    }

    @Override
    public Member updateMember(UUID id, Member updatedMember) {
        Member existingMember = getMemberById(id);
        if (existingMember != null) {
            existingMember.setName(updatedMember.getName());
            existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
            existingMember.setAddress(updatedMember.getAddress());
            return existingMember;
        }
        return null;
    }

    @Override
    public void deleteMember(UUID id) {
        Member existingMember = getMemberById(id);
        if (existingMember != null) {
            members.remove(existingMember);
        }
    }
}
