package be.vdab.crm.service;

import be.vdab.crm.entity.Quote;
import be.vdab.crm.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuoteService {

    @Autowired
    private QuoteRepository repository;

    public List<Quote> getAllQuotes() {  return repository.findAll();  }

    public Quote findQuoteById(int id) {  return repository.getOne(id);  }

    public void save(Quote quote) {  repository.save(quote);  }

    public void delete(int id) {  repository.deleteById(id);  }

    public List<Quote> getAllQuotesByContactId(Integer id) {  return repository.findAllByContactIdEquals(id);
    }
}
