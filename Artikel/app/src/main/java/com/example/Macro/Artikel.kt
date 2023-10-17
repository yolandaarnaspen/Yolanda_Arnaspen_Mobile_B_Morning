package com.example.Macro.Artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import com.example.artikel.R

class Artikel : AppCompatActivity() {
    private lateinit var textViewForYou: TextView
    private lateinit var textViewRecommendation: TextView
    private lateinit var textViewTranding: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        textViewForYou = findViewById(R.id.textViewForYou)
        textViewRecommendation = findViewById(R.id.textViewRecommendation)
        textViewTranding = findViewById(R.id.textViewTranding)

        textViewForYou.setOnClickListener {
            updateUnderline(textViewForYou)
            resetUnderline(textViewRecommendation, textViewTranding)
        }

        textViewRecommendation.setOnClickListener {
            updateUnderline(textViewRecommendation)
            resetUnderline(textViewForYou, textViewTranding)
        }

        textViewTranding.setOnClickListener {
            updateUnderline(textViewTranding)
            resetUnderline(textViewForYou, textViewRecommendation)
        }
        data class Artikel(val imageRes: Int, val title: String, val publisher: String, val date: String)
        // Set data for Artikel
        val artikelList = listOf(
            Artikel(R.drawable.artikel1, "Pentingnya Pendidikan Bagi Masa Depan", "Oleh : Dispendik Mojokerto", "15 Agustus 2023"),
            Artikel(R.drawable.artikel2, "8 Cara Membuat Katalog Online untuk Tingkat Bisnis", "Oleh : Redaksi Jagoan Hosting", "15 Agustus 2023"),
            Artikel(R.drawable.artikel4, "Para Penerima Beasiswa Amanah Bangun Desa Telah Memasuki Tahap Implementasi Proyek", "Oleh : Kompasiana", "15 Agustus 2023"),
            Artikel(R.drawable.artikel5, "LazisMu UMS Berikan Beasiswa Hingga Lulus", "Oleh : Dispendik Mojokerto", "15 Agustus 2023"),
            Artikel(R.drawable.artikel6, "Pengumuman Pendaftaran Pewawancara Seleksi Beasiswa Indonesia Bangkit 2023", "Oleh : Dispendik Mojokerto", "15 Agustus 2023"),
            Artikel(R.drawable.artikel7, "Pengumuman Pendaftaran Pewawancara Seleksi Beasiswa Indonesia Bangkit 2023", "Oleh : Dispendik Mojokerto", "15 Agustus 2023")
        )

        setArtikel(artikelList)
    }

    private fun updateUnderline(textView: TextView) {
        val content = SpannableString(textView.text)
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        textView.text = content
    }

    private fun resetUnderline(vararg textViews: TextView) {
        textViews.forEach {
            it.text = removeUnderline(it)
        }
    }

    private fun removeUnderline(textView: TextView): CharSequence {
        val content = SpannableString(textView.text)
        content.removeSpan(UnderlineSpan())
        return content
    }

    private fun setArtikel(artikelList: List<Artikel>) {
        for ((index, artikel) in artikelList.withIndex()) {
            val imageView: ImageView = findViewById(resources.getIdentifier("imageView${index + 1}", "id", packageName))
            val textViewTitle = findViewById<TextView>(resources.getIdentifier("textViewTitle${index + 1}", "id", packageName))
            val textViewPublisher = findViewById<TextView>(resources.getIdentifier("textViewPublisher${index + 1}", "id", packageName))
            val textViewDate = findViewById<TextView>(resources.getIdentifier("textViewDate${index + 1}", "id", packageName))
            val imageViewShare: ImageView = findViewById(resources.getIdentifier("imageViewShare${index + 1}", "id", packageName))

            val artikel
            imageView.setImageResource(artikel.imageRes)
            textViewTitle.text = artikel.title
            textViewPublisher.text = artikel.publisher
            textViewDate.text = artikel.date
        }
    }
}