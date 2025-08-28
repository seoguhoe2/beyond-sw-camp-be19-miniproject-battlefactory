package battlefactory.member;

import battlefactory.member.aggregate.Rank;
import battlefactory.member.aggregate.UserStatus;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private static final ArrayList<Member> memberList = new ArrayList<>();
    private final File file =
            new File("src/main/java/battlefactory/member/db/memberdb.dat");

    public MemberRepository() {
        if(!file.exists()) {
            ArrayList<Member> defaultMemberList = new ArrayList<>();
            defaultMemberList.add(new Member(
                    1, "SuperAdmin", "masterpassword", "ADMINISTRATOR",
                    0, 0, Rank.ADMIN, UserStatus.ADMIN));
            saveMembers(defaultMemberList);
        }
        loadRepo();
    }

    private void saveMembers(ArrayList<Member> memberList) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            for(Member member: memberList) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Member> setMemberList(ArrayList<Member> memberList) {
        return this.memberList;
    }



    public int findLastNumber() {
       return memberList.get(memberList.size() - 1).getMemNo();
    }

    public int registRepo(Member regiMember) {
        MyObjectOutput moo = null;
        int result = 0;
        try {
            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file,true)));
            moo.writeObject(regiMember);
            moo.flush();
            
            memberList.clear();
            loadRepo();
            result = 1;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    private void loadRepo() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while(true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 읽어오기 완료!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
