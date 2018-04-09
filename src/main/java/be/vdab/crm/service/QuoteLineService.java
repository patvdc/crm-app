package be.vdab.crm.service;

import be.vdab.crm.entity.QuoteLine;
import be.vdab.crm.repository.QuoteLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuoteLineService {

    @Autowired
    QuoteLineRepository repository;

    public void save(QuoteLine q) { repository.save(q);}
}
