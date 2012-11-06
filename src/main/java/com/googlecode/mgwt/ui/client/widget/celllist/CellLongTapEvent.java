/*
 * Copyright 2010 Lasse Løvdahl
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.ui.client.widget.celllist;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.GwtEvent;

/**
 * This event is fired when a cell {@link Cell} is long tapped
 * 
 * @author Lasse Loevdahl
 * @version $Id: $
 */
public class CellLongTapEvent extends GwtEvent<CellLongTapHandler> {

	private static final GwtEvent.Type<CellLongTapHandler> TYPE = new GwtEvent.Type<CellLongTapHandler>();
	private final int index;
	private final Element targetElement;

	/**
	 * Construct a cell long tapped event
	 * 
	 * @param index
	 *            the index of the cell that was selected
	 * @param targetElement
	 */
	public CellLongTapEvent(int index, Element targetElement) {
		this.index = index;
		this.targetElement = targetElement;
	}



	/** {@inheritDoc} */
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CellLongTapHandler> getAssociatedType() {
		return TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared
	 * .EventHandler)
	 */
	/** {@inheritDoc} */
	@Override
	protected void dispatch(CellLongTapHandler handler) {
		handler.onLongTap(this);
	}

	/**
	 * <p>
	 * getType
	 * </p>
	 * 
	 * @return a {@link com.google.gwt.event.shared.GwtEvent.Type} object.
	 */
	public static GwtEvent.Type<CellLongTapHandler> getType() {
		return TYPE;
	}

	/**
	 * get the index of the selected cell
	 * 
	 * @return the index of the tapped cell
	 */
	public int getIndex() {
		return index;
	}

	/**
   * The DOM element that was swiped
   * 
   * @return the {@link com.google.gwt.dom.client.Element} that fired the swipe
   */
	public Element getTargetElement() {
		return targetElement;
	}

}
