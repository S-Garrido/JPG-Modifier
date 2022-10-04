package cmsc131PhotoLibrary;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RescaleHelpers {

	static public void rescaleGUI(JButton theButton, double displayScale) {
		Font f = theButton.getFont();
		Font newF = new Font(f.getName(), f.getStyle(), (int)(f.getSize()*displayScale));
		theButton.setFont(newF);		

		Dimension d = theButton.getPreferredSize();
		d.height*=displayScale;
		d.width*=displayScale;
		theButton.setPreferredSize(d);
	}
	static public void rescaleGUI(JRadioButton theRadioButton, double displayScale) {
		Font f = theRadioButton.getFont();
		Font newF = new Font(f.getName(), f.getStyle(), (int)(f.getSize()*displayScale));
		theRadioButton.setFont(newF);		

		Dimension d = theRadioButton.getPreferredSize();
		d.height*=displayScale;
		d.width*=displayScale;
		theRadioButton.setPreferredSize(d);
	}
	static public void rescaleGUI(JLabel theLabel, double displayScale) {
		Font f = theLabel.getFont();
		Font newF = new Font(f.getName(), f.getStyle(), (int)(f.getSize()*displayScale));
		theLabel.setFont(newF);		

		Dimension d = theLabel.getPreferredSize();
		d.height*=displayScale;
		d.width*=displayScale;
		theLabel.setPreferredSize(d);
	}
	static public void rescaleGUI(JTextField theTextField, double displayScale) {
		Font f = theTextField.getFont();
		Font newF = new Font(f.getName(), f.getStyle(), (int)(f.getSize()*displayScale));
		theTextField.setFont(newF);		

		Dimension d = theTextField.getMinimumSize();
		d.height*=displayScale;
		d.width*=(displayScale);
		theTextField.setMinimumSize(d);
	}
}
