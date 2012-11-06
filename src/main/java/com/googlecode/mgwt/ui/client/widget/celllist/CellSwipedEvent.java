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
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent.DIRECTION;

/**
 * This event is fired when a cell {@link Cell} is swiped
 * 
 * @author Lasse Loevdahl
 * @version $Id: $
 */
public class CellSwipedEvent extends GwtEvent<CellSwipedHandler> {

	private static final GwtEvent.Type<CellSwipedHandler> TYPE = new GwtEvent.Type<CellSwipedHandler>();
	private final int index;
	private final Element targetElement;
	private final int startedAt;
	private final DIRECTION direction;
	private final int distance;

	/**
	 * Construct a cell swiped event
	 * 
	 * @param index
	 *            the index of the cell that was swiped
	 * @param targetElement
	 */
	public CellSwipedEvent(int index, Element targetElement, int startedAt, SwipeEvent.DIRECTION direction, int distance) {
		this.index = index;
		this.targetElement = targetElement;
		this.startedAt = startedAt;
		this.direction = direction;
		this.distance = distance;
	}

	public int getStartedAt() {
		return startedAt;
	}

	/**
	 * Returns the swipe direction.
	 * @return a {@link com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent.DIRECTION} enum telling the swipe direction.
	 */
	public DIRECTION getDirection() {
		return direction;
	}

	/**
	 * The swipe distance
	 * @return a int giving the swipe distance in pixel. 
	 */
	public int getDistance() {
		return distance;
	}

	/** {@inheritDoc} */
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CellSwipedHandler> getAssociatedType() {
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
	protected void dispatch(CellSwipedHandler handler) {
		handler.onCellSwiped(this);

	}

	/**
	 * <p>
	 * getType
	 * </p>
	 * 
	 * @return a {@link com.google.gwt.event.shared.GwtEvent.Type} object.
	 */
	public static GwtEvent.Type<CellSwipedHandler> getType() {
		return TYPE;
	}

	/**
	 * get the index of the swiped cell
	 * 
	 * @return the index of the swiped cell
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
