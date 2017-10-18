package com.anychart.sample.charts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.EnumsAlign;
import com.anychart.anychart.LegendLayout;
import com.anychart.anychart.Pyramid;
import com.anychart.anychart.TextParsingMode;
import com.anychart.anychart.UiLegend;
import com.anychart.sample.R;

public class PyramidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);

        Pyramid pyramid = AnyChart.pyramid();
        pyramid.setData(new String[] {
                "{name: 'TV promotion', value: 6371664}",
                "{name: 'Radio promotion', value: 7216301}",
                "{name: 'Advertising leaflets', value: 1486621}",
                "{name: 'Before advertising started', value: 1386622}"
        }, TextParsingMode.CSV);

        UiLegend legend = pyramid.getLegend();
        legend.setEnabled(true);
        legend.setPosition("'outside-right'");
        legend.setItemsLayout(LegendLayout.VERTICAL);
        legend.setAlign(EnumsAlign.TOP);

        pyramid.setLabels(false);

        anyChartView.setChart(pyramid);
    }
}
