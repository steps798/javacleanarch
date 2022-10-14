package com.steph.cleanarch.movie.application.port.in.findbytitle;

import java.util.List;

public interface FindByTitleUseCase {

    List<FindByTitleDto> findByTitle(String title);
}
