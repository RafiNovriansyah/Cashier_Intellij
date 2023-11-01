package com.smk.cashier.service;

import com.smk.cashier.dao.StokDao;
import com.smk.cashier.dao.StokDao;
import com.smk.cashier.dao.StokDao;
import com.smk.cashier.Model.Stok;
import com.smk.cashier.Model.Stok;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {
    @Test
    @Order(1)
    void saveToDB() {
        StokDao dao = new StokDao();

        Stok laptop = new Stok();
        laptop.setKodeBarang("B001");
        laptop.setStokBarang(10);
        laptop.setDateCreated(new Date());
        laptop.setLastModified(new Date());
        dao.save(laptop);

        Stok mouse = new Stok();
        mouse.setKodeBarang("B002");
        mouse.setStokBarang(15);
        mouse.setDateCreated(new Date());
        mouse.setLastModified(new Date());
        dao.save(mouse);

        Stok gamingLaptop = new Stok();
        laptop.setKodeBarang("B003");
        laptop.setStokBarang(5);
        laptop.setDateCreated(new Date());
        laptop.setLastModified(new Date());
        dao.save(laptop);
    }

    @Test
    @Order(2)
    void getById() {
        StokDao dao = new StokDao();
        Optional<Stok> s1 = dao.get(1);
        s1.ifPresent(new Consumer<Stok>() {
            @Override
            public void accept(Stok stock) {
                assertEquals("B001", stock.getKodeBarang());
                assertEquals(10, stock.getStokBarang());
            }
        });

        Optional<Stok> s2 = dao.get(2);
        s2.ifPresent(new Consumer<Stok>() {
            @Override
            public void accept(Stok stock) {
                assertEquals("B002", stock.getKodeBarang());
                assertEquals(15, stock.getStokBarang());
            }
        });

        Optional<Stok> s3 = dao.get(3);
        s3.ifPresent(new Consumer<Stok>() {
            @Override
            public void accept(Stok stock) {
                assertEquals("B003", stock.getKodeBarang());
                assertEquals(5, stock.getStokBarang());
            }
        });
    }

}