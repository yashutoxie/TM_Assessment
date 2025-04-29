package com.LMS.LibraryManagementSystem.service;
 
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map; 

import com.LMS.LibraryManagementSystem.Book;
import com.LMS.LibraryManagementSystem.BorrowedBook;
import com.LMS.LibraryManagementSystem.Member; 

public class FineCalculator {
	public int calcFine(Member member) {
		int totalFine = 0;
		for(Map.Entry<Book, BorrowedBook> entry : member.getBorrowedBooks().entrySet()) {
			BorrowedBook borrowedBook = entry.getValue();
			LocalDate dueDate = borrowedBook.getLoanDate();
			if(LocalDate.now().isAfter(dueDate)) {
				totalFine +=  ChronoUnit.DAYS.between(dueDate, LocalDate.now());
			}
		}
		
		return totalFine;
	}
}
