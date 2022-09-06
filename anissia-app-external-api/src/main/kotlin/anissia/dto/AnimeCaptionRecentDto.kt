package anissia.dto

import anissia.rdb.entity.AnimeCaption
import anissia.misc.As

data class AnimeCaptionRecentDto (
        var animeNo: Long = 0,
        var subject: String = "",
        var episode: String = "",
        var updDt: String = "",
        var website: String = "",
        var name: String = ""
) {
        constructor(animeCaption: AnimeCaption): this(
                animeNo = animeCaption.anime?.animeNo?:0,
                subject = animeCaption.anime!!.subject,
                episode = animeCaption.episode,
                updDt = animeCaption.updDt.format(As.DTF_ISO_CAPTION) + ":00",
                website = animeCaption.website,
                name = animeCaption.account!!.name
        )
}
