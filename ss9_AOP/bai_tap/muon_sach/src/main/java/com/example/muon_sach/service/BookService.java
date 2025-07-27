package com.example.muon_sach.service;

import com.example.muon_sach.entity.Book;
import com.example.muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
@Override
  public List<Book> findAll(){
     return bookRepository.findAll();
  }
  @Override
  public Book findById(String id){
      return bookRepository.findById(id).orElse(null);
  }
  @Override
  public void add(Book book){
      Book lastBook= bookRepository.findTopByOrderByBookIdDesc();
      String newId="MS-001";
      if(lastBook!=null){
          String lastId=lastBook.getBookId();
          int number=Integer.parseInt(lastId.substring(3));
          number++;
          newId=String.format("MS-%03d",number);
      }
      book.setBookId(newId);
      if(book.getBookId()==null||findById(book.getBookId())==null){
          bookRepository.save(book);
      }
  }
  @Override
  public String randomBorrowCode(){
      int number =(int) (Math.random()*10000);
      return String.format("%05d",number);

  }
  @Override
  public void update(Book book){
      if(book.getBookId()!=null|| findById(book.getBookId())!=null){
          bookRepository.save(book);
      }
  }

}
