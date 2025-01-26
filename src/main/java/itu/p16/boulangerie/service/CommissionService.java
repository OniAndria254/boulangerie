package itu.p16.boulangerie.service;

import itu.p16.boulangerie.dto.CommissionGenreDTO;
import itu.p16.boulangerie.dto.CommissionVendeurDTO;
import itu.p16.boulangerie.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public List<CommissionVendeurDTO> getCommissionsVendeursBetweenDates(LocalDate startDate, LocalDate endDate) {
        // Convertir LocalDate en java.sql.Date
        java.sql.Date sqlStartDate = (startDate != null) ? java.sql.Date.valueOf(startDate) : null;
        java.sql.Date sqlEndDate = (endDate != null) ? java.sql.Date.valueOf(endDate) : null;

        return commissionRepository.findCommissionsVendeursBetweenDates(sqlStartDate, sqlEndDate);
    }

    public List<CommissionGenreDTO> getCommissionsGenresBetweenDates(LocalDate startDate, LocalDate endDate) {
        // Convertir LocalDate en java.sql.Date
        java.sql.Date sqlStartDate = (startDate != null) ? java.sql.Date.valueOf(startDate) : null;
        java.sql.Date sqlEndDate = (endDate != null) ? java.sql.Date.valueOf(endDate) : null;

        return commissionRepository.findCommissionsGenresBetweenDates(sqlStartDate, sqlEndDate);
    }

}