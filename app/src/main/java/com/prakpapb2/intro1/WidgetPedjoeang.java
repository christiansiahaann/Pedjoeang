package com.prakpapb2.intro1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.startActivity;
import static com.google.android.material.tabs.TabLayout.*;






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

        configIntent = new Intent(context, Biografi.class);
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


//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
//    {
//        Log.d(TAG, "onUpdate");
//
//        for (int appWidgetId : appWidgetIds)
//        {
//            appWidgetManager.updateAppWidget(appWidgetId, views);
//        }
//
//    /* An updateAppWidget functions looks like as:
//
//    Intent intent = new Intent(context, UpdateWidgetService.class);
//    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
//    context.startService(intent);
//    */
//
//        Intent intent = new Intent(context, DaftarPahlawanKebangkitan.class);
//        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
//
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_pedjoeang);
//
//        views.setOnClickPendingIntent(R.id.button_widget, pendingIntent);
//
//        ComponentName componentName = new ComponentName(context.getPackageName(), WidgetPedjoeang.class.getName());
//
//        appWidgetManager.updateAppWidget(componentName, views);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//}
//    private static final String ACTION_CLICK = "ACTION_CLICK";

//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_pedjoeang);
//        Intent configIntent = new Intent(context, WidgetPedjoeang.class);
//
//        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
//
//        remoteViews.setOnClickPendingIntent(R.id.button_widget, configPendingIntent);
//        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//}


//    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
//                                int appWidgetId) {
//
////        CharSequence widgetText = context.getString(R.string.appwidget_text);
//        // Construct the RemoteViews object
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_pedjoeang);
////        views.setTextViewText(R.id.appwidget_text, widgetText);
//
//        // Instruct the widget manager to update the widget
//        appWidgetManager.updateAppWidget(appWidgetId, views);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button_widget:
//                Intent explicit = new Intent(WidgetPedjoeang.this, MainActivity.class);
//                startActivity(explicit);
//                break;
//        }
//    }
//}
//





//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//                case R.id.explicitintent:
//                    Intent explicit = new Intent(PageOne.this, PageTwo.class);
//                    startActivity(explicit);
//                    break;
//                case R.id.implicitintent:
//                    Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.codepolitan.com"));
//                    startActivity(implicit);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//
//
//
//
//
//
//
//
//


//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        // There may be multiple widgets active, so update all of them
//        for (int appWidgetId : appWidgetIds) {
//            updateAppWidget(context, appWidgetManager, appWidgetId);
//        }
//    }
//
//    @Override
//    public void onEnabled(Context context) {
//        // Enter relevant functionality for when the first widget is created
//    }
//
//    @Override
//    public void onDisabled(Context context) {
//        // Enter relevant functionality for when the last widget is disabled
//    }



//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.widget_pedjoeang);
//
//        Button buttonWidget = findViewById(R.id.button_widget);
//        buttonWidget.setOnClickListener(this);
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.widget_pedjoeang);
//
//        ImageView ivIrSoekarno = findViewById(R.id.iv_ir_soekarno);
//        ivIrSoekarno.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button_widget:
//                Intent moveIntent = new Intent(WidgetPedjoeang.this, MainActivity.class);
//                startActivity(moveIntent);
//                break;
//        }
//        switch (v.getId()) {
//            case R.id.iv_ir_soekarno:
//                Intent moveIntent = new Intent(WidgetPedjoeang.this, DaftarPahlawanKebangkitan.class);
//                startActivity(moveIntent);
//                break;
//        }
//    }
//
//}
//
//    private void startActivity(Intent moveIntent) {
//        case R.id.button_widget:
//        Intent moveIntent = new Intent(WidgetPedjoeang.this, MainActivity.class);
//        startActivity(moveIntent);
////        break;
//    }
//}