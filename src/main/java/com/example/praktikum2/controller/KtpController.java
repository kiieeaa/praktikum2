package com.example.praktikum2.controller;

import com.example.praktikum2.model.Ktp;
import com.example.praktikum2.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*") // Penting untuk koneksi ke Frontend
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<?> createKtp(@RequestBody Ktp ktp) {
        try {
            return ResponseEntity.ok(ktpService.addKtp(ktp));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Ktp>> getAllKtp() {
        return ResponseEntity.ok(ktpService.getAllKtp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKtpById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ktpService.getKtpById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKtp(@PathVariable Integer id, @RequestBody Ktp ktp) {
        try {
            return ResponseEntity.ok(ktpService.updateKtp(id, ktp));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKtp(@PathVariable Integer id) {
        try {
            ktpService.deleteKtp(id);
            return ResponseEntity.ok("Data berhasil dihapus");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}