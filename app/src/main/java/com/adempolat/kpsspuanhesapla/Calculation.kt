package com.adempolat.kpsspuanhesapla


class Calculation {

    var s_sapma_a : Double = 0.0


    fun lisansForMemur(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int): Double{
        val k_net_gk = 60 - (gk_dogru-(gk_yanlis/4))
        val k_net_gy = 60 - (gy_dogru-(gy_yanlis/4))

        val gy_herYanlis_p1 = 0.625
        val gy_herYanlis_p2 = 0.550
        val gy_herYanlis_p3 = 0.470

        val gk_herYanlis_p1 = 0.215
        val gk_herYanlis_p2 = 0.295
        val gk_herYanlis_p3 = 0.480

        val genelYetenek_p1 = k_net_gy * gy_herYanlis_p1
        val genelYetenek_p2 = k_net_gy * gy_herYanlis_p2
        val genelYetenek_p3 = k_net_gy * gy_herYanlis_p3

        val genelKultur_p1 = k_net_gk * gk_herYanlis_p1
        val genelKultur_p2 = k_net_gk * gk_herYanlis_p2
        val genelKultur_p3 = k_net_gk * gk_herYanlis_p3

        val kpssP1 = 100 - (genelYetenek_p1+genelKultur_p1)
        val kpssP2 = 100 - (genelYetenek_p2+genelKultur_p2)
        val kpssP3 = 100 - (genelYetenek_p3+genelKultur_p3)

        return kpssP1

    }

    fun lisansForOgretmen(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int, eb_dogru: Int, eb_yanlis: Int): Double{
        val ogr=1.0
        return ogr
    }

    fun lisansForOabt(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int, eb_dogru: Int, eb_yanlis: Int, a_dogru: Int, a_yanlis: Int, itemStatu: String): Double{
        val k_net_gk = gk_dogru-(gk_yanlis/4)
        val k_net_gy = gy_dogru-(gy_yanlis/4)
        val k_net_eb = eb_dogru-(eb_yanlis/4)
        val k_net_a = a_dogru-(a_yanlis/4)

        // 2018 verisi
        val tb_net_gk = 56.25
        val tb_net_gy = 56.25
        val tb_net_eb = 56.25
        val tb_net_a = 56.25

        // 2018 verisi
        val s_sapma_gk = 10.262
        val s_sapma_gy = 10.312
        val s_sapma_eb = 14.554

        //Türkçe için
        when(itemStatu){
            "Türkçe" -> s_sapma_a = 7.138
            "Matematik (İlköğretim)" -> s_sapma_a = 5.219
            "Fen Bilimleri ve Teknoloji" -> s_sapma_a = 5.595
            "Sosyal Bilimler" -> s_sapma_a = 7.060
            "Türk Dili ve Edebiyatı" -> s_sapma_a = 8.414
            "Tarih" -> s_sapma_a = 8.868
            "Coğrafya" -> s_sapma_a = 7.762
            "Matematik (Lise)" -> s_sapma_a = 6.883
            "Fizik" -> s_sapma_a = 10.067
            "Kimya" -> s_sapma_a = 7.304
            "Biyoloji" -> s_sapma_a = 7.685
            "Din Kültürü ve Ahlak Bilgisi" -> s_sapma_a = 6.368
            "Yabancı Dil (İngilizce)" -> s_sapma_a = 9.277
            "Rehber Öğretmen" -> s_sapma_a = 7.491
            "Sınıf Öğretmenliği" -> s_sapma_a = 5.705
            "Okul Öncesi Öğretmenliği" -> s_sapma_a = 6.567
        }

        // 2018 verisi
        val o_net_gk = 19.187
        val o_net_gy = 23.506
        val o_net_eb = 38.986
        val o_net_a = 27.435

        val k_spuan_gk = ((k_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val k_spuan_gy = ((k_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val k_spuan_eb = ((k_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50
        val k_spuan_a = ((k_net_a - o_net_a) / s_sapma_a) * 10 + 50

        val b_spuan_gk = ((tb_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val b_spuan_gy = ((tb_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val b_spuan_eb = ((tb_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50
        val b_spuan_a = ((tb_net_a - o_net_a) / s_sapma_a) * 10 + 50

        val k_asp_gk_gy = k_spuan_gk * (0.15) + k_spuan_gy * (0.15) + k_spuan_eb * (0.2) + k_spuan_a * (0.4)
        val b_asp_gk_gy = b_spuan_gk * (0.15) + b_spuan_gy * (0.15) + b_spuan_eb * (0.2) + b_spuan_a * (0.4)

        val tahmini_s_sapma_ort_gk_gy = 8.125
        val tahmini_asp_ort_gk_gy = 49.992

        val p121_puan = 70 + ((30 * (2 * (k_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy)) /
                (2 * (b_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy))

        return p121_puan
    }

    fun onlisans(){

    }

    fun ortaogretim(){

    }
}