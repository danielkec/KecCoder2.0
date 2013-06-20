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

import java.nio.charset.Charset;
import java.util.SortedMap;
import javax.swing.DefaultComboBoxModel;

/**
 * CharsetComboBoxModel
 *
 * @author Daniel Kec <Daniel.Kec at syntea.cz>
 * @since Apr 26, 2010
 * @version 1.0
 * @class cz.syntea.kec.keccoder20.CharsetComboBoxModel
 */
public class CharsetComboBoxModel extends DefaultComboBoxModel {

  private static final long serialVersionUID = -8071339764674485900L;
  SortedMap<String, Charset> _sm = Charset.availableCharsets();

  public CharsetComboBoxModel() {
	super();
	Object[] keySet = _sm.keySet().toArray();
	for (int i = 0; i < _sm.size(); i++) {
	  this.addElement(keySet[i]);
	}
  }

  /**
   * Returns selected charset object
   * @return
   */
  public Charset getSelectedCharset() {
	return _sm.get((String)super.getSelectedItem());
  }

  public boolean setCharset(String name){
	try {
	  Charset ch = Charset.forName(name);
	  this.setSelectedItem(ch.displayName());
	  return true;
	} catch (Exception e) {
	  return false;
	}

  }

}
