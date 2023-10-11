package com.smk.cashier.service;

import com.smk.cashier.Model.Barang;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BarangServiceTest {

    @Test
    @Order(2)
    void getBarangList() {
        List<Barang> barangList = BarangService.getInstance().getBarangList();
        assertEquals(barangList.size(),3);

    }

    @Test
    @Order(1)
    void addBarang() {
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        BarangService.getInstance().addBarang(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("MO001");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(100000);
        BarangService.getInstance().addBarang(mouse);

        Barang LaptopGaming = new Barang();
        LaptopGaming.setKodeBarang("B003");
        LaptopGaming.setNamaBarang("Laptop Gaming");
        LaptopGaming.setHargaBarang(20000000);
        BarangService.getInstance().addBarang(LaptopGaming);

    }

    @Test
    @Order(3)
    void findByName(){
        List<Barang> resultList = BarangService .getInstance().findByName("Laptop");
        assertEquals(resultList.size(),2);
    }
}