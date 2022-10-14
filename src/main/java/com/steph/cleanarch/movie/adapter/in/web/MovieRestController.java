package com.steph.cleanarch.movie.adapter.in.web;

import com.steph.cleanarch.common.constant.Routes;
import com.steph.cleanarch.movie.application.port.in.findbytitle.FindByTitleDto;
import com.steph.cleanarch.movie.application.port.in.findbytitle.FindByTitleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieRestController {

    private final FindByTitleUseCase findByTitleUseCase;

    @GetMapping(Routes.MOVIE)
    public List<FindByTitleDto> findMovies(@RequestParam("title") String title) {
        return findByTitleUseCase.findByTitle(title);
    }
}
