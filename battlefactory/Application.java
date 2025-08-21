package battlefactory;

import battlefactory.battle.BattleService;
import battlefactory.member.MemberService;
import battlefactory.pokemon.PokemonService;

import java.util.Scanner;

public class Application {
    private static final MemberService ms = new MemberService();
    private static final PokemonService ps = new PokemonService();
    private static final BattleService bs = new BattleService();
    public static void main(String[] args) {
//        ms.StartGame();
        Scanner sc = new Scanner(System.in);
        System.out.println("=========== 배틀팩토리에 어서오세요! ===========");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 회원정보 조회");
        System.out.println("4. 회원정보 수정");
        System.out.println("9. 프로그램 종료하기");
        System.out.print("원하시는 기능의 번호를 입력해주세요!");
        int input = sc.nextInt();
        switch (input) {
            case 1: ms.registMember(); break;
            case 2: ms.login(); break;
            case 3: ms.findMemberByNickname(); break;
            case 4: ms.modifyMember(); break;
            case 9: System.out.print("게임을 즐겨주셔서 감사합니다!"); return;
            default:
                System.out.println("번호가 잘못 입력됐습니다. 다시 입력해주세요!");
        }
    }
}
