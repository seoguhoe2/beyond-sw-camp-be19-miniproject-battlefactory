package battlefactory.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberService {
    private static MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void registMember() {
        Member regiMember = new Member();
        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입을 시작합니다!");
        System.out.print("아이디를 입력하세요: ");

        System.out.print("비밀번호를 입력하세요: ");
        regiMember.setPwd(sc.nextLine());
        System.out.print("사용할 닉네임을 입력하세요: ");
        regiMember.setNickname(sc.nextLine());
    }


    private interface dupCheck {
        ArrayList<Member> dupCheckList = memberRepository.getMemberList();
        Iterator<Member> iterator = dupCheckList.iterator();
    }
}
