package fr.epita.tests;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.*;

public class ChartUtils {

    //only for demo
    public static void main(String[] args) {
        //XYChart chart = getFakeDataScatterPlot();

        CategoryChart chart = getBarChart("Gender distribution", "gender", "count");

        chart.addSeries("gender",
                    Arrays.asList("M", "F"),
                    Arrays.asList(11, 7)
        );
        displayChart(chart);
    }

    public static void displayChart(CategoryChart chart) {
        new SwingWrapper<>(chart).displayChart();
    }

    public static CategoryChart getBarChart(String name,String xTitle, String yTitle){
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title(name)
                .xAxisTitle(xTitle)
                .yAxisTitle(yTitle)
                .build();
        return chart;
    }

    public static XYChart getFakeDataScatterPlot() {

        // Create Chart
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);

        // Series
        List<Double> xData = new LinkedList<Double>();
        List<Double> yData = new LinkedList<Double>();
        List<Double> xData2 = new LinkedList<Double>();
        List<Double> yData2 = new LinkedList<Double>();
        Random random = new Random();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            xData.add(random.nextGaussian() / 1000 );
            xData2.add(random.nextGaussian() / 1200 );
            yData.add(-1000000 + random.nextGaussian());
            yData2.add(-1000010 + random.nextGaussian());
        }
        chart.addSeries("Gaussian Blob", xData, yData);
        chart.addSeries("Other Gaussian Blob", xData2, yData2);

        return chart;
    }


}
