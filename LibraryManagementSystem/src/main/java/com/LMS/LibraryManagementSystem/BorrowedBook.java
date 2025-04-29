package com.LMS.LibraryManagementSystem;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class BorrowedBook {
    private LocalDate loanDate;
    private double dueAmount;

    public BorrowedBook() {}

    public BorrowedBook(LocalDate loanDate, double dueAmount) {
        this.loanDate = loanDate;
        this.dueAmount = dueAmount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    @Override
    public String toString() {
        return "BorrowedBook{loanDate=" + loanDate + ", dueAmount=" + dueAmount + "}";
    }
}
