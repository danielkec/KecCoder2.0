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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FileConvertor
 *
 * @author Daniel Kec <Daniel.Kec at syntea.cz>
 * @since Apr 26, 2010
 * @version 1.0
 * @class cz.syntea.kec.keccoder20.FileConvertor
 */
public class FileConvertor {

  private final File[] f;
  private final Charset from;
  private final Charset to;

  public FileConvertor(File[] f, Charset from, Charset to) {
	super();
	this.f = f;
	this.from = from;
	this.to = to;
  }

  public void convert() {
	for (int i = 0; i < f.length; i++) {
	  File file = f[i];
	  try {
		byte[] dataIn = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(dataIn);
		String a = new String(dataIn, from); // note use of constructor with charset to use for decoding bytes
		byte[] dataOut = a.getBytes(to); //dataOut is a byte array holding the value of a encoded into bytes using the specificed charset
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(dataOut);
		fos.close();
	  } catch (IOException ex) {
		Logger.getLogger(FileConvertor.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
  }
}
