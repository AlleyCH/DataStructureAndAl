import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Visualization {
	double[] x = {};  // input array

	long startTime1 = System.nanoTime();
	//prefixAverage1(x);
	long endTime1 = System.nanoTime();
	long runtime1 = endTime1 - startTime1;

	long startTime2 = System.nanoTime();
//	prefixAverage2(x);
	long endTime2 = System.nanoTime();
	long runtime2 = endTime2 - startTime2;

	
	
	XYSeries series1 = new XYSeries("prefixAverage1");
	XYSeries series2 = new XYSeries("prefixAverage2");

	for (int i = 0; i < numberOfTests; i++) {
	    int inputSize = 50000;
	    double[] x = {};  // input array of size inputSize

	    long startTime1 = System.nanoTime();
	   // prefixAverage1(x);
	    long endTime1 = System.nanoTime();
	    long runtime1 = endTime1 - startTime1;

	    long startTime2 = System.nanoTime();
	 //   prefixAverage2(x);
	    long endTime2 = System.nanoTime();
	    long runtime2 = endTime2 - startTime2;

	    series1.add(Math.log(inputSize), Math.log(runtime1));
	    series2.add(Math.log(inputSize), Math.log(runtime2));
	    
	    XYDataset dataset = new XYSeriesCollection(series1);
	    ((XYSeriesCollection) dataset).addSeries(series2);

	    JFreeChart chart = ChartFactory.createXYLineChart("Runtime", "log(input size)", "log(time)", dataset, PlotOrientation.VERTICAL, true, true, false);

	    ChartPanel panel = new ChartPanel(chart);

	    JFrame frame = new JFrame("Runtime");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);

	}

}
