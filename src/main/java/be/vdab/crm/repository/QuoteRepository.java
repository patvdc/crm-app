package be.vdab.crm.repository;

import be.vdab.crm.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findAllByContactIdEquals(int contactId);

    Quote findQuoteByContactIdEquals(int contactId);
}
