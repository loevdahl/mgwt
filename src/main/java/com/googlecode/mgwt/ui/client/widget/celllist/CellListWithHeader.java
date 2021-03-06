/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.ui.client.widget.celllist;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.googlecode.mgwt.ui.client.widget.CellList;

/**
 * A cell list with a header text
 * 
 * @author Daniel Kurka
 * @version $Id: $
 */
public class CellListWithHeader<T> extends Composite {
	private FlowPanel main;
	private CellList<T> cellList;
	private HTML header;

	/**
	 * Construct a cell list
	 * 
	 * @param cell
	 *            the cell to use for this cell list
	 */
	public CellListWithHeader(Cell<T> cell) {
		this(cell, MGWTStyle.getTheme().getMGWTClientBundle().getListCss());
	}

	/**
	 * Construct a cell list with a given cell and css
	 * 
	 * @param cell
	 *            the cell to use
	 * @param css
	 *            the css to use
	 */
	public CellListWithHeader(Cell<T> cell, ListCss css) {
		css.ensureInjected();
		main = new FlowPanel();

		initWidget(main);

		header = new HTML();
		header.setStylePrimaryName(css.listHeader());
		main.add(header);

		cellList = new CellList<T>(cell);
		main.add(cellList);
	}

	/**
	 * Get the header of the cell list
	 * 
	 * @return the header of the cell list
	 */
	public HasText getHeader() {
		return header;
	}

	/**
	 * Get the cell list
	 * 
	 * @return the cell list
	 */
	public CellList<T> getCellList() {
		return cellList;
	}
}
