package com.example.praktikum2.service;

import com.example.praktikum2.model.Ktp;
import com.example.praktikum2.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    public Ktp addKtp(Ktp ktp) {

        if (ktpRepository.existsByNomorKtp(ktp.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return ktpRepository.save(ktp); // Menyimpan data KTP baru ke database

    }
    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }
    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
    }
}



