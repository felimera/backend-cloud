package com.project.appshopping.repository;

import com.project.appshopping.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomerId(Long customerId);

    Invoice findByNumberInvoice(String numberInvoice);
}
