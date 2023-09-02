package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Member;
import java.util.List;
import java.util.UUID;

public interface MemberService {
    List<Member> getAllMembers();
    Member getMemberById(UUID id);
    Member createMember(Member member);
    Member updateMember(UUID id, Member updatedMember);
    void deleteMember(UUID id);
}
