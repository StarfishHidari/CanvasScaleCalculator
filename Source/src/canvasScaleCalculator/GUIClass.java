package canvasScaleCalculator;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.awt.event.ItemEvent;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;

public class GUIClass {

	private JFrame frmCanvasSizeCalculator;
	private JTextField yResField;
	private JTextField xResField;
	private JTextField yOutField;
	private JTextField xOutField;
	private JTextField scaleField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIClass window = new GUIClass();
					window.frmCanvasSizeCalculator.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
				}
				catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public GUIClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCanvasSizeCalculator = new JFrame();
		frmCanvasSizeCalculator.getContentPane().setBackground(new Color(135, 206, 250));
		frmCanvasSizeCalculator.setTitle("Canvas Size Calculator");
		frmCanvasSizeCalculator.setResizable(false);
		frmCanvasSizeCalculator.setBounds(100, 100, 380, 440);
		frmCanvasSizeCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCanvasSizeCalculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Image Properties");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 108, 160, 14);
		frmCanvasSizeCalculator.getContentPane().add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 174, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYResolution = new JLabel("Y Res");
		lblYResolution.setBounds(10, 8, 54, 14);
		panel_1.add(lblYResolution);
		
		xResField = new JTextField();
		xResField.setBounds(69, 5, 86, 20);
		xResField.setColumns(10);
		panel_1.add(xResField);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 133, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblXResolution = new JLabel("X Res");
		lblXResolution.setBounds(10, 8, 54, 14);
		panel.add(lblXResolution);
		
		yResField = new JTextField();
		yResField.setBounds(69, 5, 86, 20);
		panel.add(yResField);
		yResField.setColumns(10);
		
		JLabel lblFinalScale = new JLabel("Final Scale");
		lblFinalScale.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalScale.setBounds(200, 108, 160, 14);
		frmCanvasSizeCalculator.getContentPane().add(lblFinalScale);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 174, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblYScale = new JLabel("Y Scale");
		lblYScale.setBounds(10, 8, 59, 14);
		panel_2.add(lblYScale);
		
		yOutField = new JTextField();
		yOutField.setBounds(56, 5, 86, 20);
		yOutField.setEditable(false);
		yOutField.setColumns(10);
		panel_2.add(yOutField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(200, 133, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblXScale = new JLabel("X Scale");
		lblXScale.setBounds(10, 8, 59, 14);
		panel_3.add(lblXScale);
		
		xOutField = new JTextField();
		xOutField.setBounds(56, 5, 86, 20);
		xOutField.setEditable(false);
		xOutField.setColumns(10);
		panel_3.add(xOutField);
		
		JTextPane txtpnToUseThis = new JTextPane();
		txtpnToUseThis.setEditable(false);
		txtpnToUseThis.setText("To use this calculator, put in the resolution of your image in the \"image properties\" section. You can browse for an image in order to automatically grab the resolution from it. If you would like to scale the image down, check the scale down button, and enter a value from 0.0 to 1.0. The results will be displayed in the Final Scale boxes, just plug them into TU!");
		txtpnToUseThis.setBounds(10, 291, 350, 109);
		frmCanvasSizeCalculator.getContentPane().add(txtpnToUseThis);
		
		// Scale Down checkbox changed
		//----------------------------------------------------------------------------------------------------------------------------
		
		JCheckBox chckbxScaleDown = new JCheckBox("Scale down?");
		chckbxScaleDown.setForeground(new Color(0, 0, 0));
		chckbxScaleDown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scaleField.setEditable(chckbxScaleDown.isSelected());
			}
		});
		
		//----------------------------------------------------------------------------------------------------------------------------
		chckbxScaleDown.setBounds(10, 211, 160, 23);
		frmCanvasSizeCalculator.getContentPane().add(chckbxScaleDown);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 241, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblScale = new JLabel("Scale");
		lblScale.setBounds(11, 8, 46, 14);
		panel_4.add(lblScale);
		
		scaleField = new JTextField();
		scaleField.setBounds(67, 5, 86, 20);
		scaleField.setEditable(false);
		scaleField.setColumns(10);
		panel_4.add(scaleField);
		
		// Calculate Scale button clicked
		//----------------------------------------------------------------------------------------------------------------------------
		
		JButton btnCalculateScale = new JButton("Calculate Scale");
		btnCalculateScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculations calc = new Calculations();
				int x, y;
				double scaleDown;
				String  xScale, yScale;
				try {
					x = Integer.parseInt(xResField.getText());
					y = Integer.parseInt(yResField.getText());
					
					
					if ( x < 0 || y < 0 ) {
						JOptionPane.showMessageDialog(null, "Error! Image sizes cannot be negative!");
					} else if ( x > 4*y || y > 4*x ) {
						JOptionPane.showMessageDialog(null, "Invalid image size! One side cannot be more than 4x larger than the other!");
					} else {
						
						if ( chckbxScaleDown.isSelected() == true ) {
							
							scaleDown = Double.parseDouble(scaleField.getText());
							if ( scaleDown <= 0.0 ) {
								
								scaleDown = 0.0;
								JOptionPane.showMessageDialog(null, "Please enter a scale that is not zero or negative!");
								
							} else {
								
								if ( scaleDown > 1.0 ) {
									scaleDown = 1.0;
								}
								
								xScale = String.format("%.2g%n", calc.calculateCanvasScaleDownX(calc.calculateCanvasScale(x, y), scaleDown));
								yScale = String.format("%.2g%n", calc.calculateCanvasScaleDownY(calc.calculateCanvasScale(x, y), scaleDown));
								xOutField.setText(xScale);
								yOutField.setText(yScale);
								
							}
							
						} else {
							
							if ( x < y ) {
								xScale = String.format("%.2g%n", calc.calculateCanvasScale(x, y));
								yScale = String.format("%.2g%n", 1.0);
							} else {
								xScale = String.format("%.2g%n", 1.0);
								yScale = String.format("%.2g%n", calc.calculateCanvasScale(x, y));
							}
							
							xOutField.setText(xScale);
							yOutField.setText(yScale);
							
						}
						
						
					}
					
					
				} catch (Exception error) {
					System.out.println(Integer.parseInt(xResField.getText()));
					System.out.println(Integer.parseInt(yResField.getText()));
					JOptionPane.showMessageDialog(null, "Invalid number! Please enter a whole number!");
					error.printStackTrace();
				}
			}
		});
		
		//----------------------------------------------------------------------------------------------------------------------------
		btnCalculateScale.setBounds(200, 241, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(btnCalculateScale);
		
		JTextPane fileDisplay = new JTextPane();
		fileDisplay.setEditable(false);
		fileDisplay.setText("File Selected:");
		fileDisplay.setBounds(10, 52, 350, 45);
		frmCanvasSizeCalculator.getContentPane().add(fileDisplay);
		
		// Browse for image
		//----------------------------------------------------------------------------------------------------------------------------
		
		JFileChooser filePicker = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter( "Image files", ImageIO.getReaderFileSuffixes());
		JButton btnBrowseForImage = new JButton("Browse for Image");
		
		btnBrowseForImage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				filePicker.setFileFilter(filter);
				filePicker.showOpenDialog(frmCanvasSizeCalculator);
				File path = filePicker.getSelectedFile();
				
				
				if (path != null) {
					
					if (path.exists() == true) {
						fileDisplay.setText("File selected: " + path);
						try {
							BufferedImage image = ImageIO.read(path);
							xResField.setText(Integer.toString(image.getWidth()));
							yResField.setText(Integer.toString(image.getHeight()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "File does not exist!");
					}
					
				}
			}
		});
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		
		btnBrowseForImage.setBounds(10, 11, 160, 30);
		frmCanvasSizeCalculator.getContentPane().add(btnBrowseForImage);
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
