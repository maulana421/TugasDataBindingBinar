package com.example.beritadatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beritadatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var dataBeritaViewModel: DataBeritaViewModel
    private lateinit var dataBeritaAdapter: DataBeritaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        dataBeritaViewModel = ViewModelProvider(this)[DataBeritaViewModel::class.java]
//        binding.lifecycleOwner = this

        val databerita = mutableListOf(
            DataBerita(" Viral Tendangan 'Kung-fu' Marcos Rojo di Superclasico Argentina","13 sep 2022","Bayu Baskoro",R.drawable.marcos_rojo,"Marcos Rojo diusir wasit dalam pertandingan Superclasico Argentina. Eks bek Manchester United itu melakukan tendangan 'kung-fu' ke arah lawan.\n" +
                    "\n" + "Rojo sudah dua musim berkarier di Argentina setelah meninggalkan MU pada 2021. Bek 32 tahun itu saat ini membela salah satu tim raksasa Argentina, Boca Juniors.\n"),
            DataBerita("Polisi Kanada Ditembak Mati di Toronto","13 sep 2022","Lisye Sri Rahayu",R.drawable.canada_crime_stabbing,"Toronto - Seorang petugas kepolisian Kanada ditembak mati di Toronto. Kematian ini seperti ini jarang terjadi bagi seorang penegak hukum di negara itu.\n" +
                    "\n" + "Dilansir AFP, Selasa (13/9/2022) dua orang juga terluka dalam kejahatan itu, yang mana seorang penembak melepaskan tembakan di dua lokasi terpisah sebelum ditangkap."),
            DataBerita("Klopp Punya Jasa Besar, Liverpool Dinilai Tak Akan Memecatnya","13 sep 2022","Adhi Prasetya",R.drawable.juergen_klopp_169,"Jakarta - Liverpool tak memulai musim ini dengan baik. Namun memecat Juergen Klopp dinilai tak akan menyelesaikan masalah.\n" +
                    "\n" + "The Reds baru meraih dua kemenangan dalam enam laga Premier League yang sudah dijalani musim ini. Di Liga Champions, mereka mencatat hasil memalukan usai disikat Napoli 1-4 di laga pertama."),
            DataBerita("Apa Arti Nama Bjorka, Hacker yang Serang Indonesia","13 sep 2022","Fino Yurio Kristo",R.drawable.bjorka,"Jakarta - Hacker dengan nama online Bjorka masih terus beraksi di Indonesia membobol data-data penting. Sebenarnya, apa arti nama Bjorka?\n" +
                    "\n" + "Sejauh ini, belum diketahui siapa Bjorka dan ada di mana, apakah di dalam atau luar negeri. Di akun Twitter, ia menuliskan lokasi di Warsawa yang adalah ibu kota Polandia. Namun tentu tak dapat dipastikan apakah dia benar-benar berada di sana."),
            DataBerita("Saham Ini Sukses Kasih Cuan Gede, Tapi Sebagian Bikin Tongpes","13 sep 2022","Chandra Dewi",R.drawable.berita_saham,"Jakarta, CNBC Indonesia - Indeks Harga Saham Gabungan (IHSG) berhasil ditutup di zona hijau pada perdagangan Senin (12/9/2022) kemarin, setelah sempat terkoreksi pada perdagangan sesi I.\n" +
                    "\n" + "Menurut data dari Bursa Efek Indonesia (BEI), indeks bursa saham acuan Tanah Air tersebut ditutup menguat 0,16% ke posisi 7.254,46. IHSG mampu bertahan di zona psikologisnya di 7.200."),
            DataBerita("Dugaan Terima Suap Rp 1 M Bikin Gubernur Lukas Enembe Jadi Tersangka KPK","13 sep 2022","Ladi Marina",R.drawable.gubernur_lukas,"Jakarta - Pengacara menyebut Gubernur Papua Lukas Enembe telah ditetapkan tersangka oleh KPK. Lukas menjadi tersangka terkait kasus dugaan suap dan gratifikasi Rp 1 miliar."),
            DataBerita("Kisah Abigail Johnson, dari Kerja Part Time Kini Jadi Wanita Terkaya di Dunia","13 sep 2022","Aulia Damayanti",R.drawable.abigail_johnson_169,"Jakarta - Wanita juga tidak kalah dalam mencari pundi-pundi uang, bahkan bisa menjadi wanita terkaya di dunia. Seperti Abigail Johnson yang selalu masuk dalam jajaran wanita terkaya di dunia versi Forbes.\n" +
                    "\n" + "Pemilik nama lengkap Abigail Pierrepont Johnson merupakan CEO Fidelity Investments, sebuah perusahaan jasa keuangan besar di Amerika Serikat (AS)."),
            DataBerita("Pengacara Bantah Putri Candrawathi Ikut Tembak Brigadir Yosua","13 sep 2022","Dwi Andayani",R.drawable.putri_candrawathi_169,"Jakarta - Ketua Komnas HAM Ahmad Taufan Damanik memberi penjelasan soal kemungkinan adanya orang lain menembak Brigadir Nopriansyah Yosua Hutabarat atau Brigadir J. Kemungkinan itu termasuk dugaan istri Irjen Ferdy Sambo," +
                    " Putri Candrawathi, ikut menembak Yosua. Pihak Putri Candrawathi, Arman Hanis, membantah dugaan tersebut."),
            DataBerita("Doa Terhindar dari Siksa Kubur, Dibaca Sebelum Salam saat Sholat","13 sep 2022","Rahma harbani",R.drawable.ilustrasi_berdoa,"Jakarta - Salah satu bekal yang dapat dibawa muslim di alam kubur kelak adalah bacaan doa terhindar dari siksa kubur. Bacaan doa tersebut dapat dinukil dari sejumlah keterangan hadits Rasulullah SAW.\n" +
                    "\n" + "Di samping berisi permohonan agar terhindar dari siksaan kubur, doa agar terhindar dari siksa kubur juga dapat menjadi bekal amal sholeh yang setia mengiringi muslim pada akhir hayatnya."),
            DataBerita("Pengajar PAUD, Pesantren & Pendidikan Kesetaraan Bakal Diakui sebagai Guru","13 sep 2022","Nikita Rosa",R.drawable.ilustrasi_berdoa,"Jakarta - Menteri Pendidikan, Kebudayaan, Riset, dan Teknologi (Mendikbudristek) Nadiem Makarim, mengatakan bahwa pengajar PAUD, pesantren, dan pendidikan kesetaraan akan diakui sebagai guru dalam RUU Sisdiknas. " +
                    "Hal ini ia sampaikan dalam dialog Kupas Tuntas RUU Sisdiknas yang ditayangkan pada YouTube Kemendikbud RI."),
        )
        dataBeritaAdapter = DataBeritaAdapter(databerita,object : DataBeritaAdapter.MyClick{
            override fun onClick(dataBerita: DataBerita) {
                startActivity(Intent(this@MainActivity,DetailBeritaActivity::class.java).also {
                    it.putExtra("berita",dataBerita)
                })
            }

        })
        binding.rvmain.apply {
            adapter = dataBeritaAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }


}