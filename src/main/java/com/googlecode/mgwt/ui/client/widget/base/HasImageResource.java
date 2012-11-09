package com.googlecode.mgwt.ui.client.widget.base;

import com.google.gwt.resources.client.ImageResource;

/**
 * Widgets that implement this interface can change their icon
 *
 * @author Lasse Løvdahl
 * @version $Id: $
 */
public interface HasImageResource {

	/**
	 * @return the {@link com.google.gwt.resources.client.ImageResource} of the icon for this widget
	 */
	public ImageResource getIcon();

	/**
	 * Sets the icon of this widget.
	 * 
	 * @param the {@link com.google.gwt.resources.client.ImageResource} of the icon to be shown by this widget
	 */
	public void setIcon(ImageResource icon);
	
}
