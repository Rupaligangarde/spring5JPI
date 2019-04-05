package com.example.demo.model

import javax.persistence.*

@Entity
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val isbn:String,
        val title:String,
        @OneToOne
        var publisher: Publisher,
        @ManyToMany
        @JoinTable(
                name = "author_book",
                joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "author_id")]
        )
        var authors: Set<Author> = emptySet()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false
        if (isbn != other.isbn) return false
        if (title != other.title) return false
        if (publisher != other.publisher) return false
        if (authors != other.authors) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + isbn.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + publisher.hashCode()
        result = 31 * result + authors.hashCode()
        return result
    }

    override fun toString(): String {
        return "Book(id=$id, isbn='$isbn', title='$title', publisher=$publisher, authors=$authors)"
    }

}