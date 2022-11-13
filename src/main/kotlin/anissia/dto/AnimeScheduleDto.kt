package anissia.dto

import anissia.rdb.entity.Anime

data class AnimeScheduleDto (
    var animeNo: Long = 0,
    var week: String = "",
    var status: String = "",
    var time: String = "",
    var subject: String = "",
    var originalSubject: String = "",
    var genres: String = "",
    var captionCount: Int = 0,
    var startDate: String = "",
    var endDate: String = "",
    var website: String = "",
) {
    constructor(anime: Anime): this(
        week = anime.week,
        animeNo = anime.animeNo,
        status = anime.status.toString(),
        time = if (!anime.week.matches("7|8".toRegex())) anime.time else anime.startDate,
        subject = anime.subject,
        originalSubject = anime.originalSubject,
        genres = anime.genres,
        captionCount = anime.captionCount,
        startDate = anime.startDate,
        endDate = anime.endDate,
        website = anime.website
    )
}
