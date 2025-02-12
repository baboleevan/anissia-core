package anissia.dto

import anissia.rdb.entity.Anime


data class AnimeDto (
    var animeNo: Long = 0,
    var status: String = "",
    var week: String = "",
    var time: String = "",
    var subject: String = "",
    var originalSubject: String = "",
    var captionCount: Int = 0,
    var genres: String = "",
    var startDate: String = "",
    var endDate: String = "",
    var website: String = "",
    var twitter: String = "",
    var captions: List<AnimeCaptionDto> = emptyList()
) {
    constructor(anime: Anime, includeCaption: Boolean = false): this(
        animeNo = anime.animeNo,
        status = anime.status.toString(),
        week = anime.week,
        time = anime.time,
        subject = anime.subject,
        originalSubject = anime.originalSubject,
        captionCount = anime.captionCount,
        genres = anime.genres,
        startDate = anime.startDate,
        endDate = anime.endDate,
        website = anime.website,
        twitter = anime.twitter,
        captions = if (includeCaption) anime.captions.map { AnimeCaptionDto(it) } else emptyList()
    )
}

