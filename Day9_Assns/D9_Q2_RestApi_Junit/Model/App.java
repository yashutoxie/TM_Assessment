package com.test.UserManagement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	User user = new User(1L, "John", "Doe");
    	System.out.println(user.toString());
    }
}
