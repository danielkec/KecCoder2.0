/*
 *  Copyright 2009 Syntea software group a.s.
 * 
 *  This file may be used, copied, modified and distributed only in accordance
 *  with the terms of the limited licence contained in the accompanying
 *  file LICENSE.TXT.
 * 
 *  Tento soubor muze byt pouzit, kopirovan, modifikovan a siren pouze v souladu
 *  s licencnimi podminkami uvedenymi v prilozenem souboru LICENSE.TXT.
 */
package cz.syntea.kec.keccoder20;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * KecCodeQue
 *
 * @author Daniel Kec <Daniel.Kec at syntea.cz>
 * @since Apr 26, 2010
 * @version 1.0
 * @class cz.syntea.kec.keccoder20.KecCodeQue
 */
public class KecCodeQue extends ArrayList<File> {

  private static final long serialVersionUID = 412697388571408056L;
  private final DefaultTableModel _model;
  // private SortedMap<String, Charset>

  public KecCodeQue(DefaultTableModel model) {
	super();
	this._model = model;
  }

  private boolean isPresent(File f) {
	for (int i = 0; i < _model.getRowCount(); i++) {
	  File file = (File) _model.getValueAt(i, 1);
	  if (compareFiles(f, file)) {
		return true;
	  }
	}
	return false;
  }

  public void addFile(File f) {
	if (!isPresent(f)) {
	  _model.addRow(new Object[]{f.getName(), f});
	}
  }

  public File[] toFileArray() {
	File[] files = new File[_model.getRowCount()];
	for (int i = 0; i < files.length; i++) {
	  files[i] = (File) _model.getValueAt(i, 1);
	}
	return files;
  }

  public void removeFile(int row) {
	_model.removeRow(row);
  }

  public void removeAll() {
	int rows = _model.getRowCount();
	for (int i = 0; i < rows; i++) {
	  _model.removeRow(0);
	}
  }

  private boolean compareFiles(File f1, File f2) {
	return 0 == f1.compareTo(f2.getAbsoluteFile());
  }
}
