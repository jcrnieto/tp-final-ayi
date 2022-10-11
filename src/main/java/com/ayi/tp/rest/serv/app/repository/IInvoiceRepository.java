package com.ayi.tp.rest.serv.app.repository;

import com.ayi.tp.rest.serv.app.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
