package lastfmhistoryguis;

import java.awt.*;

import java.awt.event.*;

import java.util.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import sas.samples.AutoCompleteDocument;
import lastfmhistoryclasses.*;

@SuppressWarnings("serial")
public class AutocompletePanel extends JPanel{
	
	public List<String> trackList = new ArrayList<String>();
	private List<String> artistList = new ArrayList<String>();
	private JButton defaultZoom;
	private JButton	medZoom;
	private JButton fullZoom;
	
	
	public AutocompletePanel(List<String> trackList, List<String> artistList){
		
		this.trackList = trackList;
		this.artistList = artistList;
		createAutocompletePanel();
		
	}
	
	public void createAutocompletePanel(){
		
		
		defaultZoom = new JButton ("Default");
		medZoom = new JButton("2000");
		fullZoom = new JButton("6000");
		
		this.add(defaultZoom);
		this.add(medZoom);
		this.add(fullZoom);
		
		/**
		 * Create the autocomplete track box
		 **/

		// List<String> testComplete = new ArrayList<String>();
		// testComplete.add();
		NameService nameTrackService = new NameService(trackList);
		JTextField trackInput = new JTextField();
		Document autoCompleteDocumentTrack = new AutoCompleteDocument(nameTrackService,	trackInput);
		trackInput.setDocument(autoCompleteDocumentTrack);
		trackInput.setColumns(25);
		this.add(trackInput);
		JButton trackGo = new JButton("Track");
		this.add(trackGo);
		
		NameService nameArtistService = new NameService(artistList);
		JTextField artistInput = new JTextField();
		Document autoCompleteDocumentArtist = new AutoCompleteDocument(nameArtistService,	artistInput);
		artistInput.setDocument(autoCompleteDocumentArtist);
		artistInput.setColumns(25);
		this.add(artistInput);
		JButton artistGo = new JButton("Track");
		this.add(artistGo);
		
		
	}
	public void addZoom2000(ActionListener zoom2000){
		medZoom.addActionListener(zoom2000);
	}

	
	
}
