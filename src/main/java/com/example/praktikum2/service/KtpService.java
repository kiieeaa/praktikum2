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
}