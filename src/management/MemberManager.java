package management;

import library.Member;
import library.Transaction;
import datastructures.maps.CustomHashMap;

public class MemberManager {
    private CustomHashMap<String, Member> members;

    public MemberManager() {
        this.members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member != null && member.getMemberId() != null) {
            this.members.put(member.getMemberId(), member);
        }
    }

    public Member getMember(String memberId) {
        if (memberId != null) {
            return this.members.get(memberId);
        }
        return null;
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = getMember(memberId);
        if (member != null && transaction != null) {
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = getMember(memberId);
        if (member != null) {
            return member.getLastTransaction();
        }
        return null;
    }
}