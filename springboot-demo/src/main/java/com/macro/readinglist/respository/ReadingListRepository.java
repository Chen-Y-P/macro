package com.macro.readinglist.respository;

import com.macro.readinglist.domain.Book;
import com.macro.readinglist.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhenghong on 2017/11/1.
 */
public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(Reader reader);
}
