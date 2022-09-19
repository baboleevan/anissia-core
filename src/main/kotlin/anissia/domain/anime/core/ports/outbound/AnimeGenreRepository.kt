package anissia.domain.anime.core.ports.outbound

import anissia.domain.anime.core.AnimeGenre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AnimeGenreRepository : JpaRepository<AnimeGenre, String>, QuerydslPredicateExecutor<AnimeGenre> {
    fun countByGenreIn(genre: List<String>): Long
}
