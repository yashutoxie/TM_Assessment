package library.members;
 
public class Member {
    private String name;
    private String memberId;
 
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }
 
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
    }
}
