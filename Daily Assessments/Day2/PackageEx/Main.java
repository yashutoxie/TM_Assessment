import library.books.Book;
import library.members.Member;
import static library.utils.Utility.*; // Static import for generateId()
 
public class Main {
    public static void main(String[] args) { 
        Book book = new Book("1984", "George Orwell", generateId());
        book.displayBookInfo();

        System.out.println();
 
        Member member = new Member("Jack", generateId());
        member.displayMemberInfo();
    }
}
