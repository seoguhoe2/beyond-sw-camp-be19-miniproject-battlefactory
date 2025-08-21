package battlefactory.member;

import battlefactory.member.aggregate.Rank;
import battlefactory.member.aggregate.UserStatus;

public class Member {
    private int memNo;
    private String id;
    private String pwd;
    private String nickname;
    private int winningStreak;
    private int totalWins;
    private Rank rank;
    private UserStatus status;
    public Member() {
    }

    public Member(int memNo, String id, String pwd, String nickname, int winningStreak, int totalWins, Rank rank, UserStatus status) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.winningStreak = winningStreak;
        this.totalWins = totalWins;
        this.rank = rank;
        this.status = status;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getWinningStreak() {
        return winningStreak;
    }

    public void setWinningStreak(int winningStreak) {
        this.winningStreak = winningStreak;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "nickname='" + nickname + '\'' +
                ", winningStreak=" + winningStreak +
                ", totalWins=" + totalWins +
                ", rank=" + rank +
                '}';
    }
}
