package OptionDialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;

import Components.CButton;
import Components.CLabel;
import Components.CTabbedPane;
import Gui.JEditor;
import Layouts.FlowCustomLayout;

public class StatisticsDialog{

	private JDialog dialog;
	
	public StatisticsDialog(){
		init();
		addToDialog();
	}
	
	public void init(){
		dialog = new JDialog();
		dialog.setSize(new Dimension(500,400));
		dialog.setLocationRelativeTo(JEditor.frame);
		dialog.setModal(true);
		dialog.setTitle("Document statistics");
		dialog.setLayout(new BorderLayout());
	}
	
	public void show(){
		dialog.setVisible(true);
	}
	
	public void addToDialog(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(getWordCount());
		panel.add(getCharWithSpacesCount());
		panel.add(getCharWithoutSpacesCount());
		panel.add(getLineCount());
		panel.add(getPackageCount());
		dialog.add(panel , BorderLayout.CENTER);
		dialog.add(getBPanel() , BorderLayout.SOUTH);
	}
	
	public JPanel getBPanel(){
		JPanel bPanel = new JPanel(new FlowCustomLayout(FlowLayout.RIGHT));
		CButton close = new CButton("Close", "close this dialog", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
		CButton update = new CButton("Update", "update the fields", 'U', null, null);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		
		bPanel.add(update);
		bPanel.add(close);
		return bPanel;
	}
	
	public JPanel getWordCount(){
		JPanel panel = new JPanel(new FlowLayout());
		StringTokenizer st = new StringTokenizer(CTabbedPane.getInstance().getPanel().getTextArea().getText());
		CLabel lcount = new CLabel(st.countTokens()+"");
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Word count"));
		panel.add(lcount);
		return panel;
	}
	
	public JPanel getCharWithSpacesCount(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel count = new CLabel(CTabbedPane.getInstance().getPanel().getTextArea().getText().length()+"");
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Character count (with spaces)"));
		panel.add(count);
		return panel;
	}
	
	public JPanel getPackageCount(){
		JPanel panel = new JPanel(new FlowLayout());
		int packageCount = countPackages();
		JLabel count = new CLabel(packageCount + "");
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Package count"));
		panel.add(count);
		return panel;
	}
		
	private int countPackages() {
		String code = CTabbedPane.getInstance().getPanel().getTextArea().getText();
		int count = 0;
		String[] lines = code.split(System.getProperty("line.separator"));
		for (String line : lines) {
			if (line.trim().startsWith("import")) {
				count++;
			}
		}
		return count;
	}
		

	public JPanel getCharWithoutSpacesCount(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel count = new CLabel(CTabbedPane.getInstance().getPanel().getTextArea().getText().replace(" ", "").length()+"");
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Character count (without spaces)"));
		panel.add(count);
		return panel;
	}
	
	public JPanel getLineCount(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel count = new CLabel(CTabbedPane.getInstance().getPanel().getTextArea().getText().split(System.getProperty("line.separator")).length + "");
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Line count"));
		panel.add(count);
		return panel;
	}
}
