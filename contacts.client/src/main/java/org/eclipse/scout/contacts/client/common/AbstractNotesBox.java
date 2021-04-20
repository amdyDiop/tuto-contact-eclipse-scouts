package org.eclipse.scout.contacts.client.common;

import org.eclipse.scout.contacts.shared.common.AbstractNotesBoxData;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.dto.FormData.DefaultSubtypeSdkCommand;
import org.eclipse.scout.rt.client.dto.FormData.SdkCommand;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;

@FormData(value = AbstractNotesBoxData.class, sdkCommand = SdkCommand.CREATE, defaultSubtypeSdkCommand = DefaultSubtypeSdkCommand.CREATE)

public class AbstractNotesBox extends AbstractGroupBox {

	private String notes;

	@FormData
	public String getNotes() {
		return this.notes;
	}

	@FormData
	public void setNote(String note) {
		this.notes = note;
	}

	@Override
	protected String getConfiguredLabel() {
		return TEXTS.get("Notes");
	}

	@Order(10)
	public class NotesField extends AbstractStringField {

		@Override
		protected int getConfiguredGridH() {
			return 4;
		}

		@Override
		protected boolean getConfiguredLabelVisible() {
			return false;
		}

		@Override
		protected boolean getConfiguredMultilineText() {
			return true;
		}
	}

}
