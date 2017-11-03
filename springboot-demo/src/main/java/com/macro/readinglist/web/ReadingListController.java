package com.macro.readinglist.web;

import com.macro.readinglist.component.AmazonProperties;
import com.macro.readinglist.respository.ReadingListRepository;
import com.macro.readinglist.domain.Book;
import com.macro.readinglist.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by zhenghong on 2017/11/1.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    @Autowired
    private ReadingListRepository readingListRepository;
    @Autowired
    private AmazonProperties amazonProperties;
    @Autowired
    private CounterService counterService;
    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(method = RequestMethod.GET, value = "/fail")
    public void fail() {
        throw new RuntimeException();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String error() {
        return "error";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> bookList = readingListRepository.findByReader(reader);
        if (bookList != null) {
            model.addAttribute("books", bookList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        counterService.increment("books.saved");
        gaugeService.submit("books.last.saved",System.currentTimeMillis());
        return "redirect:/";
    }
}
