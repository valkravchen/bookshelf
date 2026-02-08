package com.dobrynya.bookshelf.service;

import com.dobrynya.bookshelf.dto.BookCreateDTO;
import com.dobrynya.bookshelf.dto.BookResponseDTO;
import com.dobrynya.bookshelf.exception.BookNotFoundException;
import com.dobrynya.bookshelf.mapper.BookMapper;
import com.dobrynya.bookshelf.model.Book;
import com.dobrynya.bookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookResponseDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toResponseDTOList(books);
    }

    public BookResponseDTO findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toResponseDTO(book);
    }

    public BookResponseDTO save(BookCreateDTO dto) {
        Book book = bookMapper.toEntity(dto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponseDTO(savedBook);
    }

    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    public BookResponseDTO update(Long id, BookCreateDTO dto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookMapper.updateEntity(book, dto);
        Book updateBook = bookRepository.save(book);
        return bookMapper.toResponseDTO(updateBook);
    }

    public List<BookResponseDTO> searchByTitle(String keyword) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(keyword);
        return bookMapper.toResponseDTOList(books);
    }

    public List<BookResponseDTO> findByAuthorId(Long authorId) {
        List<Book> books = bookRepository.findByAuthors_Id(authorId);
        return bookMapper.toResponseDTOList(books);
    }

    public List<BookResponseDTO> findByAuthorName(String authorName) {
        List<Book> books = bookRepository.findByAuthors_NameContainingIgnoreCase(authorName);
        return bookMapper.toResponseDTOList(books);
    }

    public List<BookResponseDTO> findByTagId(Long tagId) {
        List<Book> books = bookRepository.findByTags_Id(tagId);
        return bookMapper.toResponseDTOList(books);
    }

    public List<BookResponseDTO> findByTagName(String tagName) {
        List<Book> books = bookRepository.findByTags_NameContainingIgnoreCase(tagName);
        return bookMapper.toResponseDTOList(books);
    }
}
