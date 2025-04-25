/*Your client wants a discount calculator for an online store with the following rules:
If the cart value is above $500, apply a 20% discount.
If the cart value is between $100 and $500, apply a 10% discount.
Otherwise, no discount.

Write a function calculateFinalPrice(double cartValue) that returns the final amount after applying the discount.
 */
class Main{
  public static double calculateFinalPrice(double cartValue) {
        if (cartValue > 500) return cartValue * 0.8;
        if (cartValue >= 100) return cartValue * 0.9;
        return cartValue;
  }
  public static void main(String[] args){
    int n = 1500;
    System.out.println(calculateFinalPrice(n));
  }
}
