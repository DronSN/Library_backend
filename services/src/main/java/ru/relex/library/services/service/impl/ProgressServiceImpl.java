package ru.relex.library.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.ProgressMapper;
import ru.relex.library.services.dto.user.ProgressDto;
import ru.relex.library.services.mapstruct.ProgressStruct;
import ru.relex.library.services.service.IProgressService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated

public class ProgressServiceImpl implements IProgressService{

    private final ProgressMapper progressMapper;
    private final ProgressStruct progressStruct;

    @Autowired
    public ProgressServiceImpl(ProgressMapper progressMapper, ProgressStruct progressStruct) {
        this.progressMapper = progressMapper;
        this.progressStruct = progressStruct;
    }

    @Override
    public List<ProgressDto> findProgress(final String search) {
        var progress = progressMapper.getProgress(search);
        return progressStruct.toDto(progress);
    }

    @Override
    public ProgressDto findById(int id) {
        var progress = progressMapper.findById(id);
        return progressStruct.toDto(progress);
    }

    @Override
    public ProgressDto create(@Valid final ProgressDto progressDto) {
        var progress = progressStruct.fromDto(progressDto);
        progressMapper.insert(progress);
        return progressStruct.toDto(progress);
    }

    @Override
    public void remove(final int progressId) {
        progressMapper.delete(progressId);
    }
}
