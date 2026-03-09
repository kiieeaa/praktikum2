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
    public Ktp updateKtp(Integer id, Ktp detailKtp) {
        Ktp existingKtp = getKtpById(id);

        if (!existingKtp.getNomorKtp().equals(detailKtp.getNomorKtp()) &&
                ktpRepository.existsByNomorKtp(detailKtp.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        existingKtp.setNomorKtp(detailKtp.getNomorKtp());
        existingKtp.setNamaLengkap(detailKtp.getNamaLengkap());
        existingKtp.setAlamat(detailKtp.getAlamat());
        existingKtp.setTanggalLahir(detailKtp.getTanggalLahir());
        existingKtp.setJenisKelamin(detailKtp.getJenisKelamin());

        return ktpRepository.save(existingKtp);
    }
    public void deleteKtp(Integer id) {
        Ktp existingKtp = getKtpById(id);
        ktpRepository.delete(existingKtp);
    }
}




