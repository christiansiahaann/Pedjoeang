package com.prakpapb2.notif

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.prakpapb2.intro1.R

class ReminderBroadcast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        //Ambil data dari intent
        val date = intent?.getIntExtra("date", 0)
        val monthName = intent?.getStringExtra("monthName")
        val name = intent?.getStringExtra("name")
        val image = intent?.getIntExtra("image", 0)

        //Ubah image menjadi bitmap
        val bitmapDrawable = BitmapFactory.decodeResource(context?.resources, image!!)

        //Builder untuk membuat notifikasi
        val builder = NotificationCompat.Builder(context!!, "notifyHariBesar")//channelId harus sama
            .setContentTitle("${date.toString()} $monthName") //Judul
            .setContentText("Memperingati $name") //Deskripsi
            .setSmallIcon(R.drawable.ic_launcher_foreground) //Icon notifikasi (logo app)
            .setLargeIcon(bitmapDrawable) //gambar peringatan hari besar
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmapDrawable))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)

        notificationManager.notify(200, builder.build())
    }
}