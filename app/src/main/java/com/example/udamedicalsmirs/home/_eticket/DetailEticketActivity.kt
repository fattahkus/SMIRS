    package com.example.udamedicalsmirs.home._eticket

    import android.annotation.SuppressLint
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import com.example.udamedicalsmirs.R
    import com.example.udamedicalsmirs.home._eticket.data.TicketItem
    import kotlinx.android.synthetic.main.activity_detail_eticket.*

    class DetailEticketActivity : AppCompatActivity() {

        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_detail_eticket)
            val intent = intent.getSerializableExtra("dataTicket") as TicketItem

            tvBookingInfo.text = intent.noBooking.toString()
            tvNameInfo.text = intent.namaPasien.toString()
            tvPhoneInfo.text = intent.noHp.toString()
            tvPeriksaInfo.text = intent.jenisPeriksa.toString()
            tvDokterInfo.text = intent.namaDokter.toString()
            tvWaktuInfo.text = "${intent.waktuPeriksa} 10:00 WIB"
        }
    }
