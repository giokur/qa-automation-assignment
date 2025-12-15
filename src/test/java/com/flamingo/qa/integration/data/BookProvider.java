package com.flamingo.qa.integration.data;

import com.flamingo.qa.integration.api.BooksApi;
import com.flamingo.qa.integration.models.BookList;
import net.datafaker.Faker;

public class BookProvider {

    public static String getBookToSearch() {
        BookList books = BooksApi.getBooks();
        Faker faker = new Faker();
        int index = faker.number().numberBetween(0, books.getBooks().size() - 1);
        return books.getBooks().get(index).getTitle();
    }
}
