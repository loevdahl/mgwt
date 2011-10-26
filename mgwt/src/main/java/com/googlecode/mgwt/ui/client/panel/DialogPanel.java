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
package com.googlecode.mgwt.ui.client.panel;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.DialogCss;
import com.googlecode.mgwt.ui.client.widget.base.ButtonBase;

public class DialogPanel extends Composite {

	private FlowPanel main;
	private FlowPanel container;
	private HTML title;
	private FlowPanel content;
	private FlowPanel buttonContainer;
	private OkButton okButton;
	private CancelButton cancelButton;
	private final DialogCss css;

	public DialogPanel() {
		this(MGWTStyle.getDefaultClientBundle().getDialogCss());
	}

	public DialogPanel(DialogCss css) {
		this.css = css;
		this.css.ensureInjected();
		main = new FlowPanel();
		initWidget(main);

		main.addStyleName(css.getDialogPanel());

		container = new FlowPanel();
		container.addStyleName(css.container());

		main.add(container);

		title = new HTML();
		title.addStyleName(css.title());
		container.add(title);

		content = new FlowPanel();
		content.addStyleName(css.content());
		container.add(content);

		buttonContainer = new FlowPanel();
		buttonContainer.addStyleName(css.footer());
		container.add(buttonContainer);

		okButton = new OkButton(css, "Ok");

		buttonContainer.add(okButton);

		cancelButton = new CancelButton(css, "Cancel");

		buttonContainer.add(cancelButton);

	}

	private class CancelButton extends ButtonBase {

		public CancelButton(DialogCss css, String text) {
			super(css);
			setText(text);
			addStyleName(css.cancelbutton());

		}

	}

	private class OkButton extends ButtonBase {

		public OkButton(DialogCss css, String text) {

			super(css);
			setText(text);
			addStyleName(css.okbutton());

		}

	}

	public HasWidgets getContent() {
		return content;
	}

	public HasSimpleTouchHandler getCancelButton() {
		return cancelButton;
	}

	public HasSimpleTouchHandler getOkButton() {
		return okButton;
	}

	public void showCancelButton(boolean show) {
		if (show) {
			int widgetCount = buttonContainer.getWidgetCount();
			if (widgetCount == 0) {
				buttonContainer.add(cancelButton);
			}
		} else {
			buttonContainer.remove(cancelButton);
		}
	}

	public void showOkButton(boolean show) {
		if (show) {
			buttonContainer.insert(okButton, 0);
		} else {
			buttonContainer.remove(okButton);
		}
	}

	public HasHTML getDialogTitle() {
		return title;
	}
}
