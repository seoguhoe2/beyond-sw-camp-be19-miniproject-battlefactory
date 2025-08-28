package battlefactory.member;

import battlefactory.member.aggregate.Rank;
import battlefactory.member.aggregate.UserStatus;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void registMember() {
        Member regiMember = new Member();
        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입을 시작합니다!");
        String id;
        String nickname;
        while (true) {
            System.out.print("아이디를 입력하세요: ");
            id = sc.nextLine();
            if(isDuplicated(Member -> Member.getId(), id) == true) {
                System.out.println("아이디가 중복됐습니다! 다른 아이디를 입력해주세요!");
            } else {
                regiMember.setId(id); break;
            }
        }
        System.out.print("비밀번호를 입력하세요: ");
        regiMember.setPwd(sc.nextLine());
        while (true) {
            System.out.print("사용할 닉네임을 입력하세요: ");
            nickname = sc.nextLine();
            if(isDuplicated(Member -> Member.getNickname(), nickname) == true) {
                System.out.println("닉네임이 중복됐습니다! 다른 닉네임을 입력해주세요!");
            } else {
                regiMember.setId(id); break;
            }
        }
        int lastNo = memberRepository.findLastNumber();
        regiMember.setMemNo(lastNo + 1);
        regiMember.setWinningStreak(0);
        regiMember.setTotalWins(0);
        regiMember.setRank(Rank.BEGINNER);
        regiMember.setStatus(UserStatus.ACTIVE);

        int result = memberRepository.registRepo(regiMember);
        if(result == 1) {
            System.out.println("회원가입이 완료됐습니다! 로그인 해주세요!");
        } else {
            System.out.println("회원 가입이 실패했습니다...");
        }
    }

    private boolean isDuplicated(Function<Member, String> getFunction, String target) {
        ArrayList<Member> dupCheckList = memberRepository.getMemberList();
        return dupCheckList.stream()
                .anyMatch(member -> getFunction.apply(member).equals(target));

    }

}
