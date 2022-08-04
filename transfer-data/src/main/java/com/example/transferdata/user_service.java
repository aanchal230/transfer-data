package com.example.transferdata;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class user_service {
    @Autowired
    UserRepository repository;

    public void save(MultipartFile file) {
        try {
            List<User> tutorials = CSVhelper.csvToTutorials(file.getInputStream());

                repository.saveAll(tutorials);

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

//    public void save(MultipartFile) {
////        Customer customer = customerRepository.getCustomerByIdAndUserRole(id, "customer");
//        List<user> tutorials = CSVhelper.csvToTutorials(file.getInputStream());
//        if (repository == null) throw new NotFoundException(id);
//        repository.saveAll(tutorials);
//    }
//    public void save(MultipartFile file) {
//        try {
//            List<user> tutorials = CSVhelper.csvToTutorials(file.getInputStream());
//            repository.saveAll(tutorials);
//        } catch (IOException e) {
//            throw new RuntimeException("fail to store csv data: " + e.getMessage());
//        }
//    }

    public ByteArrayInputStream load() {
        List<User> tutorials = repository.findAll();

        ByteArrayInputStream in = CSVhelper.dataToCSV(tutorials);
        return in;
    }

    public List<User> getAlldata() {
        return repository.findAll();
    }
}
