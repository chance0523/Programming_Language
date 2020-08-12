package com.ssafy;

import java.util.List;

public interface IBookMgr {

	void add(Book b);

	List<Book> search();

	void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;

	void buy(String isbn, int quantity) throws ISBNNotFoundException;

	int getTotalAmount();
}
