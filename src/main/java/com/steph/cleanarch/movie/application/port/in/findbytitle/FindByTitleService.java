package com.steph.cleanarch.movie.application.port.in.findbytitle;

import com.steph.cleanarch.movie.application.port.out.gateway.MovieQueryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindByTitleService implements FindByTitleUseCase {

    private final MovieQueryGateway movieQueryGateway;

    @Override
    public List<FindByTitleDto> findByTitle(String title) {
        return movieQueryGateway.findByTitle(title)
            .stream()
            .map(FindByTitleDto::valueOf)
            .collect(Collectors.toList());
    }
}
