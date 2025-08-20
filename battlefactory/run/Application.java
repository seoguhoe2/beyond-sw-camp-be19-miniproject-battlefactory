package battlefactory.run;

import battlefactory.battle.service.BattleService;
import battlefactory.member.service.MemberService;
import battlefactory.pokemon.service.PokemonService;

import java.util.Scanner;

public class Application {
    private static final MemberService ms = new MemberService();
    private static final PokemonService ps = new PokemonService();
    private static final BattleService bs = new BattleService();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();

    }
}
