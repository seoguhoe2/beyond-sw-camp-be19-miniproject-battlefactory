package battlefactory.member;

import battlefactory.member.aggregate.Rank;
import battlefactory.member.aggregate.UserStatus;

import java.io.File;
import java.util.ArrayList;

public class MemberRepository {
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file =
            new File("src/main/java/battlefactory/member/db/memberdb.xml");

    public ArrayList<Member> MemberRepository() {
        return memberList;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Member> setMemberList(ArrayList<Member> memberList) {
        return this.memberList;
    }


}
