package com.derich.visitkenya.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.derich.visitkenya.R

data class DayDetails(
    @StringRes val dayNumber: Int,
    @StringRes val titleOfActivity: Int,
    @DrawableRes val imageOfDestination: Int,
    @StringRes val destinationDetails: Int
)

object DaysRepo {
    var daysList = listOf<DayDetails>(
        DayDetails(R.string.day_1, R.string.title_1, R.drawable._01_nairobi, R.string.nairobi_01),
        DayDetails(R.string.day_2, R.string.title_2, R.drawable._02_samburu, R.string.samburu_02),
        DayDetails(R.string.day_3, R.string.title_3, R.drawable._03_eldoret, R.string.eldoret_03),
        DayDetails(R.string.day_4, R.string.title_4, R.drawable._04_kakamega, R.string.kakamega_04),
        DayDetails(R.string.day_5, R.string.title_5, R.drawable._05_nakuru, R.string.nakuru_05),
        DayDetails(R.string.day_6, R.string.title_6, R.drawable._06_meru, R.string.meru_06),
        DayDetails(R.string.day_7, R.string.title_7, R.drawable._07_narok, R.string.narok_07),
        DayDetails(R.string.day_8, R.string.title_8, R.drawable._08_mombasa, R.string.mombasa_08),
        DayDetails(R.string.day_9, R.string.title_9, R.drawable._09_kitale, R.string.kitale_09),
        DayDetails(R.string.day_10, R.string.title_10, R.drawable._10_thika, R.string.thika_10),
        DayDetails(R.string.day_11, R.string.title_11, R.drawable._11_kisumu, R.string.kisumu_11),
        DayDetails(R.string.day_12, R.string.title_12, R.drawable._12_giraffe_manor, R.string.giraffe_manor_12),
        DayDetails(R.string.day_13, R.string.title_13, R.drawable._13_amboseli_national_park, R.string.amboseli_national_park_13),
        DayDetails(R.string.day_14, R.string.title_14, R.drawable._14_mt_kenya, R.string.mt_kenya_14),
        DayDetails(R.string.day_15, R.string.title_15, R.drawable._15_lake_victoria, R.string.lake_victoria_15),
        DayDetails(R.string.day_16, R.string.title_16, R.drawable._16_lake_naivasha, R.string.lake_naivasha_16),
        DayDetails(R.string.day_17, R.string.title_17, R.drawable._17_samburu_national_reserve, R.string.samburu_national_reserve_17),
        DayDetails(R.string.day_18, R.string.title_18, R.drawable._18_diani_beach, R.string.diani_beach_18),
        DayDetails(R.string.day_19, R.string.title_19, R.drawable._19_manda_bay, R.string.manda_bay_19),
        DayDetails(R.string.day_20, R.string.title_20, R.drawable._20_the_great_rift_valley, R.string._great_rift_valley_20),
        DayDetails(R.string.day_21, R.string.title_21, R.drawable._21_uhuru_gardens, R.string.uhuru_gardens_21),
        DayDetails(R.string.day_22, R.string.title_22, R.drawable._22_lamu_island, R.string.lamu_island_22),
        DayDetails(R.string.day_23, R.string.title_23, R.drawable._23_wasini_island, R.string.wasini_island_23),
        DayDetails(R.string.day_24, R.string.title_24, R.drawable._24_mount_longonot, R.string.mount_longonot_24),
        DayDetails(R.string.day_25, R.string.title_25, R.drawable._25_hells_gate, R.string.hells_gate_25),
        DayDetails(R.string.day_26, R.string.title_26, R.drawable._26_tsavo_national_park, R.string.tsavo_national_park_26),
        DayDetails(R.string.day_27, R.string.title_27, R.drawable._27_lake_nakuru, R.string.lake_nakuru_27),
        DayDetails(R.string.day_28, R.string.title_28, R.drawable._28_fourteen_falls, R.string.fourteen_falls_28),
        DayDetails(R.string.day_29, R.string.title_29, R.drawable._29_shaba_national_reserve, R.string.shaba_national_reserve_29),
        DayDetails(R.string.day_30, R.string.title_30, R.drawable._30_bufallo_springs, R.string.buffalo_springs_national_reserve_30),
        DayDetails(R.string.day_31, R.string.title_31, R.drawable._31_ol_pejeta, R.string.ol_pejeta_conservancy_31)

    )
}
