package com.churchflow.backend.service;

import com.churchflow.backend.dto.MinistryRequestDTO;
import com.churchflow.backend.dto.MinistryResponseDTO;
import com.churchflow.backend.entity.Ministry;
import com.churchflow.backend.repository.MinistryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MinistryService {

    private final MinistryRepository ministryRepository;

    public MinistryService(MinistryRepository ministryRepository) {
        this.ministryRepository = ministryRepository;
    }

    public MinistryResponseDTO createMinistry(MinistryRequestDTO dto) {
        if (ministryRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Já existe um ministério com este nome.");
        }

        Ministry ministry = new Ministry();
        ministry.setName(dto.getName());
        ministry.setDescription(dto.getDescription());
        ministry.setLeaderName(dto.getLeaderName());
        ministry.setStatus(dto.getStatus());

        Ministry savedMinistry = ministryRepository.save(ministry);
        return convertToResponseDTO(savedMinistry);
    }

    public List<MinistryResponseDTO> getAllMinistries() {
        return ministryRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<MinistryResponseDTO> getMinistryById(Long id) {
        return ministryRepository.findById(id)
                .map(this::convertToResponseDTO);
    }

    public MinistryResponseDTO updateMinistry(Long id, MinistryRequestDTO dto) {
        Ministry ministry = ministryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ministério não encontrado."));

        ministry.setName(dto.getName());
        ministry.setDescription(dto.getDescription());
        ministry.setLeaderName(dto.getLeaderName());
        ministry.setStatus(dto.getStatus());

        Ministry updatedMinistry = ministryRepository.save(ministry);
        return convertToResponseDTO(updatedMinistry);
    }

    public void deleteMinistry(Long id) {
        Ministry ministry = ministryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ministério não encontrado."));

        ministryRepository.delete(ministry);
    }

    private MinistryResponseDTO convertToResponseDTO(Ministry ministry) {
        return new MinistryResponseDTO(
                ministry.getId(),
                ministry.getName(),
                ministry.getDescription(),
                ministry.getLeaderName(),
                ministry.getStatus()
        );
    }
}