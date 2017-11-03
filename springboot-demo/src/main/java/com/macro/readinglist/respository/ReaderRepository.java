package com.macro.readinglist.respository;

import com.macro.readinglist.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhenghong on 2017/11/2.
 */
public interface ReaderRepository extends JpaRepository<Reader,String> {
}
