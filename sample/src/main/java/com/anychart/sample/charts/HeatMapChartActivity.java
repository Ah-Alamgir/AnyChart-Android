package com.anychart.sample.charts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.HeatMap;
import com.anychart.anychart.SelectionMode;
import com.anychart.anychart.SolidFill;
import com.anychart.anychart.Stroke;
import com.anychart.anychart.TextParsingMode;
import com.anychart.sample.R;

public class HeatMapChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);

        HeatMap riskMap = AnyChart.heatMap();

        riskMap.setStroke("'#fff'", 1d, null, null, null);
        riskMap.getHovered()
                .setStroke("'#fff'", 6d, null, null, null)
                .setFill(new SolidFill("'#545f69'", 1d))
                .setLabels("{'fontColor': '#fff'}");

        riskMap.getInteractivity().setSelectionMode(SelectionMode.NONE);

        riskMap.getTitle().setEnabled(true);
        riskMap.getTitle()
                .setText("'Risk Matrix in Project Server'")
                .setPadding(0d, 0d, 20d, 0d);

        riskMap.getLabels().setEnabled(true);
        riskMap.getLabels()
                .setMinFontSize(14d)
                .setFormat("function() {\n" +
                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
                        "      return namesList[this.heat];\n" +
                        "    }");

        riskMap.getYAxis().setStroke((Stroke) null, null, null, null, null);
        riskMap.getYAxis().getLabels().setPadding(0d, 15d, 0d, 0d);
        riskMap.getYAxis().setTicks(false);
        riskMap.getXAxis().setStroke((Stroke) null, null, null, null, null);
        riskMap.getXAxis().setTicks(false);

//        riskMap.getTooltip().getTitle().setUseHtml(true);
//        riskMap.getTooltip()
//                .setUseHtml(true)
//                .setTitleFormat("function() {\n" +
//                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
//                        "      return '<b>' + namesList[this.heat] + '</b> Residual Risk';\n" +
//                        "    }")
//                .setFormat("function () {\n" +
//                        "       return '<span style=\"color: #CECECE\">Likelihood: </span>' + this.x + '<br/>' +\n" +
//                        "           '<span style=\"color: #CECECE\">Consequence: </span>' + this.y;\n" +
//                        "   }");

        riskMap.setData(new String[] {
                "{x: 'Rare', y: 'Insignificant', heat: 0, fill: '#90caf9'}",
                "{x: 'Rare', y: 'Minor', heat: 0, fill: '#90caf9'}",
                "{x: 'Rare', y: 'Moderate', heat: 0, fill: '#90caf9'}",
                "{x: 'Rare', y: 'Major', heat: 0, fill: '#90caf9'}",
                "{x: 'Rare', y: 'Extreme', heat: 0, fill: '#90caf9'}",
                "{x: 'Unlikely', y: 'Insignificant', heat: 0, fill: '#90caf9'}",
                "{x: 'Unlikely', y: 'Minor', heat: 0, fill: '#90caf9'}",
                "{x: 'Unlikely', y: 'Moderate', heat: 0, fill: '#90caf9'}",
                "{x: 'Unlikely', y: 'Major', heat: 1, fill: '#ffb74d'}",
                "{x: 'Unlikely', y: 'Extreme', heat: 1, fill: '#ffb74d'}",
                "{x: 'Possible', y: 'Insignificant', heat: 0, fill: '#90caf9'}",
                "{x: 'Possible', y: 'Minor', heat: 0, fill: '#90caf9'}",
                "{x: 'Possible', y: 'Moderate', heat: 1, fill: '#ffb74d'}",
                "{x: 'Possible', y: 'Major', heat: 1, fill: '#ffb74d'}",
                "{x: 'Possible', y: 'Extreme', heat: 1, fill: '#ffb74d'}",
                "{x: 'Likely', y: 'Insignificant', heat: 0, fill: '#90caf9'}",
                "{x: 'Likely', y: 'Minor', heat: 1, fill: '#ffb74d'}",
                "{x: 'Likely', y: 'Moderate', heat: 1, fill: '#ffb74d'}",
                "{x: 'Likely', y: 'Major', heat: 2, fill: '#ef6c00'}",
                "{x: 'Likely', y: 'Extreme', heat: 2, fill: '#ef6c00'}",
                "{x: 'Almost\\nCertain', y: 'Insignificant', heat: 0, fill: '#90caf9'}",
                "{x: 'Almost\\nCertain', y: 'Minor', heat: 1, fill: '#ffb74d'}",
                "{x: 'Almost\\nCertain', y: 'Moderate', heat: 1, fill: '#ffb74d'}",
                "{x: 'Almost\\nCertain', y: 'Major', heat: 2, fill: '#ef6c00'}",
                "{x: 'Almost\\nCertain', y: 'Extreme', heat: 3, fill: '#d84315'}"
        }, TextParsingMode.CSV);

        anyChartView.setChart(riskMap);
    }
}
