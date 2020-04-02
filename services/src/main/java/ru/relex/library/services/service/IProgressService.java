package ru.relex.library.services.service;

import ru.relex.library.services.dto.user.ProgressDto;

import javax.validation.Valid;
import java.util.List;

public interface IProgressService {

    List<ProgressDto> findProgress(String search);

    ProgressDto findById(int id);

    ProgressDto create(@Valid ProgressDto progressDto);

    void remove(int progressId);
}
