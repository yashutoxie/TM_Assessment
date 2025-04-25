/*A software system needs an integer compression technique to store large numbers efficiently.
Implement a method to encode an integer using bitwise operations.
Write another method to decode the integer back.
Example Usage:
int encoded = encode(12345);
int decoded = decode(encoded);
System.out.println(decoded); // Output: 12345
*/
class Main{
public class IntegerCompression {
    public static int encode(int num) {
        return num << 1;
    }
    public static int decode(int encoded) {
        return encoded >> 1;
    }
}
 public static void main(String[] args){
        int n = 123;
        int en = encode(123);
        System.out.println(en);
        System.out.println(decode(en));
    }
}
