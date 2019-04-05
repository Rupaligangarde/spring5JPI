package com.example.demo.bootstrap

import com.example.demo.model.Author
import com.example.demo.model.Book
import com.example.demo.model.Publisher
import com.example.demo.repository.AuthorRepository
import com.example.demo.repository.BookRepository
import com.example.demo.repository.PublisherRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class Bootstrap(
        private val authorRepository: AuthorRepository,
        private val bookRepository: BookRepository,
        private val publisherRepository: PublisherRepository
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initData()
    }

    private fun initData() {
        val foo = Publisher(1, "foo", null)
        val chandler = Author(11, "chandler", "bing")
        val friendsBook = Book(1101, "1101", "friends", foo)


        chandler.books = setOf(friendsBook)
        friendsBook.authors = setOf(chandler)
        friendsBook.publisher = foo

        publisherRepository.save(foo)
        authorRepository.save(chandler)
        bookRepository.save(friendsBook)
    }

}

