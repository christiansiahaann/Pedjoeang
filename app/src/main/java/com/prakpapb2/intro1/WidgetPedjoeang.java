package com.prakpapb2.intro1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import static com.prakpapb2.intro1.Biografi.EXTRA_PAHLAWAN;
import static com.prakpapb2.utils.DataPahlawan.getListDataPahlawan;

/**
 * Implementation of App Widget functionality.
 */

public class WidgetPedjoeang extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_pedjoeang);
        Intent configIntent = new Intent(context, MainActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

        remoteViews.setOnClickPendingIntent(R.id.button_widget, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        configIntent = new Intent(context, DaftarPahlawanKebangkitan.class);
        configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
        remoteViews.setOnClickPendingIntent(R.id.iv_ir_soekarno, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        configIntent = new Intent(context, DaftarPahlawanEmansipasi.class);
        configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
        remoteViews.setOnClickPendingIntent(R.id.iv_ra_kartini, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        configIntent = new Intent(context, DaftarPahlawanKebangkitan.class);
        configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
        remoteViews.setOnClickPendingIntent(R.id.iv_dr_soetomo, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

    }
}
